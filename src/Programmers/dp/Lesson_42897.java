package Programmers.dp;

public class Lesson_42897 {

    public int solution(int[] money) {
        int[][] dp = new int[2][money.length];
        dp[0][0] = money[0];
        dp[0][1] = money[0];
        dp[1][0] = 0;
        dp[1][1] = money[1];

        for(int i=2; i<money.length; i++) {
            dp[0][i] = i == money.length-1 ? dp[0][i-1] : Math.max(dp[0][i-1], dp[0][i-2]+money[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+money[i]);
        }

        return Math.max(dp[0][money.length-2], dp[1][money.length-1]);
    }

    public static void main(String[] args) {
        Lesson_42897 lesson  = new Lesson_42897();
//        int[] money = {1, 2, 3, 1}; // 4
//        int[] money = {10, 1, 1, 10}; // 11
//        int[] money = {1, 2, 100, 2, 1}; //101
//        int[] money = {5, 5, 5, 5, 5}; //10
//        int[] money = {100, 1, 1, 100, 1}; //101
//        int[] money = {1, 100, 100, 1}; //101
//        int[] money = {0, 0, 0, 0}; //0
//        int[] money = {100, 1, 1, 1, 100}; //101
//        int[] money = {1, 100, 1, 100, 1}; //200
//        int[] money = {10, 20, 30, 0, 0, 0}; //40
//        int[] money = {10, 0, 0, 0, 10}; //10
//        int[] money = {100, 1, 1, 100, 1}; //10
//        int[] money = {2, 3, 2, 3, 2, 3, 2, 3}; //12
//        int[] money = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //30
//        int[] money = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; //30
//        int[] money = {1, 2, 3, 1, 2, 3, 1, 2, 3}; // 9
//        int[] money = {5, 1, 1, 5, 1, 1, 5}; // 11
//        int[] money = {10, 5, 3, 1, 10}; // 15
//        int[] money = {1, 1, 1}; // 2
//        int[] money = {1,3,4,8,6,4,9,9}; // 24
        int[] money = {91, 90, 5, 7, 5, 7}; // 104
//        int[] money = {90, 0, 0, 95, 1, 1}; // 185
//        int[] money = new int[1000000];
//        Arrays.fill(money, 1);
        int result = lesson.solution(money);
        System.out.println(result);
    }

}
