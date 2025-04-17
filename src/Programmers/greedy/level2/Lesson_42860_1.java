package Programmers.greedy.level2;

public class Lesson_42860_1 {
    public int solution(String name) {
        int answer = 0;

        char[] charArr = name.toCharArray();
        int l = 0;
        int r = charArr.length - 1;
        boolean reverseFlag = false;
        while (l <= r) {
            int p = reverseFlag ?  r-- : l++;
            answer += Math.min('Z'-charArr[p]+1, charArr[p]-'A');

            int nextPoint = l;
            while(nextPoint<=charArr.length-1  && charArr[nextPoint] == 'A') {
                nextPoint++;
            }

            int reverseNext = r;
            while(reverseNext>l && charArr[reverseNext] == 'A') {
                reverseNext--;
            }

            // 뒤에서부터 세는거 검사
            if(reverseFlag ? reverseNext == l : nextPoint == charArr.length-1) break;
            if(l < nextPoint && charArr.length-1-reverseNext+p < nextPoint-p) {
                l=nextPoint-1;
                r = reverseNext;
                reverseFlag = true;
                answer += charArr.length-nextPoint+p-1;
            } else if(reverseFlag) {
                r = reverseNext;
                answer += p-reverseNext;
            } else {
                l = nextPoint;
                answer += nextPoint-p;
            }
        }

        return answer-1;
    }

    public static void main(String[] args) {
        Lesson_42860_1 sol = new Lesson_42860_1();
//        System.out.println(sol.solution("JEROEN"));
        System.out.println(sol.solution("JAN"));
    }
}
