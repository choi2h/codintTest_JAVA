import sys

result = []

def solve():
    N, M = map(int, sys.stdin.readline().split())
    dfs(N, M, [], 0)
    answer = '\n'.join(result)
    print(answer)


def dfs(N, M, cur, cnt):
    if cnt == M:
        result.append(" ".join(map(str, cur)))
        return
    
    for i in range(1, N+1):
        cur.append(i)
        dfs(N, M, cur, cnt+1)
        cur.pop()



if __name__ == "__main__":
    solve()