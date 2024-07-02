package Programmers.kakao;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 2022 KAKAO TECH INTERNSHIP
// 두 큐 합 같게 만들기
public class Lesson_118667 {

    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        Deque<Integer> q1 = new ArrayDeque();
        Deque<Integer> q2 = new ArrayDeque();
        long tot1 = 0, tot2 = 0;
        for(int i = 0; i < n; i++){
            tot1 += queue1[i];
            q1.add(queue1[i]);
        }
        for(int i = 0; i < n; i++){
            tot2 += queue2[i];
            q2.add(queue2[i]);
        }
        for(int i = 0; i < 4*n + 1; i++){
            if(tot1 == tot2) return i;
            if(tot1 < tot2){
                int x = q2.getFirst();
                tot1 += x;
                tot2 -= x;
                q1.add(x);
                q2.removeFirst();
            }
            else{
                int x = q1.getFirst();
                tot2 += x;
                tot1 -= x;
                q2.add(x);
                q1.removeFirst();
            }
        }
        return -1;
    }

    /*public int solution(int[] queue1, int[] queue2) {
        int queue1Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for(int i : queue1) {
            queue1Sum+=i;
            q1.offer(i);
        }

        Queue<Integer> q2 = new LinkedList<>();
        int queue2Sum = 0;
        for(int i : queue2) {
            queue2Sum+=i;
            q2.offer(i);
        }

        int totalSum = queue1Sum + queue2Sum;
        if(totalSum%2 != 0) {
            return -1;
        }

        int len = queue1.length;
        int resultSumValue = totalSum/2;
        int count = 0;
        while (queue1Sum != queue2Sum) {
            count++;

            if(queue1Sum > queue2Sum) {
                int num = q1.poll();
                if(num > resultSumValue) {
                    return -1;
                }

                queue1Sum -= num;
                queue2Sum += num;
                q2.offer(num);
            } else{
                int num = q2.poll();
                if(num > resultSumValue) {
                    return -1;
                }

                queue2Sum -= num;
                queue1Sum += num;
                q1.offer(num);
            }

//
//            if((queue1Sum == resultSumValue && queue2Sum != resultSumValue) || (queue2Sum == resultSumValue && queue1Sum != resultSumValue)) {
//                return -1;
//            }

            if(count >= len*4) {
                return -1;
            }
        }


        return count;
    }*/

    /*
        [3, 2, 7, 2]	[4, 6, 5, 1]	2
        [1, 2, 1, 2]	[1, 10, 1, 2]	7
        [1, 1]	[1, 5]	-1
        [8, 8]	[2, 8]	-1
     */
    public static void main(String[] args) {
        Lesson_118667 lesson = new Lesson_118667();
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4, 6, 5, 1};
//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};
//        int[] queue1 = {1, 1};
//        int[] queue2 = {1, 5};
//         3
//        int[] queue1 = {9, 7, 2};
//        int[] queue2 = {9, 2, 11};
        // 12
//        int[] queue1 = {1,1,1,1,1};
//        int[] queue2 = {1,1,1,9,1};
        // -1
//        int[] queue1 = {8, 8};
//        int[] queue2 = {2, 8};

//        int[] queue1 = {1,1,1,1,1,1};
//        int[] queue2 = {1,1,1,1,11,1};

        int[] queue1 = {101,100};
        int[] queue2 = {102,103};
        int result = lesson.solution(queue1, queue2);
        System.out.println(result);
    }
}
