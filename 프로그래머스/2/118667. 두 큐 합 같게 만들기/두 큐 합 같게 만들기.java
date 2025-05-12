import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
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
            } else {
                int num = q2.poll();
                if(num > resultSumValue) {
                    return -1;
                }

                queue2Sum -= num;
                queue1Sum += num;
                q1.offer(num);
            }


            if(count >= len*4) {
                return -1;
            }
        }


        return count;
    }
}