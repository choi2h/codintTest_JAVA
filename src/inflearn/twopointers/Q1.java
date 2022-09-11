package inflearn.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    두 배열 합치기
    설명
    오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


    입력
    첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
    두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
    세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
    네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
    각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

    출력
    오름차순으로 정렬된 배열을 출력합니다.

    예시 입력 1
    3
    1 3 5
    5
    2 3 6 7 9
    예시 출력 1
    1 2 3 3 5 6 7 9
 */
public class Q1 {
    public List<Integer> solution(int n, int[] list1, int m, int[] list2) {
//        int[] answer= new int[n+m];
//
//        for(int i=0; i<n; i++) {
//            answer[i] = list1[i];
//        }
//
//        for(int j : list2) {
//            for(int k=0; k<answer.length; k++) {
//                if(j <= answer[k]) {
//                    int tmp = answer[k];
//                    answer[k] = j;
//                    j=tmp;
//                }
//
//                if(answer[k] == 0) {
//                    answer[k] = j;
//                    break;
//                }
//            }
//        }

        List<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1<n && p2<m) {
            if(list1[p1]<list2[p2])
                answer.add(list1[p1++]);
            else
                answer.add(list2[p2++]);
        }

        while (p1<n) {
            answer.add(list1[p1++]);
        }

        while (p2<m) {
            answer.add(list2[p2++]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int n = in.nextInt();
        int[] list1 = new int[n];
        for(int i=0; i<n; i++) {
            list1[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] list2 = new int[m];
        for(int i=0; i<m; i++) {
            list2[i] = in.nextInt();
        }

        Q1 q = new Q1();
        for(int r : q.solution(n, list1, m, list2)) {
            System.out.print(r + " ");
        }
    }
}
