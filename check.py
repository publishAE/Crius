import sys

from lark import Lark


def main():
    sys.setrecursionlimit(10000)
    if len(sys.argv) > 2:
        grammar = r"".join(open(sys.argv[1]).readlines())

        parser = Lark(grammar)
        try:
            parser.parse(sys.argv[2])
            print(1)
        except Exception as e:
            print(0)

if __name__ == '__main__':
    main()