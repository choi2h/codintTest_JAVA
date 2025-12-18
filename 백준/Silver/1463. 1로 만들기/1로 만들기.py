import sys

def solve():
    N = int(sys.stdin.readline())
    INF = 1_000_001
    
    dp = [INF]*(N+1)
    dp[1] = 0
    for n in range(N+1):
        if n%3 == 0:
            dp[n] = min(dp[n//3]+1, dp[n])
        if n%2 == 0:
            dp[n] = min(dp[n//2]+1, dp[n])
        
        dp[n] = min(dp[n-1]+1, dp[n])
            
    return dp[N]

if __name__ == "__main__":
    print(solve())