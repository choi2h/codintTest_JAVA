import sys
from itertools import product

def solve():
    N, M = map(int, sys.stdin.readline().split())
    result = []
    for p in product(range(1, N+1), repeat=M):
        result.append(" ".join(map(str, p)))
    answer = '\n'.join(result)
    print(answer)

if __name__ == "__main__":
    solve()