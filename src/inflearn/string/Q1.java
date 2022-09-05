package inflearn.string;

import java.util.Scanner;

/*
 * 문자 찾기
 */
public class Q1 {

    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

//        System.out.println("str=" + str + ", char=" + t);

//        for(int i=0; i<str.length(); i++) {
//            if(str.charAt(i) == t) {
//                answer++;
//            }
//        }

        for(char x : str.toCharArray()) {
            if(x == t) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q1 T = new Q1();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
