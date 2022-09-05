package inflearn.string;

import java.util.Scanner;

/*
    특정 문자 뒤집기
    toCharArray()
    Character.isAlphabetic 알파벳이면 true 반환
 */
public class Q5 {
    public String solution(String str) {
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = chars.length-1;

        while(lt<rt) {
            char left = chars[lt];
            char right = chars[rt];

            if(!Character.isAlphabetic(left)) {
               lt++;
            } else if(!Character.isAlphabetic(right)) {
                rt--;
            } else {
                chars[lt] = right;
                chars[rt] = left;

                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }

   /*
   private boolean isNotAlphabet(char c) {
        return !((c >= 65 && c <= 90) || (c>=97 && c<=122));
    }
    */

    public static void main(String[] args) {
        Q5 r = new Q5();
        Scanner s = new Scanner(System.in);
        String inputText = s.next();

        String result = r.solution(inputText);
        System.out.println(result);
    }
}
