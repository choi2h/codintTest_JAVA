package baekJoon.list;

import java.util.Scanner;

public class q11720_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String str = scanner.nextLine();

        int answer = 0;
        for (char c : str.toCharArray()) {
            answer += Character.getNumericValue(c);
        }

        System.out.println(answer);
    }
}
