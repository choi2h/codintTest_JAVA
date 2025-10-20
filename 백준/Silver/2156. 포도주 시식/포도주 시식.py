import sys

def solve():
    input = sys.stdin.readline
    n = int(input().strip())
    tables = [int(input().strip()) for _ in range(n)]
        
    if n==1:
        print(tables[0])
        return
    elif n==2:
        print(tables[0]+tables[1])
        return
        
    ## 길이가 n인 배열을 0으로 초기화함
    wine = [0] * n
    wine[0] = tables[0]
    wine[1] = tables[0] + tables[1]
    wine[2] = max(wine[1], wine[0]+tables[2], tables[1] + tables[2])
    for i in range(3, n):
        wine[i] = max(wine[i-1], wine[i-2]+tables[i], wine[i-3]+tables[i-1]+tables[i])
    
    print(wine[n-1])
    
## 진입점
if __name__ == "__main__" :
    solve()