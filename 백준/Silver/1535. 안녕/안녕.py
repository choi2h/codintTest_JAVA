import sys

def solve():
    N = int(sys.stdin.readline())
    MAX_HEALTH = 100
    health_potins = list(map(int, sys.stdin.readline().split()))
    happy_points = list(map(int, sys.stdin.readline().split()))
    
    dp = [[0] * MAX_HEALTH for _ in range(N+1)]
    for i in range(N):
        cur_health = health_potins[i]
        cur_happy = happy_points[i]
        for j in range(MAX_HEALTH):
            dp[i+1][j] = max(dp[i][j], dp[i+1][j])
            if j+cur_health < MAX_HEALTH:
                dp[i+1][j+cur_health] = dp[i][j]+cur_happy
    
    print(max(dp[N]))
    
if __name__ == "__main__":
    solve()             