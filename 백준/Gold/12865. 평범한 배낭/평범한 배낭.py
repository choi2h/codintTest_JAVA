import sys

def solve():
    count, max_weight = map(int, sys.stdin.readline().split())
    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(count)]
    dp = [[0] * (max_weight+1) for _ in range(count+1)]

    for j in range(1, count+1):
        w, k = arr[j-1]
        for weight in range(max_weight+1):
            if weight < w:
                dp[j][weight] = dp[j-1][weight]
            else:
                dp[j][weight] = max(dp[j-1][weight], dp[j-1][weight-w] + k)
    
    
    print(max(dp[count]))
    
if __name__ == "__main__":
    solve()