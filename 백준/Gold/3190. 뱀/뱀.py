import sys

DIRECTIONS = [(0,1), (1,0), (0,-1), (-1,0)]

def solve():
    N = int(sys.stdin.readline()) ## 보드 크기
    K = int(sys.stdin.readline()) ## 사과 개수
    
    board = [[0] * N for _ in range(N)]
    for _ in range(K):
        x, y = map(int, sys.stdin.readline().split())
        board[x-1][y-1] = 1
        
    L = int(sys.stdin.readline()) ## 이동 횟수
    moves = [ tuple(sys.stdin.readline().split()) for _ in range(L)]   
    cur_direction_idx = 0
    snake = [(0,0)]
    board[0][0] = 2
    
    cur_time = 0
    for move in moves:
        move_seconds = int(move[0])
        
        while move_seconds > cur_time:
            cur_time += 1
            board, snake = get_move_result(board, cur_direction_idx, snake)
            
            if board == None:   
                return cur_time
            
        cur_direction_idx = get_direction_idx(move[1], cur_direction_idx)
        
    while True:
        cur_time += 1
        board, snake = get_move_result(board, cur_direction_idx, snake)
        
        if board == None:   
            return cur_time


def get_direction_idx(str, cur):
    if str == 'D':
        cur = 0 if cur==3 else cur+1
    elif str == 'L':
        cur = 3 if cur==0 else cur-1
    
    return cur

        
def get_move_result(board, direction_idx, snake):
    board_size = len(board)
    snake_head = snake[0]
    
    head_mx = snake_head[0] + DIRECTIONS[direction_idx][0]
    head_my = snake_head[1] + DIRECTIONS[direction_idx][1]
    
    if not is_can_move(head_mx, head_my, board_size) or board[head_mx][head_my] == 2:
        return (None, None)
    
    isExistApple = board[head_mx][head_my] == 1
    
    snake = [(head_mx, head_my)] + snake
    board[head_mx][head_my] = 2
    
    if not isExistApple and len(snake) > 1:
        tail_x, tail_y = snake.pop()
        board[tail_x][tail_y] = 0

    return (board, snake)
         

def is_can_move(x, y, max_block):
    return 0 <= x < max_block and 0 <= y < max_block
    
    
if __name__ == "__main__":
    print(solve())
    