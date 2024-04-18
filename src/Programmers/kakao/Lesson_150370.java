package Programmers.kakao;

import java.time.LocalDate;
import java.util.*;

// 2023 KAKAO BLIND RECRUITMENT
// 개인정보 수집 유효기간
public class Lesson_150370 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 날짜 LocalDate로 타입 변형
        LocalDate now = stringToLocalDate(today);

        // 약관명으로 약관 Month를 찾을 수 있도록 Map 생성
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        // 약관 기간이 지난 개인정보 저장 리스트
        List<Integer> resultList = new ArrayList<>();
        // 모든 개인정보 순회
        for(int i=0; i<privacies.length; i++) {
            // 개인정보 가져옴
            String privacy = privacies[i];
            // 구분된 공백으로 좌우 데이터 분리 "날짜 약관 종류"
            String[] arr = privacy.split(" ");
            // 날짜를 LocalDate로 타입 변형
            LocalDate startDate = stringToLocalDate(arr[0]);
            // 약관 종류에 따른 약관 기간 추출
            int expireMonth = termMap.get(arr[1]);
            // 약관 시작 날짜 + 약관 기간 => 약관 만료날짜 계산
            LocalDate expireDate = startDate.plusMonths(expireMonth);

            // 약관 만료 날짜가 오늘 날짜보다 이전이거나 같으면
            if(!expireDate.isAfter(now)) {
                // 결과 리스트에 추가
                resultList.add(i+1);
            }
        }

        int[] result = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
        }

        return result;
    }

    private LocalDate stringToLocalDate(String date) {
        String[] todayArr = date.split("\\.");
        return LocalDate.of(Integer.parseInt(todayArr[0]),
                Integer.parseInt(todayArr[1]), Integer.parseInt(todayArr[2]));
    }

    public static void main(String[] args) {
        Lesson_150370 lesson = new Lesson_150370();

//        String today = "2022.05.19";
        String today = "2020.01.01";
//        String[] terms = {"A 6", "B 12", "C 3"};
        String[] terms = {"Z 3", "D 5"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] result = lesson.solution(today, terms, privacies);
        System.out.println(Arrays.toString(result));
    }
}
