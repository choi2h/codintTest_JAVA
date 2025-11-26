import sys

def solve():
    N = int(sys.stdin.readline())
    rooms = list(map(int, sys.stdin.readline().split()))
    B, C = map(int, sys.stdin.readline().split())
    
    total_cnt = N
    for A in rooms:
        if A-B <= 0:
            continue
        
        total_cnt += (A-B)//C if (A-B)%C == 0 else (A-B)//C+1
        
    print(total_cnt)

if __name__ == "__main__":
    solve()