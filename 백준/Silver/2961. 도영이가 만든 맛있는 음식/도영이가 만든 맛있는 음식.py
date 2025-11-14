import sys

def solve():
    N = int(sys.stdin.readline())
    ## 신맛 쓴맛
    arr = [ (*map(int, sys.stdin.readline().split()), ) for _ in range(N)]
    
    def dfs(a, b, index, min_dif):
        if not (a == 1 and b == 0):
            min_dif = min(min_dif, abs(a-b))
            
        if index >= N:
            return min_dif
        
        for i in range(index, N):
            min_dif = min(min_dif, dfs(a*arr[i][0], b+arr[i][1], i+1, min_dif))
        
        return min_dif
        
    min_dif = dfs(1, 0, 0, 1_000_000_001)
    print(min_dif)
    
if __name__ == "__main__":
    solve()