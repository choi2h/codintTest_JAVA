package Programmers.greedy.level1;

import java.util.Arrays;

public class Lesson_42862 {
//    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = n-lost.length;
//
//        Arrays.sort(lost);
//        Arrays.sort(reserve);
//
//        int j=0;
//        for(int i=0; i<lost.length; i++) {
//            if(j >= reserve.length) {
//                break;
//            }
//
//            while (j < reserve.length && lost[i] >= reserve[j]) {
//                if(lost[i] == reserve[j]) {
//                    answer++;
//                    lost[i] = -1;
//                    reserve[j] = -1;
//                    j++;
//                } else {
//                    j++;
//                }
//            }
//        }
//
//        int lIndex = 0;
//        int rIndex = 0;
//        while (lIndex < lost.length && rIndex < reserve.length) {
//            if(lost[lIndex] == -1) {
//                lIndex++;
//                continue;
//            } else if(reserve[rIndex] == -1) {
//                rIndex++;
//                continue;
//            }
//
//            int lostNumber = lost[lIndex];
//            int reserveNumber = reserve[rIndex];
//
//
//            if(lostNumber+1 == reserveNumber || lostNumber-1 == reserveNumber) {
//                lIndex++;
//                rIndex++;
//                answer++;
//                continue;
//            }
//
//            if(lostNumber-1 > reserveNumber) {
//                rIndex++;
//            } else if(lostNumber+1 < reserveNumber) {
//                lIndex++;
//            }
//         }
//
//
//        return answer;
//    }
//


    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] people = new int[n];

        for(int l : lost) {
            people[l-1]--;
        }

        for(int r : reserve) {
            people[r-1]++;
        }

        for(int i=0; i<people.length; i++) {
            if(people[i] == -1) {
                if(i-1 >= 0 && people[i-1] == 1) {
                    people[i] = 0;
                    people[i-1] = 0;
                } else if(i+1 < people.length && people[i+1] == 1) {
                    people[i] = 0;
                    people[i+1] = 0;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }

    /**
     * n	lost	reserve	return
     * 5	[2, 4]	[1, 3, 5]	5
     * 5	[2, 4]	[3]	4
     * 3	[3]	[1]	2
     */

    public static void main(String[] args) {
        Lesson_42862 lesson = new Lesson_42862();
        int n = 3;
        int[] lost = {1, 2};
        int[] reserve = {2, 3};

        int result = lesson.solution(n, lost, reserve);
        System.out.println("result = " + result);
    }
}
