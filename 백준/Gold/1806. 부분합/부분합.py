import sys

MAX_DIF = 100_001

def solve():
    N, S = map(int, sys.stdin.readline().split())
    nums = list(map(int, sys.stdin.readline().split()))
    
    l, sum, min_len = 0, 0, MAX_DIF
    for r in range(N):
        sum += nums[r]
        
        while sum >= S:
            min_len = min(min_len, r-l+1)
            sum -= nums[l]
            l += 1
         
    print(min_len if min_len != MAX_DIF else 0)
    
    
if __name__ == "__main__":
    solve()