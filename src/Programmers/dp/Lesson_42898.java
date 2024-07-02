package Programmers.dp;

import java.util.regex.Pattern;

public class Lesson_42898 {
    public int solution(int m, int n, int[][] puddles) {
        // 각 지점마다의 이동 횟수를 저장할 배열 생성
        // 집의 좌표가 1,1 이므로 배열의 시작을 1,1로 만들기 위해 +1을 하여 칸을 늘림
        int[][] sumArr = new int[n+1][m+1];

        // 물웅덩이가 있는 부분은 -1로 미리 표시
        for(int[] puddle : puddles) {
            sumArr[puddle[1]][puddle[0]] = -1;
        }

        // 집이 있는 부분을 1로 미리 저장
        sumArr[1][1] = 1;
        for(int i=1; i< sumArr.length; i++) {
            for(int j=1; j< sumArr[i].length; j++) {
                if(i==1 && j==1) {
                    continue;
                }

                if(sumArr[i][j] == -1) {
                    sumArr[i][j] = 0;
                } else {
                    sumArr[i][j] = (sumArr[i][j-1] + sumArr[i-1][j]) % 1000000007;
                }
            }
        }



        return sumArr[n][m];
    }

    // m	n	puddles	return
    // 4	3	[[2, 2]]	4
    public static void main(String[] args) {
        Lesson_42898 lesson = new Lesson_42898();
//        int m = 4;
//        int n = 3;
//        int[][] puddles = {{2,2}};

        int m = 2;
        int n = 2;
        int[][] puddles = {{1,2}};


        int result = lesson.solution(m, n, puddles);
        System.out.println(result);
    }
}
