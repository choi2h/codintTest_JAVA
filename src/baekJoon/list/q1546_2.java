package baekJoon.list;

import java.util.Scanner;

public class q1546_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double maxScore = 0;
        int count = scanner.nextInt();
        double[] arr = new double[count];
        for(int i = 0; i < count; i++) {
            arr[i] = scanner.nextDouble();
            maxScore = Math.max(maxScore, arr[i]);
        }

        double sum = 0;
        for(int i = 0; i < count; i++) {
            sum += arr[i]/maxScore*100.0;
        }


        System.out.println(sum/count);
    }
}
