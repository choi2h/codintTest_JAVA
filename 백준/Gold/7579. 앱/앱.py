import sys

def solve():
    N, M = map(int, sys.stdin.readline().split())
    
    memories = list(map(int, sys.stdin.readline().split()))
    costs = list(map(int, sys.stdin.readline().split()))
    
    max_cost = sum(costs)
    
    records = [0] * (max_cost+1)
    for i in range(N):
        tmp = records.copy()
        cur = costs[i]
        for j in range(0, max_cost-cur+1):
            tmp[j+cur] = max(records[j+cur], records[j] + memories[i])
        records = tmp.copy()
        
    answer = max_cost
    for i in range(len(records)):
        if records[i] >= M:
            answer = min(answer, i)
            
    print(answer)
    
if __name__ == "__main__":
    solve()   