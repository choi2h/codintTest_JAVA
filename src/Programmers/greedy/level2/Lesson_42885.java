package Programmers.greedy.level2;

import java.util.Arrays;

public class Lesson_42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int lp =0, rp = people.length-1;
        while(lp <= rp) {
            int weight = people[rp--];

//            while(lp<=rp && weight+people[rp] <= limit) {
//                weight += people[rp--];
//            }

            while (lp<=rp && weight+people[lp] <= limit) {
                weight += people[lp++];
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson_42885 obj = new Lesson_42885();
        System.out.println(obj.solution(new int[]{50, 40, 30, 30, 30, 30}, 100));
    }
}
