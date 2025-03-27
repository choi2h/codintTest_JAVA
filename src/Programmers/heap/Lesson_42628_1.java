package Programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lesson_42628_1 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(String operation : operations) {
            if(operation.startsWith("I")) {
                int n = Integer.parseInt(operation.split(" ")[1]);
                minQueue.add(n);
                maxQueue.add(n);
            } else if(operation.startsWith("D")) {
                if(minQueue.isEmpty()) continue;

                int flag = Integer.parseInt(operation.split(" ")[1]);
                if(flag == 1) minQueue.remove(maxQueue.remove());
                else if(flag == -1) maxQueue.remove(minQueue.remove());
            }
        }

        if(minQueue.isEmpty()) return new int[]{0, 0};
        return new int[]{maxQueue.remove(), minQueue.remove()};
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(6);
        queue.add(7);

        System.out.println(queue.remove(5));
    }
}

