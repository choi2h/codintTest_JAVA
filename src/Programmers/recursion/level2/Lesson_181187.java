package Programmers.recursion.level2;

/*
두 원 사이의 정수 쌍
Url: https://school.programmers.co.kr/learn/courses/30/lessons/181187

테스트 1 〉	통과 (0.72ms, 70.7MB)
테스트 2 〉	통과 (0.42ms, 74.2MB)
테스트 3 〉	통과 (0.49ms, 75.7MB)
테스트 4 〉	통과 (1.07ms, 85.1MB)
테스트 5 〉	통과 (0.99ms, 77.3MB)
테스트 6 〉	통과 (1.13ms, 81.1MB)
테스트 7 〉	통과 (30.49ms, 79.3MB)
테스트 8 〉	통과 (44.84ms, 78.7MB)
테스트 9 〉	통과 (33.99ms, 83.5MB)
테스트 10 〉	통과 (32.91ms, 82.8MB)
 */
public class Lesson_181187 {
    public long solution(int r1, int r2) {
        long answer = 0;

        for(int x = 1; x<=r2; x++) {
            // 피타고라스의 정리를 통해 큰 원의 y축 길이를 구함
            double y2 = getYLength(r2, x);
            //해당 x축에 큰원만 존재할 경우 해당 축의 모든 정수인 점이 포함됨
            if(x > r1) {
                answer+= Math.floor(y2);
                continue;
            }

            // 피타고라스의 정리를 통해 작은 원의 y축 길이를 구함
            double y1 = getYLength(r1, x);
            // 만약 y축이 정수값이면 answer에 포함해주어야 함
            // 해당 안되는 0.0을 제외한 내림한 값과 동일한 값일 경우 (ex. 3.0은 내림해도 3.0)
            if(y1 > 0 && y1 == Math.floor(y1)) {
                answer++;
            }
            // y축을 내림하여 가까운 정수인 점 구함
            y1 = Math.floor(y1); // (이 점은 answer에 포함되지 않음)
            y2 = Math.floor(y2); // (이 점은 answer에 포함됨)

            // 큰 원의 y축에서 작은 원의 y축을 빼면 사이에 존재하는 정수인 점을 구할 수 있음
            // 구한 점의 개수를 answer에 더해줌
            answer += y2 - y1;
        }

        // x(0) 혹은 y(0) 축의 큰원에서 작은원까지의 정수인 점도 포함해주어야 한다.
        int y = r2-r1 +1;
        answer += y;

        // 위에까지의 결과는 원의 4/1만 계산한 값이므로
        // 정원의 결과를 위해 4를 곱하여 결과 도출
        answer = answer*4;

        return answer;
    }

    private double getYLength(int r, int x) {
        // Math.pow(밑 값, 제곱하기 위해 사용하는 지수) - 제곱한 값 반환
        double rSquare = Math.pow(r, 2);
        double xSquare = Math.pow(x, 2);
        double ySquare = rSquare - xSquare;

        // Math.sqrt(값) - 값의 제곱근을 반환
        return Math.sqrt(ySquare);
    }

    public static void main(String[] args) {
        Lesson_181187 lesson = new Lesson_181187();
//        long result = lesson.solution(4, 5);
        long result = lesson.solution(25, 39);
        System.out.println(result);
    }
    
}
