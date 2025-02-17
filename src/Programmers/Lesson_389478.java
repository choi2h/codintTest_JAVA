package Programmers;

public class Lesson_389478 {

    public int solution(int n, int w, int num) {
        int target = (num - 1) / w + 1;
        int top = (n - 1) / w + 1;
        int topSpot = n % w == 0 ? w : n % w;

        int targetSpot = (num - 1) % w;
        if (target % 2 == 0) {
            targetSpot = w - targetSpot - 1;
        }

        boolean needsExtraRow = top % 2 == 0 ? (w - topSpot) <= targetSpot : topSpot > targetSpot;
        return top - target + (needsExtraRow ? 1 : 0);
    }

//    public int solution(int n, int w, int num) {
//        int target = num%w == 0 ? num/w : num/w+1;
//        int topCount = n%w;
//        int top = topCount == 0 ? n/w : n/w+1;
//
//        if(topCount == 0) {
//            return top-target+1;
//        }
//
//        // 짝수줄이 가장 위이면 왼쪽으로 상자를 배분
//        int targetSpot = num%w;
//        if(targetSpot != 0 && target%2 == 0) {
//            targetSpot =  w-targetSpot;
//        } else if(targetSpot == 0 && target%2 > 0) {
//            targetSpot = w-1;
//        }
//
//        if(top%2 == 0) {
//            return w-topCount <= targetSpot?  top-target+1 : top-target;
//        }
//
//        return topCount >= targetSpot ? top-target+1 : top-target;
//    }



    /*
        22	6	8	3
        13	3	6	4
     */
    public static void main(String[] args) {
        Lesson_389478 lesson = new Lesson_389478();
//        int answer = lesson.solution(22, 6, 8);
//        int answer = lesson.solution(22, 6, 1);
//        int answer = lesson.solution(13, 13, 5);
//        int answer = lesson.solution(13, 3, 6);
        int answer = lesson.solution(11,2,8);

        /*
              11
            9 10
            8 7
            5 6
            4 3
            1 2
         */
        System.out.println(answer);
    }
}
