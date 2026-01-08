import sys

def solve():
    str1 = sys.stdin.readline().strip()
    str2 = sys.stdin.readline().strip()
    
    n1 = len(str1)+1
    n2 = len(str2)+1
    dp = [[0] * n1 for _ in range(n2)]
    
    for i in range(1, n2):
        for j in range(1, n1):
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])
            
            if str1[j-1] == str2[i-1]:
                dp[i][j] = max(dp[i][j], dp[i-1][j-1]+1)
                
    max_len = dp[n2-1][n1-1]

    if max_len == 0:
        return max_len
    
    result = []
    i = n2-1
    j = n1-1
    while i > 0 and j > 0:
        if str2[i-1] == str1[j-1]:
            result.append(str1[j-1])
            i -= 1
            j -= 1
        else:
            if dp[i-1][j] >= dp[i][j-1]:
                i -= 1
            else:
                j -= 1
    
    result.reverse()            
    
    return str(max_len) + "\n" + "".join(result)

if __name__ == "__main__" :
    print(solve())