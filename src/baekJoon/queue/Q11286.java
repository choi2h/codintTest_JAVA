package baekJoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
절댓값 힙
https://www.acmicpc.net/problem/11286
 */
public class Q11286 {

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return 1;
                } else if(Math.abs(o1) == Math.abs(o2)) {
                    if(o1.equals(o2)){
                        return 0;
                    }

                    return o1 < o2 ? -1 : 1;
                }

                return -1;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.remove()).append("\n");
                }
            } else {
                queue.add(n);
            }
        }

        System.out.println(sb);
    }
}
