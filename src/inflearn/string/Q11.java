package inflearn.string;

import java.util.Scanner;

/*
    문자열 압축
 */
public class Q11 {
    public String solution(String str) {
        String answer = "";
        str = str + " ";
        int count = 1;

        for(int i=0; i< str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                count++;
            } else {
                answer += str.charAt(i);
                if(count > 1) {
                    answer += String.valueOf(count);
                    count =1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q11 q= new Q11();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        String result = q.solution(str);
        System.out.println(result);
    }
}
