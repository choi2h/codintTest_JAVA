import sys

def solve():
    N = int(sys.stdin.readline())
    check_y = [False]*N
    check_left = [False]* (N*2)
    check_right = [False]* (N*2)
    
    total_cnt = 0
    def dfs(x):
        nonlocal total_cnt
        
        for y in range(N):
            cl, cr = x+y, x-y+N
            if check_y[y] or check_left[cl] or check_right[cr]:
                continue
            
            check_y[y], check_left[cl], check_right[cr] = True, True, True
            if x == N-1:
                total_cnt += 1
            else:
                dfs(x+1)
            check_y[y], check_left[cl], check_right[cr] = False, False, False
    
    dfs(0)
    return total_cnt
    
if __name__ == "__main__":
    print(solve())