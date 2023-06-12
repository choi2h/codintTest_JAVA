package Programmers.etc.level1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
개인정보 수집 유효기간
URL : https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */
public class Lesson_150370 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        // today String을 LocalDate로 변환
        LocalDate todayLocalDate = convertLocalDate(today);

        // 약관을 종류에 따라 Map에 저장
        Map<Character, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            // 약관의 형태는 '약관종류 유효기간'으로 되어있다.

            // 약관 종류는 A-Z까지의 한자리 영어 대문자이므로
            // String의 가장 처음 문자를 가져오면 된다.
            char name = term.charAt(0);

            // 유효기간은 1~100까지의 수 중 하나이므로
            // 약관종류와 띄어쓰기 한칸을 제외한 2부터 그 뒤의 모든 문자를 잘라주면
            // 유효기간 수가 나온다.
            // String 타입이므로 Integer.parseInt()를 사용해 int로 변환해준다.
            int month = Integer.parseInt(term.substring(2));

            // Map에 약관정보를 저장한다.
            termMap.put(name, month);
        }

        // 몇개의 결과가 나올지 모르므로 ArrayList를 생성하여 저장해준다.
        List<Integer> resultList = new ArrayList<>();

        // 개인정보를 순회
        // 배열의 순서가 개인정보 번호가 되므로 i+1은 개인정보 번호로 취급한다.
        // +1을 하는 이유는 인덱스는 0부터 시작하기 때문이다.
        for (int i = 0; i < privacies.length; i++) {
            // i번째 개인정보
            String privacy = privacies[i];

            // 개인정보의 날짜는 'YYYY.MM.DD' 형태이므로
            // 가장 처음부터 10개 문자를 잘라주면  해당 날짜가 String으로 떨어진다.
            String dateString = privacy.substring(0, 10);
            // 찾은 날짜를 LocalDate로 변형해 준다.
            LocalDate date = convertLocalDate(dateString);

            // 가장 마지막 문자에 약관종류가 작성되어 있으므로
            // 문자열의 총 길이에서 -1을 하여 마지막 문자를 가져와준다.
            // -1을 하는 이유는 인덱스는 0부터 시작하기 때문이다.
            char term = privacy.charAt(privacy.length() - 1);
            // 이전 for문에서 저장한 약관 Map에서 해당 약관의 유효기간을 가져온다.
            int termMonth = termMap.get(term);

            // LocalDate의 plusMonths 함수를 사용하여 유효기간만큼 더해준다.
            date = date.plusMonths(termMonth);
            // 유효기간이 오늘 날짜와 같거나 오늘 날짜보다 이전이면 개인정보 파기 대상으로 판단한다.
            if (date.isBefore(todayLocalDate) || date.equals(todayLocalDate)) {
                // 결과 리스트에 추가한다.
                // +1을 하는 이유는 인덱스는 0부터 시작하기 때문이다.
                resultList.add(i+1);
            }
        }

        // 결과 리스트를 배열에 다시 옮겨 담아 반환한다.
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    // String을 LocalDate로 변환해주는 메소드
    private LocalDate convertLocalDate(String date) {
        // 날짜 형식이 'YYYY.MM.DD'로 구성되어 있으므로 .을 기준으로 문자열을 잘라준다.
        String[] dateData = date.split("\\.");

        // 순서대로 연.월.일 저장
        int year = Integer.valueOf(dateData[0]);
        int month = Integer.valueOf(dateData[1]);
        int day = Integer.valueOf(dateData[2]);

        // LocalDate를 생성하여 반환해준다.
        return LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {
        Lesson_150370 lesson = new Lesson_150370();
//
//        String today = "2022.05.19";
//        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};


        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] result = lesson.solution(today, terms, privacies);
        for(int i : result) {
            System.out.print(i  +  " ");
        }
    }

}
