package inflearn;

import java.util.Scanner;

public class ReverseWord {

    public void solution(int n, String[] str) {

        for(String s : str) {
            int length = s.length();
            StringBuilder result = new StringBuilder();
            for(int i=length-1; i >= 0; i--) {
                result.append(s.charAt(i));
            }

            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        ReverseWord reverseWord = new ReverseWord();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[n];
        for(int i =0; i<n; i++) {
            str[i] = scanner.next();
        }

        reverseWord.solution(n, str);
    }
}
