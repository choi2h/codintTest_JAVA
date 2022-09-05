package inflearn.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    큰 수 출력하기

    설명
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    (첫 번째 수는 무조건 출력한다)
    입력
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
    출력
    자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

    예시 입력 1
    6
    7 3 9 5 6 12

    예시 출력 1
    7 9 6 12
 */
public class Q1 {
    public List<Integer> solution(int count, int[] intList) {
        List<Integer> resultList = new ArrayList<>();

        resultList.add(intList[0]);
        for(int i=1; i<count; i++) {
            if(intList[i]>intList[i-1]) {
                resultList.add(intList[i]);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Q1 q = new Q1();
        Scanner in=new Scanner(System.in);
        int count = in.nextInt();
        int[] intList = new int[count];
        for(int i=0; i<count; i++) {
            intList[i] = in.nextInt();
        }

        List<Integer> resultList = q.solution(count, intList);
        for(Integer i : resultList) {
            System.out.print(i + " ");
        }
    }

}
