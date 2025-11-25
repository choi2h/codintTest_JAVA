import sys

def solve():
    N = int(sys.stdin.readline())
    weights = list(map(int, sys.stdin.readline().split()))
    
    M = int(sys.stdin.readline())
    checks = list(map(int, sys.stdin.readline().split()))
    
    max_weight = sum(weights)
    records = [[False] * (max_weight+1) for _ in range(N+1)]
    records[0][0] = True
    for i in range(N):
        cur = weights[i]
        for j in range(max_weight+1):
            if not records[i][j]:
                continue
            
            records[i+1][j] = True
            if j+cur <= max_weight:
                records[i+1][j+cur] = True
            if j-cur >= 0:
                records[i+1][j-cur] = True
            if cur-j >= 0:
                records[i+1][cur-j] = True
    
    answer = []
    for check in checks:
        answer.append("Y" if check <= max_weight and records[N][check] else "N")
    
    print(" ".join(answer))
    
if __name__ == "__main__":
    solve()