package Programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lesson_42626_1 {

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i: scoville) {
            queue.add(i);
        }

        int answer = 0;
        while (queue.size() >= 2 && queue.peek() < K) {
            queue.add(queue.remove() + (queue.remove()*2));
            answer++;
        }

        return queue.peek() < K ? -1 : answer;
    }

    public static void main(String[] args) {
        String myString = "axbxcxxdx";
        String[] result = Arrays.stream(myString.split("x")).filter(s -> !s.isEmpty()).sorted().toArray(String[]::new);
        System.out.println(Arrays.toString(result));
    }
}
