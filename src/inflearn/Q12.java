package inflearn;

import java.util.Scanner;
햐
/*
    암호
    parseInt(string,2) : sting의 값이 2진수이며 이를 int 10진수로 변경함
    replace는 문자열 사용
    replaceAll은 정규식 사용
 */
public class Q12 {
    public String solution(int textCount, String str) {
        String answer="";

        String[] codes = new String[textCount];
        for(int i=0; i<textCount; i++) {
            String code = str.substring(i*7, i*7+7);
            codes[i] = code.replace('#', '1').replace('*', '0');
        }

        for(String code : codes) {
            char c = (char) Integer.parseInt(code,2);
            answer += c;
        }
        return answer;
    }

    public static void main(String[] args) {
        Q12 q = new Q12();
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        String code = s.next();
        String result = q.solution(count, code);
        System.out.println(result);
    }
}
