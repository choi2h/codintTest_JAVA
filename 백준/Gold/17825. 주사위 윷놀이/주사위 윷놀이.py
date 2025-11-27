import sys


BOARD = { 0:2, 2:4, 4:6 , 6:8, 8:10, 10:(12,13), 12:14, 13:16, 14:16, 16:(18,19), 18:20, 19:25,
         20:(22,22), 22:(24,24), 24:(26, 25), 25:30, 26:(28,25), 27:26, 28:(30,27),
         30:(32, 28, 35), 32:34, 34:36, 35:40, 36:38, 38:40, 40:-1}

def solve():
    moves = list(map(int, sys.stdin.readline().split()))
    total_move_cnt = len(moves)
    
    max_score = 0
    ## [ 위치 : 이동방향(0:정방향 1:파란방향 2:25-40 마지막 방향)]
    pin_cnt = 4
    pins = [[0] * 2 for _ in range(pin_cnt)]
    check_board = [[0] * 3 for _ in range(41)] 
    
    def dfs(move_cnt, score):
        nonlocal max_score
        
        if total_move_cnt == move_cnt:
            max_score = max(max_score, score)
            return
        
        move = moves[move_cnt]
        for i in range(pin_cnt):
            if pins[i][0] == -1:
                continue
            
            before_point, before_direction = pins[i]
            cur_point, direction = get_pin_state(pins[i][0], pins[i][1], move)
            
            if not can_move(check_board, cur_point, direction):
                continue
            
            if before_point > 0 : check_board[before_point][before_direction] = 0
            pins[i] = [cur_point, direction]
            if cur_point > 0 : check_board[cur_point][direction] = 1
            
            dfs(move_cnt+1, score if cur_point == -1 else score+cur_point)
                        
            if before_point > 0 : check_board[before_point][before_direction] = 1
            pins[i] = [before_point, before_direction]
            if cur_point > 0 : check_board[cur_point][direction] = 0
        
        
    dfs(0, 0)
    return max_score     
 
def can_move(check_board, point, direction):
    if point == 40:
        for c in check_board[point]:
            if c == 1: return False
    
    return point == -1 or check_board[point][direction] == 0
    
def get_pin_state(cur_point, direction, move):
    if direction == 1 and cur_point == 25:
        direction = 2
    elif direction == 0 and 0 < cur_point < 40 and cur_point%10 == 0:
        direction = 1
    
    for _ in range(move):
        if cur_point == -1:
            return [-1, direction]
        
        if cur_point == 25:
            direction = 2
        
        if isinstance(BOARD[cur_point], tuple):
            cur_point = BOARD[cur_point][direction]
        else:
            cur_point = BOARD[cur_point]
    
    return [cur_point, direction]
    
if __name__ == "__main__":
    print(solve())