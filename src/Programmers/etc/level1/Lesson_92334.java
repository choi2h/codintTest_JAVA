package Programmers.etc.level1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
신고 결과 받기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class Lesson_92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> countMap= new HashMap<>();
        for(String r : report) {
            String[] nameList = r.split(" ");
            String reporter = nameList[0];
            String target = nameList[1];

            Set<String> reporterSet = countMap.getOrDefault(target, new HashSet<>());
            reporterSet.add(reporter);
            countMap.put(target, reporterSet);
        }


        Map<String, Integer> alarmCountMap = new HashMap<>();
        for(String id : countMap.keySet()) {
            if(countMap.containsKey(id)) {
                Set<String> reporterSet = countMap.get(id);
                int count = reporterSet.size();
                if(count < k) {
                    continue;
                }

                for(String reporter : reporterSet) {
                    alarmCountMap.put(reporter, alarmCountMap.getOrDefault(reporter, 0)+1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            if(alarmCountMap.size() > 0 && alarmCountMap.containsKey(id_list[i])) {
                answer[i] = alarmCountMap.get(id_list[i]);
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_92334 lesson = new Lesson_92334();
//        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        int k = 2;

        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] result = lesson.solution(id_list, report, k);
        for(int i=0; i<result.length; i++) {
            System.out.println(id_list[i] + "=" + result[i]);
        }
    }
}
