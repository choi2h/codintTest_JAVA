import sys
N = int(sys.stdin.readline())

dp = [1, 2]

for i in range(2, N+1):
    dp.append(dp[i-1] + dp[i-2])

print(dp[N-1] % 10007)