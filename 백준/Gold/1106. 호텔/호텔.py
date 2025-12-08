import sys

INF = 100_001

def solve():
    C, N = map(int, sys.stdin.readline().split())
    cities = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    
    check = [INF] * (C+1)
    for coin, num in cities:
        tmp = check.copy()
        
        for i in range(C+1):
            if i < num:
                tmp[i] = min(tmp[i], coin)
            
            if i%num == 0:
                tmp[i] = min(tmp[i], coin*(i//num))
            
            if i < C:
                idx = i+num if i+num <= C else C
                tmp[idx] = min(tmp[idx], tmp[i]+coin)
        check = tmp
    
    return check[C]
    
    
    
if __name__ == "__main__":
    print(solve())