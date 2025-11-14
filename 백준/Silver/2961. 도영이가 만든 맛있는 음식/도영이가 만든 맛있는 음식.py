import sys

def solve():
    N = int(sys.stdin.readline())
    ## 신맛 쓴맛
    arr = [ (*map(int, sys.stdin.readline().split()), ) for _ in range(N)]
    
    min_dif = 1_000_000_001
    def dfs(a, b, index):
        nonlocal min_dif
        
        if index > 0:
            min_dif = min(min_dif, abs(a-b))
            
        if index >= N:
            return
        
        for i in range(index, N):
            dfs(a*arr[i][0], b+arr[i][1], i+1)
        
    dfs(1, 0, 0)
    print(min_dif)
    
if __name__ == "__main__":
    solve()