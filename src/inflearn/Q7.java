package inflearn;

import java.util.Scanner;

/*
    회문문자열
    str.equalsIgnoreCause(str2) : str과 str2의 대소문자 상관없이 문자 동일 여부 판단
 */
public class Q7 {

    public String solution(String str) {
//        int len = str.length();
//        for(int i=0; i<len/2; i++) {
//            if(str.charAt(i) != str.charAt(len-i-1)) {
//                return "NO";
//            }
//        }

        String tmp = new StringBuilder(str).reverse().toString();
        if(!str.equalsIgnoreCase(tmp)) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String[] args) {
        Q7 q = new Q7();
        Scanner s = new Scanner(System.in);
        String str = s.next();

        String result = q.solution(str);
        System.out.println(result);
    }
}
