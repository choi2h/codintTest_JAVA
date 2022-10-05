package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1 {

    static class Body implements Comparable<Body> {
        int height;
        int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) { //키를 가지고 내림차순 정렬
          return o.height - this.height;
        }
    }

    public int solution(List<Body> bodies) {
        Collections.sort(bodies); //키 정렬
        int cnt = 0; // 선발 수
        int max = Integer.MIN_VALUE; // 가장 큰 몸무게

        for(Body b : bodies) { // 키만 정렬된 프로필 리스트
            if(b.weight > max) { // 최대 몸무게보다 현재 몸무게가 크다면 난 선발
                max = b.weight; // 최대 몸무게 변경
                cnt++; //선발 횟수 증가
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Body> bodies = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            bodies.add(new Body(h, w));
        }

        Q1 q = new Q1();
        System.out.println(q.solution(bodies));
    }
}
