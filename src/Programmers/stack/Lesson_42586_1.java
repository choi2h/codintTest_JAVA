package Programmers.stack;


import java.util.Arrays;

public class Lesson_42586_1 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int answerIndex = 0;

        for(int i=0; i<progresses.length; i++) {
            // 현재 인덱스의 프로세스가 걸리는 기간 구함
            int idleProgress = 100-progresses[i];
            int useDate = idleProgress%speeds[i] == 0 ? idleProgress/speeds[i] : idleProgress/speeds[i]+1;

            int count = 1;
            // 다음 인덱스가 동일 기간 내에 완료된다면
            while (i<progresses.length-1 && progresses[i+1]+speeds[i+1]*useDate >= 100) {
                // 개수와 인덱스 증가
                count++;
                i++;
            }

            // 같은 날짜에 끝나는 프로세스 개수 추가
            answer[answerIndex++] = count;
        }

        // 사용한 인덱스 값까지 잘라서 복사
        return Arrays.copyOfRange(answer, 0, answerIndex);
    }

    /*
    [93, 30, 55]	[1, 30, 5]	[2, 1]
    [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */
    public static void main(String[] args) {
        Lesson_42586_1 lesson = new Lesson_42586_1();

//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
//        int[] result = lesson.solution(progresses, speeds);
//        System.out.println(Arrays.toString(result));

        String str = "\t  JAVA";
        System.out.println(str.translateEscapes());

        String text = "hello \nmyName is ihwa \nbye";
        text.lines().forEach(System.out::println);

    }
}

/*
public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int answerIndex = 0;

        // queue에 모든 인덱스 저장
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            q.add(i);
        }

        int date = 1;
        int count = 0;
        while (!q.isEmpty()) {
            int index = q.peek();
            // 현재 날짜만큼의 프로세스 진행 시 프로세스가 끝나는지 확인
            if(100-(progresses[index]+(speeds[index]*date)) <= 0) {
                // 끝난다면 개수 증가 및 큐에서 해당 인덱스 제거
                count++;
                q.remove();
                // 동일 날짜를 기준으로 큐의 다음 인덱스 확인
                continue;
            }

            // 프로세스가 끝나지 않는데 이미 개수가 존재한다면
            // 그 개수들은 이전에 끝나는 것으로 정답 배열에 추가
            if(count > 0) {
                answer[answerIndex++] = count;
                count = 0;
            }
            // 날짜 증가
            date++;
        }

        // 마지막 값 저장
        answer[answerIndex++] = count;
        return Arrays.copyOfRange(answer, 0, answerIndex);
}
 */