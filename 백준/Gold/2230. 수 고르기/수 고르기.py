import sys

N, M = map(int, sys.stdin.readline().split())
nums = sorted([ int(sys.stdin.readline()) for _ in range(N)])

l, r, dif = 0, 1, nums[N-1]-nums[0]
while l<=r and r<N:
    if nums[r]-nums[l] >= M:
        dif = min(dif, nums[r]-nums[l])
        l+=1
    else:
        r+=1
        
print(dif)