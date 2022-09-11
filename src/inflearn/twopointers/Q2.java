package inflearn.twopointers;

import java.util.*;

/*
    공통원소 구하기
    설명
    A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

    입력
    첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
    두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
    네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
    각 집합의 원소는 1,000,000,000이하의 자연수입니다.

    출력
    두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

    예시 입력 1
    5
    1 3 9 5 2
    5
    3 2 5 7 8
    예시 출력 1
    2 3 5
 */
public class Q2 {
    public List<Integer> solution(int n, int m, int[] list1, int[] list2) {
        List<Integer> answer= new ArrayList<>();
        Arrays.sort(list1);
        Arrays.sort(list2);

        int p1=0, p2=0;
        while (p1<n && p2<m) {
            if(list1[p1] == list2[p2]) {
                answer.add(list1[p1++]);
                p2++;
            }
            else if(list1[p1]<list2[p2]) p1++;
            else p2++;
        }
//        for(int i : list1) {
//            for(int j : list2) {
//                if(i==j) answer.add(i);
//            }
//        }
//
//        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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

        Q2 q = new Q2();
        List<Integer> result = q.solution(n, m, list1, list2);
        for(int r : result) {
            System.out.print(r + " ");
        }
    }
}
