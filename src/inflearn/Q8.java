package inflearn;

import java.util.Scanner;

/*
    팰린드롬 : 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열
    replaceAll 정규식 이용 -> replace에는 정규식 사용이 불가능ㅎ다.
 */
public class Q8 {

    public String solution(String str) {
        String answer="";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) {
            return "YES";
        }

        return "NO";
    }

    public static void main(String[] args) {
        Q8 q= new Q8();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        String result = q.solution(str);
        System.out.println(result);
    }
}
