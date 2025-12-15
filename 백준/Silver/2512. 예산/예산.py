import sys

def solve():
    N = int(sys.stdin.readline())
    requests = list(map(int, sys.stdin.readline().split()))
    total_amount = int(sys.stdin.readline())
    
    max_request = max(requests)
    if sum(requests) <= total_amount:
        return max_request
    
    l = 0; r = max_request
    answer = 0; max_sum_amount=0
    while(l <= r):
        mid = (l+r)//2
        total = sum_amount(requests, mid)
        if total > total_amount:
            r = mid-1
        else:
            l = mid+1
            if max_sum_amount < total:
                max_sum_amount = total
                answer = mid
        
    return answer

def sum_amount(requests, max):
    total = 0
    for r in requests:
        total += r if r <= max else max
        
    return total

if __name__ == "__main__":
    print(solve())