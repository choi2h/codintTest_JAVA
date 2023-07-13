package Programmers.etc.level2;

import java.util.*;

/*
과제 진행하기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/176962
 */
public class Lesson_176962 {

    //-- 완료된 과제의 이름을 담을 리스트
    List<String> finishList = new ArrayList<>();
    //-- 중간에 밀린 과제를 담을 리스트
    Stack<String[]> delayPlans = new Stack<>();

    public String[] solution(String[][] plans) {
        //-- 시간순으로 오름차순 정렬
        Arrays.sort(plans, (o1, o2) -> {
            int time1 = convertToMinute(o1[1]);
            int time2 = convertToMinute(o2[1]);

            return Integer.compare(time1, time2);
        });

        //-- 진행중인 현재시간을 저장할 now 변수 선언
        int now;
        for (int i = 0; i < plans.length - 1; i++) {
            //-- 바로 진행할 과제
            String[] plan = plans[i];
            //-- 다음으로 진행될 과제
            String[] nextPlan = plans[i + 1];

            //-- 바로 진행할 과제의 시작시간을 지금으로 설정
            now = convertToMinute(plan[1]);
            //-- 다음으로 진행할 과제의 시작시간 할당
            int nextStartTime = convertToMinute(nextPlan[1]);

            //-- 현재 진행 plan 과제를 처리할 수 있을만큼 처리한 후의 시간 받아옴
            now = getFinishedPlanTime(plan, nextStartTime, now);

            //-- 다음 과제의 시작시간이 안됐을 때 밀린 과제가 있으면 밀린 과제 처리
            //-- 다음 과제의 시작시간이 안됐다면 밀린 과제를 계속 처리 할 수 있도록 while문 사용
            while (now < nextStartTime && delayPlans.size() > 0) {
                //-- 밀린과제를 담아놓은 stack에서 가장 마지막에 넣은 과제 가져와서 진행 과제를 뜻하는 plan 변수에 할당
                plan = delayPlans.pop();
                //-- 지금 진행한 plan 과제를 처리할 수 있을만큼 처리한 후의 시간 받아옴
                now = getFinishedPlanTime(plan, nextStartTime, now);
            }
        }

        //-- 마지막으로 시작하는 과제는 시간 제한이 없으므로 한번에 처리
        finishList.add(plans[plans.length-1][0]);
        //-- 마지막 과제를 처리하고도 남은 밀린 과제 순차적으로 처리
        while (delayPlans.size() > 0) {
            finishList.add(delayPlans.pop()[0]);
        }

        //-- 리스트에 담아놓은 과제 완료 순서를 배열에 할당
        String[] answer = new String[finishList.size()];
        int index = 0;
        for(String name : finishList) {
            answer[index++] = name;
        }

        return answer;
    }

    //-- 과제를 할 수 있는만큼 진행하고 진행 완료시간을 알려줌
    private int getFinishedPlanTime(String[] plan, int nextStartTime, int now) {
        //-- 현재 과제 처리 시간
        int playTime = Integer.parseInt(plan[2]);
        //-- 현재 과제의 예상 완료 시간
        int endTime = now + playTime;

        //-- 예상 과제 완료 시간이 다음 과제 시작시간보다 이전이거나 같으면
        if (endTime <= nextStartTime) {
            //-- 현재 과제는 마무리 가능하므로 완료 리스트에 추가
            finishList.add(plan[0]);
            //-- 과제 마무리 시간으로 시간 이동
            now = endTime;
        }
        //-- 예상 과제 완료시간이 다음 과제 시작시간보다 이후일 경우
        //-- 현재 과제를 마무리하지 못할것으로 판단
        else {
            //-- 다음 과제 시작시간과 예상 과제 완료시간의 시간차이를 구함
            int duration = endTime - nextStartTime;
            //-- 다음 과제 시작시간까지만 처리하고 남은 시간으로 과제 처리시간 수정
            plan[2] = String.valueOf(duration);
            //-- 밀린과제에 현재 과제 정보 추가
            delayPlans.push(plan);
            //-- 다음 과제 시작시간까지 시간을 다 썼으므로 다음 과제 시작시간으로 이동
            now = nextStartTime;
        }

        //-- 현재 과제를 처리할 수 있을만큼 처리하고 난 시간 응답
        return now;
    }

    //-- String타입의 시간값을 분단위 시간 int로 변환하여 응답
    private int convertToMinute(String time) {
        return Integer.parseInt(time.substring(0, 2))*60 + Integer.parseInt(time.substring(3, 5));
    }

    public static void main(String[] args) {

//        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
//        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
//        String[][] plans = {{"1", "00:00", "30"}, {"2", "00:10", "10"}, {"3", "00:30", "10"}, {"4", "00:50", "10"}};
//        String[][] plans = {{"A", "12:00", "30"}, {"B", "12:10", "20"}, {"E", "12:19", "20"}, {"C", "15:00", "40"}, {"D", "15:10", "30"}};
        String[][] plans = {{"A", "23:00", "50"}, {"B", "23:20", "20"}, {"E", "23:39", "18"}, {"C", "00:00", "40"}, {"D", "23:59", "30"}};


        /*
            A - 23:00-23:20 [20min] - 30 min
            B - 23:20-23:39 [19min] - 1 min
            E - 23:39-23:57 [18min] - finish
            B - 23:58-23:58 [1min] - finish
            A - 23:59-23:59 [1min] - 29min
            D - all
            A - all
         */
        Lesson_176962 lesson = new Lesson_176962();
        String[] result =lesson.solution(plans);

        System.out.println("======== result ========");
        for(String s: result) {
            System.out.println(s);
        }

    }
}