import sys
from collections import deque
from queue import PriorityQueue

def solve():
    N = int(sys.stdin.readline())
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    shark = ()
    fish_cnt = 0
    for x in range(N):
        for y in range(N):
            if board[x][y] == 9:
                shark = (x, y)
                board[x][y] = 0
            elif board[x][y] > 0:
                fish_cnt += 1
    
    if fish_cnt == 0:
        return 0
    
    return bfs(N, shark, 2, board, fish_cnt)

def bfs(N, shark, size, board, fish_cnt):
    queue = deque()
    queue.append(shark)
    
    time = 0
    eat_cnt, total_eat_cnt = 0, 0
    while queue:
        cur = queue.popleft()
        board[cur[0]][cur[1]] = -1
        next = get_next(N, board, cur, size)  
        
        if next == None:
            return time
        
        queue.append(next[0])
        time += next[1]-1
        eat_cnt += 1
        total_eat_cnt += 1
        if size == eat_cnt:
            eat_cnt = 0
            size += 1
            
        if total_eat_cnt == fish_cnt:
            return time
    
    return time
        
        

MOVES = [(-1, 0), (0, -1), (0, 1), (1, 0)]

def get_next(N, board, shark, size):
    dist_board = [[0] * N for _ in range(N)]
    
    queue = PriorityQueue()
    queue.put((1, *shark))
    dist_board[shark[0]][shark[1]] = 1
    while not queue.empty():
        dist, x, y = queue.get()
        
        if 0 < board[x][y] < size:
            return ((x, y), dist)
        
        for move in MOVES:
            mx = x + move[0]
            my = y + move[1]
            
            if (0 <= mx < N and 0 <= my < N 
                and dist_board[mx][my] == 0 and board[mx][my] <= size):
                dist_board[mx][my] = dist_board[x][y]+1
                queue.put((dist_board[x][y]+1, mx, my))
                
    return None  
    
if __name__ == "__main__":
    print(solve())