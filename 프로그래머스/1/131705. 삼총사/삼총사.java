class Solution {
    public int solution(int[] number) {
       int answer = 0;

        for(int i=0; i<number.length-2; i++) {
            answer += getValidTripleCount(number, i, number[i], 1);
        }

        return answer;
    }
    
    private int getValidTripleCount(int[] number, int idx, int sum, int count) {     
        int validCount = 0;
        for(int i=idx+1; i<number.length; i++) {
            if(count+1 == 3) validCount += sum+number[i] == 0 ? 1 : 0;
            else validCount += getValidTripleCount(number, i, sum+number[i], count+1);
        }
        
        return validCount;
    }
}