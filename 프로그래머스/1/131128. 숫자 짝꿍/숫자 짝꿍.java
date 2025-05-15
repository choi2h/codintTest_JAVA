class Solution {
    public String solution(String X, String Y) {

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            String num = String.valueOf(i);
            int xCount = X.length() - X.replace(String.valueOf(i), "").length();
            int yCount = Y.length() - Y.replace(String.valueOf(i), "").length();

            int minCount = Math.min(xCount, yCount);
            sb.append(String.valueOf(i).repeat(minCount));
        }

        String answer = sb.toString();
        if(answer.length() == 0) return "-1";
        else if(answer.startsWith("0"))  return "0";
        
        return answer;
    }
}