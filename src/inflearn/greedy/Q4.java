package inflearn.greedy;

import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
           list.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }

        int result = solution(list);
        System.out.println(result);
    }

    public static int solution(List<Lecture> list) {
        int answer=0;

        Collections.sort(list);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Comparator.reverseOrder());

        int day = list.get(0).time;
        int index = 0;
        for(int i=day; i>0; i--) {
            while(index<list.size() && list.get(index).time == i) {
                priorityQueue.offer(list.get(index).money);
                index++;
            }

            if(!priorityQueue.isEmpty()) answer += priorityQueue.poll();
        }

        return answer;
    }

    static class Lecture implements Comparable<Lecture> {

        int money;
        int time;

        public Lecture(int money, int time) {
            this.money = money;
            this.time = time;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.time-this.time;
        }
    }
}
