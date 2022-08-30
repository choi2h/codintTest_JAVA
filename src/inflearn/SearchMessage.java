package inflearn;

import com.sun.tools.javac.Main;

import java.util.Locale;
import java.util.Scanner;

public class SearchMessage {

    public int solution(String str, char t) {
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);

//        System.out.println("str=" + str + ", char=" + t);

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == t) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SearchMessage T = new SearchMessage();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
