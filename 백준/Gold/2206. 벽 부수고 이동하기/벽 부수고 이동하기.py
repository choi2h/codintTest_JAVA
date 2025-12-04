import sys
from collections import deque

MOVES = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def solve():
    N, M = map(int, sys.stdin.readline().split())
    board = [[ int(i) for i in sys.stdin.readline().strip()] for _ in range(N)]
    check_cnt = [[[0] * 2 for _ in range(M)] for _ in range(N)]
    check_cnt[0][0][0] = 1
    
    queue = deque()
    queue.append((0,0,0))
    
    while queue:
        isBreak, x, y = queue.popleft()
        
        for move in MOVES:
            mx = x + move[0]
            my = y + move[1]
            
            if 0 <= mx < N and 0 <= my < M:

                if board[mx][my] == 0 and check_cnt[mx][my][isBreak] == 0:                
                    check_cnt[mx][my][isBreak] = check_cnt[x][y][isBreak]+1
                    queue.append((isBreak, mx, my))
                elif isBreak == 0 and board[mx][my] == 1 and check_cnt[mx][my][isBreak] == 0:
                    check_cnt[mx][my][1] = check_cnt[x][y][isBreak]+1
                    queue.append((1, mx, my))
    
    a, b = check_cnt[N-1][M-1]
    if a > 0 and b > 0:
        return min(a,b)
    return a if a > 0 else b if b > 0 else -1
     
    
    
if __name__ == "__main__":
    print(solve())