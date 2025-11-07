def solve():
    N, d, k, c = map(int, input().split())
    
    sushi_plates = []
    for _ in range(N):
        num = int(input())
        sushi_plates.append(num)
        
    sushi_plates += sushi_plates[0:k]
            
    sushi = [0] * (d+1)
    cur_count, max_count = 0, 0
    l, r= 0, 0
    while r < len(sushi_plates) :
        if r-l >= k :
            pre_sushi = sushi_plates[l]
            sushi[pre_sushi] -= 1
            if not sushi[pre_sushi]:
                cur_count -= 1
            l += 1
        
        cur_sushi = sushi_plates[r]
        if not sushi[cur_sushi]: 
            cur_count += 1
        
        sushi[cur_sushi] += 1
        
        max_count = max(cur_count if sushi[c] else cur_count+1, max_count)
        
        r+=1
        
    print(max_count)
        
        


## 진입점
if __name__ == "__main__" :
    solve()