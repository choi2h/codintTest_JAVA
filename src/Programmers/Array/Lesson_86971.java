package Programmers.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lesson_86971 {

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        List<Integer>[] list = new List[n+1];
        for(int[] wire : wires) {
            if(list[wire[0]] == null) list[wire[0]] = new ArrayList<>();
            list[wire[0]].add(wire[1]);

            if(list[wire[1]] == null) list[wire[1]] = new ArrayList<>();
            list[wire[1]].add(wire[0]);
        }

        for(int[] wire : wires) {
            int count1 = getCount(wire[0], wire[1], list);
            int count2 = getCount(wire[1], wire[0], list);

            int diff = Math.abs(count1 - count2);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int getCount(int n, int novisit, List<Integer>[] list) {
        boolean[] visited = new boolean[list.length];
        visited[novisit] = true;
        int count = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while(!queue.isEmpty()) {
            int visit = queue.poll();
            visited[visit] = true;
            for(int i : list[visit]) {
                if(visited[i]) continue;
                queue.add(i);
                count++;
            }
        }

        return count;
    }

    /*
    9	{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}
    4	{{1,2},{2,3},{3,4}}
    7	{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}
     */
    public static void main(String[] args) {
        Lesson_86971 lesson = new Lesson_86971();

//        int result = lesson.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        int result = lesson.solution(4, new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(result);

    }
}
