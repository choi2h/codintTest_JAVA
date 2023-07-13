package Programmers.etc.level2;

/*
연속된 부분 수열의 합
URL : https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class Lesson_178870 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int sum = 0;
        int startIndex =0;
        int endIndex;
        for(int i=0; i<sequence.length; i++) {
            int num = sequence[i];
            endIndex = i;

            sum += num;
            if(sum == k) {
                if((sequence[0] != k && answer[0] == 0 && answer[1] == 0)
                        || endIndex-startIndex < answer[1]-answer[0]) {
                    answer[0] = startIndex;
                    answer[1] = endIndex;
                }
            } else if(sum>k) {
                while(sum>=k && startIndex<i) {
                    sum -= sequence[startIndex++];
                    startIndex++;

                    if(sum == k) {
                        if((sequence[0] != k && answer[0] == 0 && answer[1] == 0)
                                || endIndex-startIndex < answer[1]-answer[0]) {
                            answer[0] = startIndex;
                            answer[1] = endIndex;
                        }
                    }
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_178870 lesson = new Lesson_178870();
//        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
//        int[] sequence = {1, 1, 1, 1, 4, 4};
//        int[] sequence = {2, 2, 2, 2, 2};
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] result = lesson.solution(sequence, k);
        System.out.println("================= result =================");
        for(int i : result) {
            System.out.println(i);
        }
    }
}
