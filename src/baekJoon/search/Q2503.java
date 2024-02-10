package baekJoon.search;

import java.util.Scanner;

/*
숫자 야구
https://www.acmicpc.net/problem/2503
 */
public class Q2503 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextLine();
        }

        int answer = 0;

        for(int a=1; a<10; a++) {
            for(int b=1; b<10; b++) {
                for(int c=1; c<10; c++) {
                    if(a==b || b==c || a==c) {
                        continue;
                    }

                    int count = 0;
                    for(int i=0; i<n; i++) {
                        String[] hint = arr[i].split(" ");
                        String[] number = hint[0].split("");
                        int strike = Integer.parseInt(hint[1]);
                        int ball = Integer.parseInt(hint[2]);

                        // a, b, c 숫자를 number와 비교해서 ballCount와 strikeCount를 구함
                        int ballCount = 0;
                        int strikeCount = 0;

                        int e = Integer.parseInt(number[0]);
                        int f = Integer.parseInt(number[1]);
                        int g = Integer.parseInt(number[2]);
                        if(a==e) {
                            strikeCount++;
                        }
                        if(b==f) {
                            strikeCount++;
                        }
                        if(c==g) {
                            strikeCount++;
                        }

                        if(a==f || a==g) {
                            ballCount++;
                        }

                        if(b==e || b==g) {
                            ballCount++;
                        }

                        if(c==e || c==f) {
                            ballCount++;
                        }


                        if(ball == ballCount && strike == strikeCount) {
                            count++;
                        }
                    }

                    if(count == n) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
