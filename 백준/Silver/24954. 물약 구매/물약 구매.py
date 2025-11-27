import sys
from functools import lru_cache

def solve():
    N = int(sys.stdin.readline())
    coins = list(map(int, sys.stdin.readline().split()))
    discounts = [[] for _ in range(N)]
    for i in range(N):
        cnt = int(sys.stdin.readline())
        for _ in range(cnt):
            a, b = map(int, sys.stdin.readline().split())
            discounts[i].append((a-1, b))
    
    min_coin = 1_000 * 10
    ALL = (1<<N) - 1
    sum_discount_coin = [0] * N
    
    @lru_cache(maxsize=None)
    def dfs(visited, use_coin):
        nonlocal min_coin
        if visited == ALL:
            min_coin = min(use_coin, min_coin)
        
        for i in range(N):
            if visited & (1<<i):
                continue
            
            coin = coins[i]-sum_discount_coin[i]
            coin = use_coin+(1 if coin <= 0 else coin)
            if min_coin <= coin:
                continue
            
            visited |= (1<<i)
            for d in discounts[i]:
                sum_discount_coin[d[0]] += d[1]
            dfs(visited, coin)
            for d in discounts[i]:
                sum_discount_coin[d[0]] -= d[1]
            visited &= ~(1<<i)
    
    dfs(0, 0)
    print(min_coin)
if __name__ == "__main__":
    solve()