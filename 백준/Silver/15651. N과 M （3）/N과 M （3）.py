import sys

result = []

def solve():
    N, M = map(int, sys.stdin.readline().split())
    record = [0] * M
    dfs(N, M, record, 0)
    answer = '\n'.join(result)
    print(answer)


def dfs(N, M, cur, cnt):
    for i in range(1, N+1):
        cur[cnt] = i
        if cnt+1 == M:
            result.append(" ".join(map(str, cur)))
        else :
            dfs(N, M, cur, cnt+1)

if __name__ == "__main__":
    solve()