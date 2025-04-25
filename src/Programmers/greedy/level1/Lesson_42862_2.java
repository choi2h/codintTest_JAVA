package Programmers.greedy.level1;

public class Lesson_42862_2 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생 번호대로 배열 생성 => 배열은 index가 0부터 시작하니 n번 학생을 구하려면 크기는 n+1로 설정
        // int 배열은 생성 시 모두 0으로 초기화 됨
        int[] students = new int[n+1];
        // 체육복을 잃어버린 학생들은 -1
        for (int k : lost) students[k]--;
        // 여분 체육복이 있는 학생들은 +1
        // 만약 두벌을 가지고 있다가 한벌을 잃어버린 학생은 0으로 수렴되어 자기가 입음
        for (int j : reserve) students[j]++;

        int answer = 0;
        // 학생 배열을 순회
        for(int i=1; i<=n; i++) {
            // 체육복이 없는 학생이면
            if(students[i] == -1) {
                // 앞번호 학생이 여분 체육복이 있을 시 빌려입음
                if(i > 0 && students[i-1] >= 1) {
                    students[i]++;
                    students[i-1]--;
                }
                // 앞번호 학생이 없을 때, 뒷번호 학생이 여분 체육복이 있을 시 빌려입음
                else if(i < n && students[i+1] >= 1) {
                    students[i]++;
                    students[i+1]--;
                }
            }

            // 결과적으로 현재 학생이 체육복을 갖고 있다고(0) 판단되면 체육수업을 들을 수 있는 학생 수 증가
            if(students[i] >= 0) answer++;
        }

        return answer;
    }
}
