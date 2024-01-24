package baekJoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 카드2
// https://www.acmicpc.net/problem/2164
public class Q2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            queue.remove();
            queue.add(queue.remove());
        }

        System.out.println(queue.remove());
    }
}
