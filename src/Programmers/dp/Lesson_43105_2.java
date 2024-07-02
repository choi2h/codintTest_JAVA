package Programmers.dp;

public class Lesson_43105_2 {

    public int solution(int[][] triangle) {
        // 각 지점까지 내려올 때의 가장 큰 합들을 저장
        int[][] sumArr = new int[triangle.length][triangle.length];
        sumArr[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                if(j==i) {
                    sumArr[i][j] = sumArr[i-1][j-1] + triangle[i][j];
                } else if(j == 0) {
                    sumArr[i][j] = sumArr[i-1][j] + triangle[i][j];
                } else {
                    sumArr[i][j] = Math.max(sumArr[i-1][j-1], sumArr[i-1][j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for(int i=0; i<sumArr.length; i++) {
            answer = Math.max(answer, sumArr[sumArr.length-1][i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Lesson_43105_2 lesson = new Lesson_43105_2();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = lesson.solution(triangle);
        System.out.println("result = " + result);
    }
}
