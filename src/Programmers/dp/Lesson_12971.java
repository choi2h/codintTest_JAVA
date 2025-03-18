package Programmers.dp;

public class Lesson_12971 {

    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        return Math.max(
                find(sticker, 0, sticker.length - 2),
                find(sticker, 1, sticker.length - 1)
        );
    }

    private int find(int[] sticker, int start, int end ) {
        if(start == end) return sticker[start];

        int[] dp = new int[end+1];
        dp[start] = sticker[start];
        dp[start+1] = Math.max(sticker[start], sticker[start+1]);

        for(int i=start+2; i<=end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }

        return dp[end];
    }


    public static void main(String[] args) {
        Lesson_12971 lesson = new Lesson_12971();
        System.out.println(lesson.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
//        System.out.println(lesson.solution(new int[]{1, 3, 2, 5, 4}));
    }
}
