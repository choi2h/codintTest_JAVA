import sys
from collections import deque
from queue import PriorityQueue

MOVES = [(-1, 0), (0, -1), (0, 1), (1, 0)]

def solve():
    N, M, F = map(int, sys.stdin.readline().split())
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    tx, ty = (map(int, sys.stdin.readline().split()))
    taxi = (tx-1, ty-1)
    targets = [0, 0]
    for i in range(2, M+2):
        sx, sy, ex, ey = map(int, sys.stdin.readline().split())
        sx, sy, ex, ey = sx-1, sy-1, ex-1, ey-1
        board[sx][sy] = i
        targets.append(((sx, sy), (ex,ey)))
        
    done_cnt = 0
    while F > 0 and done_cnt < M:
        dist, target_idx = get_target(N, board, taxi)
        if dist == -1 or dist >= F:
            return -1
        
        F -= dist
        
        start, end = targets[target_idx]
        move_dist = get_dist(N, board, start, end)
        if move_dist == 0 or move_dist > F:
            return -1
        
        board[start[0]][start[1]] = 0
        F += move_dist
        taxi = end
        done_cnt += 1
    
    return F
 
def get_dist(N, board, start, end):
    dist_boad = [[0] * N for _ in range(N)]
    
    queue = deque()
    queue.append(start)
    
    while queue:
        x, y = queue.popleft()
        
        for move in MOVES:
            mx, my = x+move[0], y+move[1]
            if (0 <= mx < N and 0 <= my < N 
                and board[mx][my] != 1 and dist_boad[mx][my] == 0):
                if mx == end[0] and my == end[1]:
                    return dist_boad[x][y]+1
                
                dist_boad[mx][my] = dist_boad[x][y]+1
                queue.append((mx, my))
    
    return 0

def get_target(N, board, start):
    dist_boad = [[0] * N for _ in range(N)]
    
    queue = PriorityQueue()
    queue.put((0, *start))
    while not queue.empty():
        dist, x, y = queue.get()
        
        if board[x][y] > 1:
            return (dist, board[x][y])
        
        for move in MOVES:
            mx, my = x+move[0], y+move[1]
            if (0 <= mx < N and 0 <= my < N 
                and dist_boad[mx][my] == 0 and board[mx][my] != 1):
                dist_boad[mx][my] = dist+1
                queue.put((dist+1, mx, my))
    
    return (-1, -1)
                
                
if __name__ == "__main__":
    print(solve())