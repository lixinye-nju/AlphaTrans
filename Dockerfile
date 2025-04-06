FROM ubuntu:22.04

# Set proxy environment variables globally
ENV http_proxy=http://172.26.93.30:7890
ENV https_proxy=http://172.26.93.30:7890
ENV HTTP_PROXY=http://172.26.93.30:7890
ENV HTTPS_PROXY=http://172.26.93.30:7890

# Configure apt to use proxy
RUN echo 'Acquire::http::Proxy "http://172.26.93.30:7890";' > /etc/apt/apt.conf.d/proxy.conf && \
    echo 'Acquire::https::Proxy "http://172.26.93.30:7890";' >> /etc/apt/apt.conf.d/proxy.conf

RUN apt-get update && apt-get install -y \
    python3.11 \
    python3-pip \
    git \
    wget \
    curl \
    zip \
    unzip \
    rsync \
    vim \
    && rm -rf /var/lib/apt/lists/*

RUN arch=$(uname -m) && \
    if [ "$arch" = "x86_64" ]; then \
    MINICONDA_URL="https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh"; \
    elif [ "$arch" = "aarch64" ]; then \
    MINICONDA_URL="https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-aarch64.sh"; \
    else \
    echo "Unsupported architecture: $arch"; \
    exit 1; \
    fi && \
    wget $MINICONDA_URL -O miniconda.sh && \
    mkdir -p /root/.conda && \
    bash miniconda.sh -b -p /root/miniconda3 && \
    rm -f miniconda.sh

ENV PATH="/root/miniconda3/bin:${PATH}"

RUN pip3 install --upgrade pip

WORKDIR /home

RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
RUN tar xzvf apache-maven-3.9.9-bin.tar.gz
ENV PATH="/home/apache-maven-3.9.9/bin:${PATH}"
RUN rm apache-maven-3.9.9-bin.tar.gz

RUN git clone https://github.com/Intelligent-CAT-Lab/AlphaTrans.git

WORKDIR /home/AlphaTrans

SHELL ["/bin/bash", "-c"]

RUN conda init bash

RUN echo "source /root/.bashrc && conda activate alphatrans" > /etc/profile.d/conda.sh && \
    echo "conda activate alphatrans" >> ~/.bashrc

RUN conda env create -f environment.yaml

RUN bash scripts/install_graal.sh
ENV JAVA_HOME="/root/.sdkman/candidates/java/current"

RUN mkdir -p /home/AlphaTrans/misc/sitter-libs
RUN git clone https://github.com/tree-sitter/tree-sitter-java.git /home/AlphaTrans/misc/sitter-libs/java
RUN git clone https://github.com/tree-sitter/tree-sitter-python.git /home/AlphaTrans/misc/sitter-libs/python

RUN mkdir -p /home/AlphaTrans/misc/java-callgraph
RUN git clone https://github.com/gousiosg/java-callgraph.git /home/AlphaTrans/misc/java-callgraph
WORKDIR /home/AlphaTrans/misc/java-callgraph

# Configure Maven to use proxy
RUN mkdir -p /root/.m2 \
    && echo '<settings><proxies><proxy><id>https-proxy</id><active>true</active><protocol>http</protocol><host>172.26.93.30</host><port>7890</port></proxy></proxies></settings>' > /root/.m2/settings.xml

RUN mvn clean install -DskipTests

WORKDIR /home/AlphaTrans

RUN wget https://github.com/github/codeql-action/releases/download/codeql-bundle-v2.20.0/codeql-bundle-linux64.tar.gz
RUN tar -xvf codeql-bundle-linux64.tar.gz -C /home/AlphaTrans/misc
RUN rm codeql-bundle-linux64.tar.gz
ENV PATH="/home/AlphaTrans/misc/codeql:$PATH"

RUN git clone https://github.com/github/vscode-codeql-starter.git
WORKDIR /home/AlphaTrans/vscode-codeql-starter
RUN git submodule update --init --remote
WORKDIR /home/AlphaTrans/vscode-codeql-starter/ql
RUN git checkout 3b2e55bc2ac942ac2cf2646f5c69acd081ce8ea2

WORKDIR /home/AlphaTrans
RUN cp queries/* vscode-codeql-starter/codeql-custom-queries-java

RUN bash scripts/download_original_projects.sh

RUN bash scripts/build_java_projects.sh
