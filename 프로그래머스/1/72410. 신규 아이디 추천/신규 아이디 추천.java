class Solution {
    public String solution(String new_id) {
        
        // 1. 소문자 치환
        new_id = new_id.toLowerCase();
        
        // 2. 소문자, 숫자, -, _, . 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[^0-9a-z_\\-.]", "");
        
        // 3. 중복 제거
        new_id = changeMultipleDotToSingleDot(new_id);
        
        // 4. 시작 끝에 제거
        if(new_id.startsWith(".")) new_id = new_id.substring(1, new_id.length());
        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        
        // 5. 빈 문자열 a 대체
        if(new_id.length() == 0) new_id = "a";
        
        // 아이디 3자 이상 15자 이하
        new_id = getOnly3to15Characters(new_id);

        if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
        
        return new_id;
    }
    
    private String changeMultipleDotToSingleDot(String str) {
        String result = "";
        char[] charArray = str.toCharArray();
        for(int i=0; i<charArray.length; i++) {
            if(charArray[i] == '.' && 
               result.length() > 0 && 
               result.charAt(result.length()-1) == '.') continue;
            result += charArray[i];                
        }
        
        return result;
    }
    
    private String getOnly3to15Characters(String str) {
        if(str.length() > 15) {
            str = str.substring(0, 15);
        } else if(str.length() <= 2) {
            str += str.substring(str.length()-1).repeat(3-str.length());
        }
        
        return str;
    }
}