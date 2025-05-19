class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1. 소문자 치환
        new_id = new_id.toLowerCase();
        
        // 2. 소문자, 숫자, -, _, . 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[^0-9a-z_\\-.]", "");
        
        // 3. 중복 제거
        char[] charArray = new_id.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == '.') {
                int next = i;
                while(next<charArray.length-1 && charArray[next] == '.') {
                    next++;
                }
                
                if(next-i > 0) {
                    answer += charArray[i];
                    i = next-1;
                }
            } else {
                answer += charArray[i];                
            }
        }
        
        // 4. 시작 끝에 제거
        if(answer.startsWith(".")) new_id = new_id.substring(1, new_id.length());
        if(answer.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        
        // 5. 빈 문자열 a 대체
        if(answer.length() == 0) answer = "a";
        // 아이디 3자 이상 15자 이하
        if(answer.length() > 15) {
            answer = answer.substring(0, 15);
        } else if(answer.length() <= 2) {
            answer += answer.substring(answer.length()-1).repeat(3-answer.length());
        }
      
        return answer;
    }
}