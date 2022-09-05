package inflearn.string;

import java.util.Scanner;

/*
    숫자만 추출
    Character.isDigit(x) : x가 숫자인지에 대한 boolean값 반환
 */
public class Q9 {
    public int solution(String str) {
//        String answer = str.replaceAll("[^0-9]", "");
//        return Integer.parseInt(answer);

//        int answer = 0;
//        for(char x : str.toCharArray()) {
//            if(x>=48 && x<=57) {
//                answer = answer*10+(x-48);
//            }
//        }

        String answer = "";
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) {
                answer += x;
            }
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        Q9 q= new Q9();
        Scanner s = new Scanner(System.in);
        String str = s.next();

        int result = q.solution(str);
        System.out.println(result);
    }
}
