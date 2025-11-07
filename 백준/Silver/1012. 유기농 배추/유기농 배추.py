import sys

MOVE_DIRECTIONS = [(0,-1), (0, 1), (1, 0), (-1, 0)]

def solve():
    T = int(sys.stdin.readline())
    
    answer = ''
    for _ in range(T):
        M, N, K = map(int, sys.stdin.readline().split())
    
        arr = [[0] * N for _ in range(M)]
        for _ in range(K):
            x, y = map(int, sys.stdin.readline().split())
            arr[x][y] = 1

        visited = [[0] * N for _ in range(M)]
        count = 0
        for i in range(M):
            for j in range(N):                
               if arr[i][j] == 1 and not visited[i][j]:
                   count += 1
                   check_visit(arr, i, j, N, M, visited)
                   
                
        answer += f"{count} \n"
    
    print(answer)

def check_visit(arr, i, j, N, M, visited):
    queue = [(i, j)]
    
    while queue:
        x, y = queue.pop(0)
        
        if visited[x][y]:
            continue
        
        visited[x][y] = True
        for move in MOVE_DIRECTIONS:
            mx = x + move[0]
            my = y + move[1]
            
            if mx >= 0 and mx < M and my >= 0 and my < N and arr[mx][my] == 1:
                if not visited[mx][my]:
                    queue.append((mx, my))

if __name__ == "__main__":
    solve()