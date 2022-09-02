package inflearn;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*
StringBuilder(s).reverse(); -> 뒤집어줌
 */
public class ReverseWord {

    public ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> list = new ArrayList<>();

        for(String s : str) {
            /*
            int length = s.length();
            StringBuilder result = new StringBuilder();
            for(int i=length-1; i >= 0; i--) {
                result.append(s.charAt(i));
            }
            */

            /*
            String result = new StringBuilder(s).reverse().toString();
            list.add(result);
            */

            char[] c = s.toCharArray();
            int lt = 0, rt = c.length-1;
            while(lt<rt) {
                char tmp=c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(c);
            list.add(tmp);
        }

        return list;
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for(int i =0; i<n; i++) {
            str[i] = scanner.next();
        }

        for(String s : reverseWord.solution(n, str)) {
            System.out.println(s);
        }
    }
}
