from __future__ import annotations

# Imports Begin
from src.main.org.apache.commons.exec.launcher.CommandLauncherImpl import *
from src.main.org.apache.commons.exec.environment.EnvironmentUtils import *
from src.main.org.apache.commons.exec.CommandLine import *
import typing
from typing import *
import io
import pathlib

# Imports End


class Java13CommandLauncher(CommandLauncherImpl):

    # Class Fields Begin
    # Class Fields End

    # Class Methods Begin
    def exec1(
        self, cmd: CommandLine, env: typing.Dict[str, str], workingDir: pathlib.Path
    ) -> subprocess.Popen:
        pass

    def __init__(self) -> None:
        pass

    # Class Methods End
