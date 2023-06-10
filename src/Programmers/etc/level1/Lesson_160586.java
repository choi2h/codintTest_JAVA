package Programmers.etc.level1;

import java.util.HashMap;
import java.util.Map;

/*
대충 만든 자판
URL : https://school.programmers.co.kr/learn/courses/30/lessons/160586
 */
public class Lesson_160586 {
    public int[] solution(String[] keymap, String[] targets) {
        // 찾으려는 target만큼의 int 배열 생성
        int[] answer = new int[targets.length];

        // 각 문자별로 가장 최소로 접근할 수 있는 횟수를 Map에 저장
        // key : 문자 value : 최소로 접근할 수 있는 횟수
        Map<Character, Integer> countMap = new HashMap<>();

        // 자판기를 순회하며 최소 접근 횟수 저장
        for(String s : keymap) {
            // 자판기 String을 character 배열로 변환
            char[] charArray = s.toCharArray();
            // 모든 문자를 순회하며 접근할 수 있는 횟수 찾음
            for(int i = 0; i< charArray.length; i++) {
                char c = charArray[i];
                // 해당 문자가 이미 Map에 존재하는 경우
                if(!countMap.isEmpty() && countMap.containsKey(c)) {
                    // 현재 횟수와 기존에 Map에 저장되어 있는 횟수 중 작은 값을
                    int count = Math.min(countMap.get(c), i+1);
                    // 다시 Map에 저장
                    countMap.put(c, count);
                } else {
                    // 처음 등록되는 문자는 바로 저장
                    // i는 0부터 시작이나 클릭은 처음이 1이기 때문에 +1을 해줌
                    countMap.put(c, i+1);
                }
            }
        }

        // 타겟의 문자열을 찾기 위해 타겟 순회
        for(int k=0; k<targets.length; k++) {
            // 문자열의 하나하나 문자에 접근하기 위해 charArray 변환
            char[] charArray = targets[k].toCharArray();

            // 문자열을 만들기 위한 총 클릭 횟수를 저장할 count변수 생성
            int count = 0;

            // 문자열의 문자 순회
            for(int i = 0; i< charArray.length; i++) {
                char c = charArray[i];

                // 위에서 생성한 최소 접근 클릭 횟수 Map에 해당 문자가 존재하는지 확인
                if(countMap.containsKey(c)) {
                    // 최소 접근 횟수를 가져와 총 횟수에 더함
                    count += countMap.get(c);
                } else {
                    // 자판에 해당 문자가 없을 경우 만들 수 없는 문자열로 -1 할당
                    count = -1;
                    // 더 이상 볼 필요 없으므 break; 선언하여 for문에서 벗어남
                    break;
                }
            }

            // targets의 k번째 문자열의 클릭 횟수를 answer의 k번째에 저장
            answer[k] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_160586 lesson = new Lesson_160586();
//        String[] keymap = {"ABACD", "BCEFD"};
//        String[] targets = {"ABCD","AABB"};

        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA","BGZ"};

        int[] result = lesson.solution(keymap, targets);
        System.out.print("Result : ");
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
