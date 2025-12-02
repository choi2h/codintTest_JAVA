import sys
from collections import deque

CHECK_POINTS = [(-1, 0), (0, -1), (1, 0), (0, 1)]

def solve():
    N, M = map(int, sys.stdin.readline().split())
    total_tomato_cnt = 0
    tomatos = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
    done_tomatos = deque()
    for x in range(M):
        for y in range(N):
            if tomatos[x][y] != -1: 
                total_tomato_cnt += 1
                if tomatos[x][y] == 1: 
                    done_tomatos.append((x, y))
                    
    if total_tomato_cnt == len(done_tomatos):
        return 0
    
    check_days = [[0] * N for _ in range(M)]
    check(N, M, done_tomatos, tomatos, check_days)
        
    return get_max_day(N, M, tomatos, check_days)
    
def check(N, M, done_tomatos, tomatos, check_days):
    while done_tomatos:
       cur_x, cur_y = done_tomatos.popleft()
       for cx, cy in CHECK_POINTS:
            mx, my = cur_x + cx, cur_y + cy
            if 0 <= mx < M and 0 <= my < N and tomatos[mx][my] == 0:
                tomatos[mx][my] = 1
                check_days[mx][my] = check_days[cur_x][cur_y]+1
                done_tomatos.append((mx, my))
 
def get_max_day(N, M, tomatos, check_days):
    max_day_cnt = 0
    for x in range(M):
        for y in range(N):
            if tomatos[x][y] == 0:
                return -1
            
            max_day_cnt = max(max_day_cnt, check_days[x][y])     
            
    return max_day_cnt
                
if __name__ == "__main__":
    print(solve())