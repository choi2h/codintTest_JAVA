package Programmers.basic;

public class Lesson_68935 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%3);
            n = n/3;
        }

        // Integer.parseInt를 사용하면 2번째 인자에 맞는 진법으로 변환하여 반환해줌
        return Integer.parseInt(sb.toString(), 3);
        // 10진법 -> 3진법 변환
//        String[] stringArr = sb.toString().split("");
//        for(int i = 0; i < stringArr.length; i++) {
//            int num = Integer.parseInt(stringArr[i]);
//            if(num == stringArr.length-1) answer += num;
//            else answer += (int) (Math.pow(3, (stringArr.length-i-1))*num);
//        }
//
//        return answer;
    }

    public static void main(String[] args) {
        Lesson_68935 solution = new Lesson_68935();
        System.out.println(solution.solution(125));
    }
}
