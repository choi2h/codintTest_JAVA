package Programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 이중 우선순위 큐
public class Lesson_42628 {

    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());

        for(String operation : operations) {
            String[] arr = operation.split(" ");
            int num = Integer.parseInt(arr[1]);
            switch (arr[0]) {
                case "I" :
                    minHeap.offer(num);
                    maxHeap.offer(num);
                    break;
                case "D" :
                    if(minHeap.isEmpty() || maxHeap.isEmpty()) {
                        continue;
                    }

                  if(num  == 1) {
                      int removeNum = maxHeap.poll();
                      minHeap.remove(removeNum);
                  } else if (num == -1) {
                     int removeNum = minHeap.poll();
                     maxHeap.remove(removeNum);
                  }
                    break;
                default:
            }
        }

        if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
           answer[0] = maxHeap.poll();
           answer[1] = minHeap.poll();
        }

        return answer;
    }

    /**
     * operations	return
     * ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
     * ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
     */
    public static void main(String[] args) {
        Lesson_42628 lesson = new Lesson_42628();
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result = lesson.solution(operations);
        System.out.println(Arrays.toString(Arrays.stream(result).toArray()));
    }
}

