package Programmers.search.binary;

import java.util.Arrays;

public class Lesson_64062 {
    /*
        디딤돌에 숫자가 존재 - 한번 밟을 때마다 1씩 줄어든다.
        숫자가 0이 되면 더 이상 밟을 수 없다.
        다음으로 밟을 수 있는 디딤돌이 여러개일 경우 무조건 가장 가까운 디딤돌로만 건널 수 있다.
        한번에 한명씩 징검다리 건너기 가능
        stones : 디딤돌 리스트
        k : 한 번에 건너뛸 수 있는 디딤돌의 최대 칸 수

        => 최대 몇명까지 다리를 건널 수 있나?
    */
    public int solution(int[] stones, int k) {
        int answer = 0;

        int max = Arrays.stream(stones).max().getAsInt();
        int min = 0;
        while(min <= max) {
            int mid = (min+max)/2;
            int before = -1;
            for(int j=0; j<stones.length; j++) {
                if(j-before > k) break;
                if(stones[j]-mid >= 0) before = j;
            }

            if(before >= stones.length-k) {
                answer = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        return answer;
    }

public static void main(String[] args) {
        Lesson_64062 solution = new Lesson_64062();
//        int result = solution.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
//        int result = solution.solution(new int[]{2, 3, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        int result = solution.solution(new int[]{7, 2, 8, 7, 2, 5, 9}, 3);
//        int result = solution.solution(new int[]{2, 4, 1, 2, 1, 5}, 2);
//        int result = solution.solution(new int[]{5, 5, 5, 2, 2, 9}, 3);
//        int result = solution.solution(new int[]{2, 4, 5, 0, 0, 0, 6, 7, 8}, 3);
//        int result = solution.solution(new int[]{3, 2, 1, 0, 1, 2, 3}, 3);
//        int result = solution.solution(new int[]{5, 5, 5, 5, 5}, 2);
//        int result = solution.solution(new int[]{3, 1, 2, 5, 4}, 1);
//        int result = solution.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2}, 3);
//        int result = solution.solution2(new int[]{2, 4, 5, 3, 2, 1, 4, 2}, 3);
        // 1, 3, 4, 2, 1, 0, 3, 1
        // 0, 2, 3, 1, 0, 0, 2, 0
        // 0, 1, 2, 0, 0, 0, 1, 0
        // 0, 0, 1, 0, 0, 0, 0, 0
        System.out.println(result);
    }
}

/*

    public int solution2(int[] stones, int k) {
        int answer = 0;
        while (go(stones, k)) {
            answer++;
        }

        return answer;
    }

    private boolean go(int[] stones, int k) {
        int before = 0;
        for (int i = 0; i < stones.length; i++) {
            if(i-before > k) return false;

            if(stones[i] > 0) {
                stones[i]--;
                before = i;
            }
        }

        return true;
    }

 */