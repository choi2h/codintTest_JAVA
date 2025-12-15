import sys

def solve():
    N = int(sys.stdin.readline())
    nums = sorted(list(map(int, sys.stdin.readline().split())))
    
    cnt = 0
    for i in range(N):
        if is_good_number(N, nums, i):
            cnt += 1
            
    return cnt

def is_good_number(N, nums, target):
    l = 0 if target != 0 else 1
    r = N-1 if target != N-1 else N-2
    while(l < r):
        sum = nums[l]+nums[r]
        
        if sum == nums[target]:
            return True
        elif sum > nums[target]:
            r -= 1 if r-1 != target else 2
        else:
            l += 1 if l+1 != target else 2
        
    return False
    

if __name__ == "__main__":
    print(solve())