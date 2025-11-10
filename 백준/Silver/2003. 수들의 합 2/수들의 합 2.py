import sys

def solve():
    n, m = map(int, sys.stdin.readline().split())
    
    nums = list(map(int, sys.stdin.readline().split()))
    
    l, sum, cnt = 0, 0, 0
    for r in range(n):
        sum += nums[r]
       
        while sum > m and l < r:
           sum -= nums[l]
           l += 1
            
        if sum == m:
            cnt += 1    
    
    print(cnt)
    
    
    
    
if __name__ == "__main__":
    solve()