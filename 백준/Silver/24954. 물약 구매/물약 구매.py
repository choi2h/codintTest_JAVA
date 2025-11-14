import sys

def solve():
    N = int(sys.stdin.readline())
    coins = list(map(int, sys.stdin.readline().split()))
    discounts = [[]] * N
    for i in range(N):
        cnt = int(sys.stdin.readline())
        if cnt > 0:
            discounts[i] = [(*map(int, sys.stdin.readline().split()),) for _ in range(cnt)]
    
    min_coin = 1_000 * 10
    sum = [0] * N
    def dfs(visited, use_coin):
        nonlocal coins, discounts, min_coin, sum
        if visited == (1<<N) - 1:
            min_coin = min(use_coin, min_coin)
        
        
        
        for i in range(N):
            if visited & (1<<i):
                continue
            
            coin = use_coin+(1 if coins[i]-sum[i] <= 0 else coins[i]-sum[i])
            if min_coin <= use_coin:
                continue
            
            visited |= (1<<i)
            for d in discounts[i]:
                sum[d[0]-1] += d[1]
            dfs(visited, coin)
            for d in discounts[i]:
                sum[d[0]-1] -= d[1]
            visited &= ~(1<<i)
    
    dfs(0, 0)
    print(min_coin)
if __name__ == "__main__":
    solve()