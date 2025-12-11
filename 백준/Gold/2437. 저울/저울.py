import sys

def solve():
    N = int(sys.stdin.readline())
    weights = list(map(int, sys.stdin.readline().split()))
    weights.sort()
    
    idx = 0
    target = 1
    sum = 0
    while True:
        if target > sum:
            if idx >= N:
                break
            
            sum += weights[idx]
            idx += 1
            
            if target < sum and sum-target >= target:
                break
        elif target < sum and sum-target >= target:
            break
            
        
        target += 1
        
    
    return target;

    
if __name__ == "__main__":
    print(solve())