package Programmers.heap;

import java.util.PriorityQueue;

public class Lesson_42626 {

    /*
        섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

        parameter
        scoville : 스코빌 지수를 담은 배열
        k : 원하는 스코빌 지수 기준
     */
    public int solution(int[] scoville, int K) {
        // 스코빌 지수 배열을 가장 작은 수 부터 오름차순으로 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i : scoville) {
            queue.offer(i);
        }

        int answer = 0;
        while(true) {
            // 가장 작은 수가 k 이상인지 확인
            if (queue.isEmpty() || queue.size() < 2 && queue.peek() < K) {
                answer = -1;
                break;
            } else if(queue.peek() >= K) {
                break;
            } else {
                // 가장 앞에 수부터 빼서 스코빌 지수 섞기
                int a = queue.poll();
                int b = queue.poll();
                int mix = a + (b*2);

                // 다시 배열에 넣기
                answer++;
                queue.offer(mix);
            }
        }

        return answer;
    }

    // [1, 2, 3, 9, 10, 12]	7	2
    public static void main(String[] args) {
        Lesson_42626 lesson = new Lesson_42626();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = lesson.solution(scoville, K);
        System.out.println(result);
    }
}
