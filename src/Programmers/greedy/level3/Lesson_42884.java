package Programmers.greedy.level3;

import java.util.Arrays;
import java.util.Comparator;

public class Lesson_42884 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        System.out.println(Arrays.deepToString(routes));

        int answer=1;
        int max= routes[0][1];
        for(int i=1; i<routes.length; i++) {
            int s = routes[i][0];
            int e = routes[i][1];

            if(max < s) {
                answer++;
                max = e;
            } else if(max > e) {
                max = e;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_42884 lesson = new Lesson_42884();
//        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int[][] routes = {{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}} ;//4
//        int[][] routes = {{0,0}, {0,0}, {2,2}};
        int result = lesson.solution(routes);
        System.out.println(result);
    }
}
