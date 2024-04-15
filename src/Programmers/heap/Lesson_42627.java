package Programmers.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Lesson_42627 {
    public int solution(int[][] jobs) {

        // 들어온 순서대로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        // 현재 시간까지 들어온 작업 빠른 순으로 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(jobs[0]);

        int index = 1;
        int result = 0;
        int time = jobs[0][0];
        while (!queue.isEmpty()) {
            // 현재까지 들어온 작업들 확인

            // 현재까지 들어온 작업들 중 가장 빨리 끝나는(실행시간이 가장 짧은) 프로세스 실행
            int[] job = queue.poll();
            // 프로세스 실행 후 끝난 시간 저장
            time += job[1];
            result += time-job[0];

            while(index < jobs.length && jobs[index][0] <= time) {
                queue.offer(jobs[index++]);
            }

            // queue가 비어있다면
            if(queue.isEmpty() && index < jobs.length) {
                // 배열에 남아있는 작업 중 가장 빨리 들어오는 것 queue에 추가
                int[] nextJob = jobs[index++];
                time = nextJob[0];
                queue.offer(nextJob);
            }
        }

        return result/jobs.length;
    }

    // [[0, 3], [1, 9], [2, 6]]	9
    public static void main(String[] args) {
        Lesson_42627 lesson = new Lesson_42627();
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{0, 12}, {4, 6}, {7, 8}, {12, 3}};
        int result = lesson.solution(jobs);
        System.out.println(result);
    }

}

/*
  // 도착한 순서대로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });

        // 작업 시간 순으로 정렬
        PriorityQueue<int[]> jobQueue = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        // 가장 처음 도착한 작업 실행
        jobQueue.offer(jobs[0]);
        // 가장 처음 작업의 시작시간
        int end = jobs[0][0];
        // 총 대기+작업시간 결과
        int sum = 0;
        // 가장 처음 작업 뺐으므로 index 0 제외
        int idx = 1;

        // 작업큐가 빌 때 까지 반복문 실행
        while(!jobQueue.isEmpty()) {
            //  가장 처음 작업 꺼냄
            int[] cur = jobQueue.poll();
            // 현재 시간 + 작업 시간 = 끝나는 시간
            end += cur[1];
            // 현재 작업의 (대기+작업)시간을 더함
            sum += end - cur[0];
            System.out.println(cur[0] + " " + cur[1]);
            System.out.println(sum);

            // index가 jobs 배열 내에 있고 현재 인덱스의 시작 시간이 현재 시간보다 작거나 같으면
            while(idx <jobs.length && jobs[idx][0] <= end) {
                // 작업큐에 해당 인덱스의 작업을 넣는다
                jobQueue.offer(jobs[idx++]);
            }

            // 인덱스가 jobs 배열 내에 있고 큐가 비어있다면
            if(idx < jobs.length && jobQueue.isEmpty()) {
                // 현재 시간을 현재 인덱스의 시작 시간으로 변경한 후
                end = jobs[idx][0];
                // 작업큐에 해당 인덱스의 작업을 넣는다.
                jobQueue.offer(jobs[idx++]);
            }
        }

        // 전체 대기+작업 시간을 전체 작업의 수로 나눈다.
        return sum/jobs.length;
 */