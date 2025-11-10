import sys

def solve():
    n = int(sys.stdin.readline())
    
    arr = []
    l = 1
    for r in range(1, 100_001):
        r_pow = r * r
        l_pow = l * l
        
        while r_pow - l_pow > n and l < r:
            l += 1
            l_pow = l * l
        
        if r_pow - l_pow == n:
            arr.append(r)
        
    if arr:  
        print(*arr, sep='\n')
    else:
        print(-1)

if __name__ == "__main__":
    solve()