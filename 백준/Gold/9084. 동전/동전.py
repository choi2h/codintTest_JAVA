import sys

def solve():
    T = int(sys.stdin.readline())

    answer = []
    for _ in range(T):
        N = int(sys.stdin.readline())
        coins = list(map(int, sys.stdin.readline().split()))
        
        target = int(sys.stdin.readline())
        dp = [0]*(target+1)
        dp[0] = 1
        
        for coin in coins:
            for i in range(coin, target+1):
                dp[i] += dp[i-coin]
        
        answer.append(dp[target])
    
    print("\n".join(str(a) for a in answer))
 
if __name__ == "__main__":
    solve()