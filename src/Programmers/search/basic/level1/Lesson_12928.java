package Programmers.search.basic.level1;

public class Lesson_12928 {

    // 자신(n)을 제외한 약수 중 가장 큰 값은 : n/2 => n의 절반값
    public int solution(int n) {
        int answer = 0;
        // 약수를 구하기 위한 루프를 절반만 돌아도 됨.
        for(int i=1; i<=n/2; i++) {
            // 나누어 떨얼지는 값을 정답에 더함
            if(n%i == 0) {
                answer += i;
            }
        }

        return answer+n;
    }

    /*
    정답에 합해진 약수를 표시하기 위해 배열 생성
     - 주어진 값 n+1 길이(배열의 인덱스는 0부터 시작) 배열 생성
     - int 배열은 생성 시 모든 값이 0으로 초기화 됨
     - 약수로 더한 값은 배열 내의 값을 1로 변경하며 체크
    n이 i로 나누어 떨어지면 약수 i와 i/n값을 정답에 더함
    i와 i/n이 같은 값이면 한번만 더함
        -> ex) 2*2 = 4 ==> 정답에 2 하나만 더함
    public int solution(int n) {
        int answer = 0;

        int[] arr = new int[n+1];
        for(int i=1; i<=arr.length/2; i++) {
            if(arr[i] == 0 && n%i == 0) {
                arr[i] = arr[n/i] = 1;
                answer += n/i == i ? i : n/i + i;
            }
        }

        return answer;
    }
     */

    public static void main(String[] args) {
        Lesson_12928 lesson = new Lesson_12928();
        int result = lesson.solution(12);
        System.out.println(result);
    }
}
