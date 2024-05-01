package Programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


    /*
    commands의 각 원소는 아래 5가지 형태 중 하나입니다.
    "UPDATE r c value"
    r, c는 선택할 셀의 위치를 나타내며, 1~50 사이의 정수입니다.
    value는 셀에 입력할 내용을 나타내며, 알파벳 소문자와 숫자로 구성된 길이 1~10 사이인 문자열입니다.
    "UPDATE value1 value2"
    value1은 선택할 셀의 값, value2는 셀에 입력할 내용을 나타내며, 알파벳 소문자와 숫자로 구성된 길이 1~10 사이인 문자열입니다.
    "MERGE r1 c1 r2 c2"
    r1, c1, r2, c2는 선택할 셀의 위치를 나타내며, 1~50 사이의 정수입니다.
    "UNMERGE r c"
    r, c는 선택할 셀의 위치를 나타내며, 1~50 사이의 정수입니다.
    "PRINT r c"
    r, c는 선택할 셀의 위치를 나타내며, 1~50 사이의 정수입니다.
     */

// 2023 KAKAO BLIND RECRUITMENT
// 표 병합
public class Lesson_150366 {
    private static final String UPDATE_COMMAND_START = "UPDATE";
    private static final String MERGE_COMMAND_START = "MERGE";
    private static final String UNMERGE_COMMAND_START = "UNMERGE";
    private static final String PRINT_COMMAND_START = "PRINT";
    private static final String MERGE_CHECK_FORMAT = "M %s %s";

    private final String[][] table = new String[51][51];
    private final String[][] mergeInfos = new String[51][51];
    private final List<String> printValues = new ArrayList<>();


    public String[] solution(String[] commands) {
        for(String command : commands) {
            String[] values = command.split(" ");

            switch (values[0]) {
                case UPDATE_COMMAND_START:
                    update(values);
                    break;
                case MERGE_COMMAND_START:
                     merge(values);
                    break;
                case UNMERGE_COMMAND_START:
                     unmerge(values);
                    break;
                case PRINT_COMMAND_START:
                     print(values);
                    break;
            }
        }


        return printValues.toArray(new String[0]);
    }

    private void update(String[] values) {
        if(values.length == 4) {
            int r = Integer.parseInt(values[1]);
            int c = Integer.parseInt(values[2]);
            String newValue = values[3];
            updateNewValue(r, c, newValue);
        } else {
            String originValue = values[1];
            String newValue = values[2];
            updateAllValues(originValue, newValue, table);
        }
    }

    // "UPDATE r c value"
    private void updateNewValue(int r, int c, String value) {
        // 병합된 셀인지 확인
        if(mergeInfos[r][c] != null) {
            // 병합된 셀이라면 값이 있는 셀에다가 변경 값을 저장
            String[] values = mergeInfos[r][c].split(" ");
            r = Integer.parseInt(values[1]);
            c = Integer.parseInt(values[2]);
        }
        // 지정 셀에 값 업데이트
        table[r][c] = value;
    }


    // "UPDATE value1 value2"
    private void updateAllValues(String originValue, String newValue, String[][] arr) {
        // 모든 셀을 돌며 `originValue`가 있는 셀을 찾아냄
        for(int i=1; i<=50; i++) {
            for(int j=1; j<=50; j++) {
                // originValue와 같은 값이라면 newValue로 변경
                if(arr[i][j] != null && arr[i][j].equals(originValue)) {
                    arr[i][j] = newValue;
                }
            }
        }
    }

    private void updateAllValuesToNull(String originValue) {
        // 모든 셀을 돌며 `originValue`가 있는 셀을 찾아냄
        for(int i=1; i<=50; i++) {
            for(int j=1; j<=50; j++) {
                // originValue와 같은 값이라면 newValue로 변경
                if(mergeInfos[i][j] != null && mergeInfos[i][j].equals(originValue)) {
                    mergeInfos[i][j] = null;
                    table[i][j] = null;
                }
            }
        }
    }

    // 셀 병합
    private void merge(String[] values){
        int r1 = Integer.parseInt(values[1]);
        int c1 = Integer.parseInt(values[2]);

        int r2 = Integer.parseInt(values[3]);
        int c2 = Integer.parseInt(values[4]);

        mergeSell(r1, c1, r2, c2);
    }

    // "MERGE r1 c1 r2 c2"
    private void mergeSell(int r1, int c1, int r2, int c2) {
        // 첫번째 셀이 이미 병합된 셀이라면
        if(mergeInfos[r1][c1]!=null) {
            // 첫번째 셀이 바라보고있는 데이터셀로 위치 변경
            String[] values = mergeInfos[r1][c1].split(" ");
            r1 = Integer.parseInt(values[1]);
            c1 = Integer.parseInt(values[2]);
        }
        // 두번째 셀이 이미 병합된 셀이라면
        else if(mergeInfos[r2][c2]!=null){
            // 두번째 셀이 바라보고 있는 데이터셀로 위치 변경
            String[] values = mergeInfos[r2][c2].split(" ");
            r2 = Integer.parseInt(values[1]);
            c2 = Integer.parseInt(values[2]);
        }

        // 병합하고자하는 셀이 동일한 셀이라면 작업 제외
        if(r1 == r2 && c1 == c2) {
            return;
        }

        if(table[r1][c1]==null && table[r2][c2]!=null) {
            table[r1][c1] = table[r2][c2];
        }

        // 첫번째 셀을 데이터 셀로 저장하기 위한 문자열 생성
        String mergeData = String.format(MERGE_CHECK_FORMAT, r1, c1);
        // 두번째 셀이 병합 셀이라면
        if(mergeInfos[r2][c2]!=null) {
            // 해당 셀과 병합된 다른 셀도 변경해야한다
            String findValue = mergeInfos[r2][c2];
            updateAllValues(findValue, mergeData, mergeInfos);
        }

        mergeInfos[r1][c1] = mergeData;
        mergeInfos[r2][c2] = mergeData;
    }

    /*
        // 병합한 셀의 데이터가 담길 위치 변수
        String mergeData;
        // 만약 첫번째 셀에 데이터가 없고 두번째 셀에만 데이터가 존재한다면
        // 두번째 셀의 값만 저장
        if(table[r1][c1]==null && table[r2][c2]!=null) {
            // 두번째 셀을 데이터 셀로 저장하기 위한 문자열 생성
            mergeData = String.format(MERGE_CHECK_FORMAT, r2, c2);

            // 첫번째 셀이 병합 셀이라면
            if(mergeInfos[r1][c1]!=null) {
                // 해당 셀과 병합된 다른 셀도 변경해야한다
                String findValue = mergeInfos[r1][c1];
                updateAllValues(findValue, mergeData, mergeInfos);
            }
        }
        // 첫번째 셀에 값이 있거나
        // 두 셀 다 값이 없다면
        else {

        }
     */

    /*
        - 선택한 셀이 포함하고 있던 모든 셀은 프로그램 실행 초기의 상태로 돌아갑니다.
        - 병합을 해제하기 전 셀이 값을 가지고 있었을 경우 (r, c) 위치의 셀이 그 값을 가지게 됩니다.
     */
    private void unmerge(String[] values) {
        int r = Integer.parseInt(values[1]);
        int c = Integer.parseInt(values[2]);

        unmergeSell(r, c);
    }

    private void unmergeSell(int r, int c) {
        // 지정 셀이 머지되지 않은 셀이라면 작업x
        if(mergeInfos[r][c] == null) {
            return;
        }

        // 지정 셀과 병합된 데이터 셀 위치 가져옴
        String originPoint = mergeInfos[r][c];
        String[] values = originPoint.split(" ");
        int r2 = Integer.parseInt(values[1]);
        int c2 = Integer.parseInt(values[2]);
        // 해당 데이터 셀의 데이터를 저장
        String saveValue = table[r2][c2];

        // 지정셀과 병합됐던 모든 셀에 대해 병합기록과 데이터 초기화
        updateAllValuesToNull(originPoint);

        // 지정셀에만 데이터 저장
        table[r][c] = saveValue;
    }


    // "PRINT r c"
    private void print(String[] values) {
        int r = Integer.parseInt(values[1]);
        int c = Integer.parseInt(values[2]);

        savePrintValue(r, c);
    }

    private void savePrintValue(int r, int c) {
        // 지정 셀이 병합된 셀이라면 데이터가 담아있는 셀 위치를 가져와서 위치 재설정
        if(mergeInfos[r][c] != null) {
            String[] values = mergeInfos[r][c].split(" ");
            r = Integer.parseInt(values[1]);
            c = Integer.parseInt(values[2]);
        }

        // 지정 셀에 데이터가 없다면 "EMPTY" 출력
        if(table[r][c] == null) {
            printValues.add("EMPTY");
        }
        // 지정 셀에 데이터가 있다면 해당 데이터 출력
        else {
            printValues.add(table[r][c]);
        }
    }

    /*
    {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"}	{"EMPTY", "group"]
{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"}	["d", "EMPTY"]
     */
    public static void main(String[] args) {
        Lesson_150366 lesson = new Lesson_150366();
//        String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        String[] commands = {"UPDATE 1 1 menu", "MERGE 1 1 1 2", "MERGE 1 1 1 3", "MERGE 1 1 1 4", "MERGE 1 2 1 3", "UPDATE 1 1 hansik", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4"};
//        String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
//        String[] commands = {"MERGE 1 1 2 2", "PRINT 1 1"};
//        String[] commands = {"UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 3 3", "UNMERGE 1 1", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"};
//        String[] commands = {"MERGE 1 1 2 2", "MERGE 1 1 3 3", "UPDATE 3 3 A", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3"};
//        String[] commands = {"MERGE 1 1 2 2", "UPDATE 1 1 A", "UNMERGE 1 1", "PRINT 1 1", "PRINT 2 2"};
//        String[] commands = {"UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"};
        String[] result = lesson.solution(commands);
        System.out.println(Arrays.toString(result));
    }

}
