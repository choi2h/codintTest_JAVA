import sys

MOVES = [(-1, 0), (1,0), (0,-1), (0, 1)]
MAX_MOVE_CNT = 5
max_num = 0

def solve():
    N = int(sys.stdin.readline())
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    max_block = 0
    
    ## start_x, start_y, end_x, end_y, increase_x, increase_y
    start_and_move_point = [
            (0, 0, N, N, 1, 1), ## move_top
            (N-1, 0, -1, N, -1, 1), ## move_bottom
            (0, 0, N, N, 1, 1), ## move_left
            (0, N-1, N, -1, 1, -1) ## move_right
            ]
    
    def dfs(cur_board, move_cnt):
        nonlocal max_block
        
        if move_cnt >= MAX_MOVE_CNT:
            for i in range(N):
                max_block = max(max_block, max(cur_board[i]))
            return

        for i in range(len(MOVES)):
            new_board = get_new_board(cur_board, MOVES[i], start_and_move_point[i], N)
            dfs(new_board, move_cnt+1)
    
    dfs(board, 0)
    print(max_block)
 
def get_new_board(board, move, points, board_size):
    new_board = [[0] * board_size for _ in range(board_size)]
    is_merge = [[False] * board_size for _ in range(board_size)]
    start_x, start_y, end_x, end_y, increase_x, increase_y = points
    for x in range(start_x, end_x, increase_x):
        for y in range(start_y, end_y, increase_y):
            if board[x][y] == 0: 
                continue
            
            mx, my = x, y
            while new_board[mx][my] == 0 and can_move(mx, my, move, board_size):
                if((new_board[mx+move[0]][my+move[1]] != 0 
                   and new_board[mx+move[0]][my+move[1]] != board[x][y])
                   or is_merge[mx+move[0]][my+move[1]]):
                    break
                mx += move[0]
                my += move[1]
            
            if new_board[mx][my] == board[x][y] and not is_merge[mx][my]:
                new_board[mx][my] = (board[x][y] * 2)
                is_merge[mx][my] = True
            else:
                new_board[mx][my] = board[x][y]
    return new_board
                    
def can_move(x, y, move, board_size):
    mx = x + move[0]
    my = y + move[1]
    return 0 <= mx < board_size and  0 <= my < board_size
    
if __name__ == "__main__":
    solve()
    