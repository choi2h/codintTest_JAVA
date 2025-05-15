class Solution {
    public String solution(String X, String Y) {
       int[] array = new int[10];

        for(int i=0; i<10; i++) {
            String num = String.valueOf(i);
            int xCount = X.length() - X.replace(num, "").length();
            int yCount = Y.length() - Y.replace(num, "").length();

            array[i] = Math.min(xCount, yCount);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=array.length-1; i>=0; i--) {
            if(array[i] > 0) sb.append(String.valueOf(i).repeat(array[i]));
        }

        String answer = sb.toString();
        if(answer.length() == 0) return "-1";
        else if(answer.startsWith("0"))  return "0";
        
        return answer;
    }
}