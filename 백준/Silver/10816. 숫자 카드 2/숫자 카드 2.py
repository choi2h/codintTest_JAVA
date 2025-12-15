import sys

def solve():
    N = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    M = int(sys.stdin.readline())
    find_nums = list(map(int, sys.stdin.readline().split()))

    nums.sort()
    
    history = {}
    answer = ""
    for num in find_nums:
        if num in history :
            answer += str(history[num]) + " "
        else:
            cnt = find(N, nums, num)
            history[num] = cnt
            answer += str(cnt) + " "
        
    return answer
    
def find(N, nums, target):
    l = 0 
    r = N-1
    cnt = 0
    while(l <= r):
        mid = (l+r)//2
        
        if nums[mid] == target:
            l = mid-1
            r = mid+1
            cnt += 1
            while l >= 0 and nums[l] == target:
                cnt += 1
                l -= 1
            
            while r < N and nums[r] == target:
                cnt += 1
                r += 1
            
            break;
        elif nums[mid] < target:
            l = mid+1;
        else:
            r = mid-1;
            
    return cnt

if __name__ == "__main__":
    print(solve())