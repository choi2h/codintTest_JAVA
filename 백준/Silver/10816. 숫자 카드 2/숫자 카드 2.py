import sys

def solve():
    N = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split()))
    M = int(sys.stdin.readline())
    find_nums = list(map(int, sys.stdin.readline().split()))

    cnts = {}
    for num in nums:
        if num in cnts:
            cnts[num] = cnts[num]+1
        else:
            cnts[num] = 1
        
    answer = ""
    for num in find_nums:
        cnt = cnts[num] if num in cnts else 0
        answer += str(cnt) + " "
        
    return answer

if __name__ == "__main__":
    print(solve())