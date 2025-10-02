class Solution {
    public int solution(int n, int k) {
        String numStr = convertNumberFormat(n, k);
        
        int answer = 0;
        String[] nums = numStr.split("0");
        for(String num : nums) {
            if(num.isEmpty()) continue;
            if(isPrimeNumber(Long.parseLong(num))) answer++;
        }       
        
        return answer;
    }
    
    private String convertNumberFormat(int n, int k) {
        if(k==10) return String.valueOf(n);
        
        StringBuilder sb = new StringBuilder();
        while(n/k>0) {
            sb.append(n%k);
            n /= k;
        }
        if(n > 0) sb.append(n);
        sb.reverse();
        
        return sb.toString();
    }
    
    
    private boolean isPrimeNumber(long n) {
        if(n==1) return false;
        
        for(long i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        
        return true;
    }
}