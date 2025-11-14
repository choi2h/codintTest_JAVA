import sys

def solve():
    L, C = map(int, sys.stdin.readline().split())
    chars = sorted(list(sys.stdin.readline().split()))
    
    write = sys.stdout.write
    records = [''] * L
    def dfs(depth, cur):
        if depth == L:
            count = 0
            for char in ('a', 'e', 'i', 'o', 'u'):
                if char in records:
                    count += 1
                
            if count >= 1 and L-count >=2:
                write(''.join(records) + "\n")
            return
        
        if cur >= C:
            return
        
        for i in range(cur, C):
            records[depth] = chars[i]
            dfs(depth+1, i+1)
            
    dfs(0, 0)
    
    
if __name__ == "__main__":
    solve()