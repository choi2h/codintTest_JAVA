package Programmers.queue;

import java.util.*;

public class Lesson_42587 {

    /*
    1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
    2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
    3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
      3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
     */

    // priorities : 우선순위가 들어있는 배열
    // location : 몇 번째로 실행되는지 알고싶은 프로세스 위치
    public int solution(int[] priorities, int location) {

        // 우선순위 정렬
        // 기본 정렬은 오름차순 : Comparator.reverseOrder()을 사용하여 내림차순 정렬
        Queue<Integer> queue = new LinkedList<>();

        for(int i : priorities) {
            queue.offer(i);
        }

        Arrays.sort(priorities);

        // 프로세스 실행 횟수
        int count=0;
        int size = priorities.length-1;
        // 큐가 다 소진될 때까지 반복문 실행
        while(!queue.isEmpty()) {
            int i = queue.poll();
            if( i == priorities[size-count]) {
                count++;
                location--;
                if(location < 0) {
                    break;
                }
            } else {
                queue.offer(i);
                location--;
                if(location < 0) {
                    location = queue.size()-1;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Lesson_42587 lesson = new Lesson_42587();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        int result = lesson.solution(priorities, location);
        System.out.println(result);
    }
}

/*
  PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            priorityQueue.offer(priorities[i]);
            queue.offer(i);
        }

        int answer = 0;
        int count = 0;
        while(!priorityQueue.isEmpty()) {
            int index = queue.remove();
            if(priorityQueue.peek() == priorities[index]) {
                priorityQueue.remove();
                count++;

                if(location == index) {
                    answer = count;
                    break;
                }
            } else {
                queue.offer(index);
            }
        }

 */
