package baekJoon;

class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                int p = triangle[i][j];
                if (j != 0) {
                    if(dp[i-1][j-1] + p > dp[i-1][j]+p) {
                        dp[i][j] = dp[i-1][j-1]+p;
                    } else {
                        dp[i][j] = dp[i-1][j]+p;
                    }
                } else {
                    dp[i][j] = dp[i-1][j]+p;
                }
            }
        }

        for(int j=0; j<dp[dp.length-1].length; j++) {
            if(answer < dp[dp.length-1][j]) {
                answer = dp[dp.length-1][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = new int[5][5];

        a[0][0] = 7;
        a[1][0] = 3;
        a[1][1] = 8;
        a[2][0] = 8;
        a[2][1] = 1;
        a[2][2] = 0;
        a[3][0] = 2;
        a[3][1] = 7;
        a[3][2] = 4;
        a[3][3] = 4;
        a[4][0] = 4;
        a[4][1] = 5;
        a[4][2] = 2;
        a[4][3] = 6;
        a[4][4] = 5;

        solution.solution(a);
    }
}