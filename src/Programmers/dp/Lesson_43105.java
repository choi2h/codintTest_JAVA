package Programmers.dp;

/*
정수 삼각형
https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Lesson_43105 {

    /*
       public int solution(int[][] triangle) {
        //1. 계산 결과를 저장할 배열 선언
        int[][] sumArr = new int[triangle.length][triangle.length];

        sumArr[0][0] = triangle[0][0];

        //2. 각 위치까지의 가장 큰 합을 배열에 저장
        for(int i=1; i<triangle.length; i++) {
            int[] arr = triangle[i];
            //3. 꼭대기부터 바닥까지 자신 위치의 최대값 모두 계산
            for(int j=0; j<=i; j++) {
                int sum = 0;

                if(j == 0) {
                    sum = sumArr[i-1][j] + triangle[i][j];
                } else if(j == i) {
                    sum = sumArr[i-1][j-1] + triangle[i][j];
                }   else {
                    sum = Math.max(sumArr[i - 1][j - 1], sumArr[i - 1][j]) + triangle[i][j];
                }

                sumArr[i][j] = sum;
            }
        }

        //4. 바닥층의 합 중 가장 큰 값을 정답으로 리턴
        int result = 0;
        int[] lastArr = sumArr[sumArr.length-1];
        for(int i=0; i<lastArr.length; i++){
            result = Math.max(lastArr[i], result);
        }

        return result;
    }*/


    public int solution(int[][] triangle) {
        // 위치별 최대합 저장 배열
        int[][] sumArr = new int[triangle.length][triangle.length];

        return findMaxValue(triangle, sumArr, 0, 0);
    }

    private int findMaxValue(int[][] triangle, int[][] sumArr, int depth, int index) {
        // 이미 계산되어 있는 값은 그대로 리턴
        if(sumArr[depth][index] > 0) {
            return sumArr[depth][index];
        }
        // 가장 바닥층의 값은 더해줄 값이 없으므로 해당 값을 그대로 리턴
        else if(depth == triangle.length-1) {
            sumArr[depth][index] = triangle[depth][index];
            return triangle[depth][index];
        }

        // 현재 위치 기준 왼쪽 아래 대각선까지의 합
        int leftValue = findMaxValue(triangle, sumArr, depth+1, index);
        // 현재 위치 기준 오른쪽 아래 대각선까지의 합
        int rightValue = findMaxValue(triangle, sumArr, depth+1, index+1);

        // 위 두 합 중 더 큰 값을 현재위치의 값과 더하여 배열에 저장
        sumArr[depth][index] = triangle[depth][index] + Math.max(leftValue, rightValue);
        return sumArr[depth][index];
    }

    // {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, [4, 5, 2, 6, 5}}
    public static void main(String[] args) {
        Lesson_43105 lesson = new Lesson_43105();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int result = lesson.solution(triangle);
        System.out.println("result = " + result);
    }
}
