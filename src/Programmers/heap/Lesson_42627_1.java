package Programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lesson_42627_1 {
    static class Job implements Comparable<Job> {
        int idx;
        int inputTime;
        int workTime;

        public Job(int idx, int inputTime, int jobTime) {
            this.idx = idx;
            this.inputTime = inputTime;
            this.workTime = jobTime;
        }

        @Override
        public int compareTo(Job o) {
            if(o.workTime == workTime) {
                return inputTime == o.inputTime ? idx - o.idx : inputTime - o.inputTime;
            }

            return workTime - o.workTime;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Job> pq = new PriorityQueue<>();
        pq.add(new Job(0, jobs[0][0], jobs[0][1]));

        int idx = 1;
        int time = jobs[0][0];
        while (!pq.isEmpty() || idx < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if(pq.isEmpty()) {
                time++;
                continue;
            }

            Job job = pq.poll();
            time += job.workTime;
            answer += time-job.inputTime;
        }

        return answer/jobs.length;
    }


    public static void main(String[] args) {
        Lesson_42627_1 lesson = new Lesson_42627_1();
        System.out.println(lesson.solution(new int[][]{{0,3},{1,9},{3,5}}));
    }
}
