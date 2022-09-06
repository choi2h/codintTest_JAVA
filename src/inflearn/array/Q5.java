package inflearn.array;

import java.util.Scanner;
/*
    소수(에라토스테네스 체)
    설명
    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
    만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

    입력
    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
    출력
    첫 줄에 소수의 개수를 출력합니다.

    예시 입력 1
    20
    예시 출력 1
    8
 */
public class Q5 {

    public int solution(int number) {
        int count = 0;

        int[] ch = new int[number+1];
        for(int i=2; i<=number; i++) {
            if(ch[i]==0) {
                count++;
                for (int j=i;j<=number; j=j+i) {
                    ch[j]=1;
                }
            }
        }


        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        Q5 q = new Q5();
        int result = q.solution(number);
        System.out.println(result);
    }
}
