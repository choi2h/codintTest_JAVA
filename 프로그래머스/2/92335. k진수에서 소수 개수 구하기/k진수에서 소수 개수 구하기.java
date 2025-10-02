class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] nums = Integer.toString(n,k).split("0");
        for(String num : nums) {
            if(num.isEmpty()) continue;
            if(isPrimeNumber(Long.parseLong(num))) answer++;
        }       
        
        return answer;
    }
    
    private boolean isPrimeNumber(long n) {
        if(n==1) return false;
        
        for(long i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        
        return true;
    }
}