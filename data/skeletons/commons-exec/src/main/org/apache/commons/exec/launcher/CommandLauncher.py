from __future__ import annotations

# Imports Begin
from src.main.org.apache.commons.exec.CommandLine import *
import typing
from typing import *
import io
import pathlib
from abc import ABC

# Imports End


class CommandLauncher(ABC):

    # Class Fields Begin
    # Class Fields End

    # Class Methods Begin
    def isFailure(self, exitValue: int) -> bool:
        pass

    def exec1(
        self,
        commandLine: CommandLine,
        env: typing.Dict[str, str],
        workingDirectory: pathlib.Path,
    ) -> subprocess.Popen:
        pass

    def exec0(
        self, commandLine: CommandLine, env: typing.Dict[str, str]
    ) -> subprocess.Popen:
        pass

    # Class Methods End
