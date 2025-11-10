import sys, math

def solve():
    N = int(sys.stdin.readline())
    
    nums = get_prime_nums(N)
    l, sum, cnt = 0, 0, 0
    for r in range(len(nums)):
        sum += nums[r]
        
        while sum > N:
            sum -= nums[l]
            l += 1
        
        if sum == N:
            cnt += 1
        
    print(cnt)


def get_prime_nums(num):
    nums = []
    is_prime = [0] * (num+1)
    for i in range(2, num+1):
        is_prime[i] = i

    for n in range(2, num+1):
        if is_prime[n] == 0:
            continue
        
        nums.append(n)    
        for  j in range(n, num+1, n):
            is_prime[j] = 0
            
    return nums

if __name__ == "__main__":
    solve()