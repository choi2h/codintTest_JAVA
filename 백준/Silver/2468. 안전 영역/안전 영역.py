import sys

CHECK_POINTS = [(-1,0), (1,0), (0,-1), (0, 1)]

def solve():
    N = int(sys.stdin.readline())
    heights = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    
    max_cnt = 1
    for h in range(N):
        max_height = max(heights[h])
        
    visited = [[False] * N for _ in range(N)]
    for i in range(max_height):
        max_cnt = max(max_cnt, check(N, heights, visited))
        visited = [[False] * N for _ in range(N)]
        
    return max_cnt

def check(N, heights, visited):
    cnt = 0
    
    for i in range(N):
        for j in range(N):
            heights[i][j] -= 1
    
    
    for i in range(N):
        for j in range(N):
            if visited[i][j] or heights[i][j] <= 0: continue
            cnt += 1
            bfs(N, heights, visited, i, j)
     
    return cnt       

def bfs(N, heights, visited, i, j):
    queue = [(i, j)]
    
    while queue:
        cur_i, cur_j = queue.pop(0)
        
        if visited[cur_i][cur_j]:
            continue
        
        visited[cur_i][cur_j] = True
        for pi, pj in CHECK_POINTS:
            mi = cur_i + pi
            mj = cur_j + pj
            
            if 0 <= mi < N and 0 <= mj < N and heights[mi][mj] > 0:
                queue.append((mi, mj))
            
if __name__ == "__main__":
    print(solve())