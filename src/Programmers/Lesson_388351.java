package Programmers;

public class Lesson_388351 {
    // 출근 희망시각 + 10분까지 어플로 출근해야 한다.
    // 단, 토요일, 일요일의 출근 시간은 이벤트에 영향을 끼치지 않는다.
    // 매일 한번 출근
    // 모든 시각은 시에 100을 곱하고 분을 더한 정수로 표현됨
    // schedules : 직원이 설정한 출근 희망 시각 배열
    //              1 <= schedules의 길이 = n <= 1,000
    //              700 <= schedules[i] <= 1,100 => 7시에서 11시
    // timelogs : 일주일 동안 출근한 시각을 담은 배열
    //              timelogs[i]의 길이 = 7
    //              1 <= schedules의 길이 = n <= 1,000
    //              600 ≤ timelogs[i][j] ≤ 2359
    // startday : 이벤트를 시작한 요일을 의미하는 정수
    //               월 1 / 화 2 / 수 3 / 목 4 / 금 5 / 토 6 / 일 7
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i=0; i<schedules.length; i++) {
            if(!this.isExistLateTime(schedules[i], timelogs[i], startday)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isExistLateTime(int schedule, int[] timelogs, int day) {
        int lastPossibleTIme = getLastPossibleTime(schedule);
        System.out.println(lastPossibleTIme);

        for(int log : timelogs) {
            if(day == 7) {
                day = 1;
                continue;
            }

            if(day < 6 && log > lastPossibleTIme) {
                return true;
            }

            day++;
        }

        return false;
    }

    private int getLastPossibleTime(int time) {
        if(time%100 >= 60) {
            return time/100*100+100 + (time+10-60)%100;
        }

        return time+10;
    }

    /*
    [700, 800, 1100]	[[710, 2359, 1050, 700, 650, 631, 659], [800, 801, 805, 800, 759, 810, 809], [1105, 1001, 1002, 600, 1059, 1001, 1100]]	5	3
    [730, 855, 700, 720]	[[710, 700, 650, 735, 700, 931, 912], [908, 901, 805, 815, 800, 831, 835], [705, 701, 702, 705, 710, 710, 711], [707, 731, 859, 913, 934, 931, 905]]	1	2
     */
    public static void main(String[] args) {
        Lesson_388351 lesson = new Lesson_388351();
//        int[] schedules = {700, 800, 1100};
//        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
//        int startday = 5;

//        int[] schedules = {730, 855, 700, 720};
//        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912}, {908, 901, 805, 815, 800, 831, 835}, {705, 701, 702, 705, 710, 710, 711}, {707, 731, 859, 913, 934, 931, 905}};
//        int startday = 1;

        int[] schedules = {755};
        int[][] timelogs = {{710, 700, 806, 735, 700, 931, 912}};
        int startday = 1;

        int answer = lesson.solution(schedules, timelogs, startday);
        System.out.println(answer);
    }
}
