package inflearn.array;

import java.util.Scanner;

/*
    피보나치 수열
    설명
    1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

    입력
    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
    출력
    첫 줄에 피보나치 수열을 출력합니다.

    예시 입력 1
    10
    예시 출력 1
    1 1 2 3 5 8 13 21 34 55
 */
public class Q4 {
    public void solution(int count) {
//        int[] resultList = new int[count];
//        resultList[0] = 1;
//        resultList[1] = 1;
//
//        for(int i=2; i<count; i++) {
//            resultList[i] = resultList[i-1] + resultList[i-2];
//        }
//        return resultList;

        // 배열을 사용하지 말아라
        int a=1, b=1, c;
        System.out.print(a+ " " + b + " ");

        for(int i=2; i<count; i++) {
            c=a+b;
            System.out.print(c + " " );
            a=b;
            b=c;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        Q4 q = new Q4();
//        int[] result= q.solution(count);
//        for(Integer i : result) {
//            System.out.print(i + " ");
//        }
        q.solution(count);
    }
}
