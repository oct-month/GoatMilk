import os

TARGET = "./GoatMilkFile"
EXCLUDE = [
    "__pycache__",
    ".mypy_cache",
    ".venv",
    ".vscode",
    "static"
]

TARGET = './GoatMilkPowder'
EXCLUDE = [
    'HELP.md',
    'target',
    '.mvn',
    '.apt_generated',
    '.classpath',
    '.factorypath',
    '.project',
    '.settings',
    '.springBeans',
    '.sts4-cache',
    '.idea',
    '.iws',
    '.iml',
    '.ipr',
    'nbproject',
    'nbbuild',
    'dist',
    'nbdist',
    '.nb-gradle',
    'build',
    '.vscode',
    '.mypy_cache',
    '__pycache__',
]

TARGET = "./mysql"
EXCLUDE = []

TARGET = "./nginx"
EXCLUDE = []

TARGET = "./redis"
EXCLUDE = []

TARGET = "./"
EXCLUDE = [
    '.mypy_cache',
    '.venv',
    '__pycache__',
    'GoatMilkFile',
    'GoatMilkPowder',
    'GoatMilkWeb',
    'mysql',
    'nginx',
    'redis',
    '.git'
]

TARGET = "./GoatMilkWeb"
EXCLUDE = [
    '.DS_Store',
    'node_modules',
    'dist',
    'target',
    'env',
    'npm-debug.log',
    'yarn-debug.log',
    'yarn-error.log',
    'pnpm-debug.log',
    '.idea',
    '.vscode',
    '.suo',
    '.ntvs',
    '.njsproj',
    '.sln',
    '.sw',
    'package-lock.json',
    'assets',
    'public'
]

result = 0

def go(path: str) -> None:
    global result
    for e in EXCLUDE:
        if e in path:
            return
    for p in os.listdir(path):
        t = os.path.join(path, p)
        if os.path.isdir(t):
            go(t)
        elif os.path.isfile(t):
            with open(t, 'r', encoding='UTF-8') as f:
                result += len(f.readlines())


if __name__ == '__main__':
    go(TARGET)
    print(result)

# 669
# 3487
# 19
# 96
# 5
# 857