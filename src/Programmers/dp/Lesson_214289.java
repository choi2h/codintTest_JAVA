package Programmers.dp;


public class Lesson_214289 {

    // int[시간][최소전력]
    int[][] dp;

    /**
     쾌적한 실내온도 [t1(MIN)~t2(MAX)]

     희망온도 - 실내온도 : 매 분 1도 변경
     - 다를 때 : 매 분 a만큼 소비
     - 같을 때 : 매 분 b만큼 소비
     실외온도 - 실내온도
     - 꺼져있으면 전력 소비는 없으나 같아지는 방향으로 매 분 1도 변경
     **/
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = 0;
        dp = new int[onboard.length+1][51];

        // 실외온도가 쾌적 온도 범위 내에 있을 시 에어컨은 가동하지 않아도 된다.
        if(isNecessaryTemperature(temperature, t1, t2)) {
            return 0;
        }

        temperature = temperature+11;
        t1 = t1+11;
        t2 = t2+11;

        if(temperature > 0) {
            dp[1][temperature-1] = temperature > t2 ? a : 0;
        }

        if(temperature < 50) {
            dp[1][temperature+1] = temperature < t1 ? a : 0;
        }

        for(int i=2; i<onboard.length; i++) {
            int isOnboard = onboard[i];
            int min = t1;
            int max = t2;
            if(isOnboard == 0) {
                if(temperature < t1) {
                    min = temperature;
                } else if(temperature > t2){
                    max = temperature;
                }
            }

            for(int j=min; j <= max; j++) {
                int beforeScore = dp[i-1][j];
                if(beforeScore == 0) {
                    continue;
                }

                if(j > temperature) {
                    if(j > 0) {
                        dp[i][j-1] = min(beforeScore, dp[i][j-1]);
                    }
                    if(max != j) {
                        dp[i][j + 1] = min(beforeScore + a, dp[i][j + 1]);
                    }
                } else if(j < temperature){
                    if(j > 0) {
                        dp[i][j-1] = min(beforeScore+a, dp[i][j-1]);
                    }
                    if(max != j) {
                        dp[i][j+1] = min(beforeScore, dp[i][j+1]);
                    }
                } else {
                    if(j > 0) {
                        dp[i][j-1] = min(beforeScore+a, dp[i][j-1]);
                    }
                    if(max != j) {
                        dp[i][j+1] = min(beforeScore+a, dp[i][j+1]);
                    }
                }

                if(j == temperature) {
                    dp[i][j] = beforeScore;
                } else {
                    dp[i][j] = min(beforeScore+b, dp[i][j]);
                }
            }
        }


        int min = Math.min(temperature, t1);
        int max = Math.max(temperature, t2);
        for(int i=min;i<=max; i++) {
            answer = min(answer, dp[onboard.length-1][i]);
        }

        return answer;
    }

    private int min(int a, int b) {
        if (a==0) {
            return b;
        } else if(b==0) {
            return a;
        } else {
            return Math.min(a, b);
        }
    }

    private boolean isNecessaryTemperature(int temperature, int min, int max) {
        return min < temperature && max > temperature;
    }

    /*
       현재온도   t1    t2    a   b   onboard                                 result
        28	    18	  26	10	8	[0, 0, 1, 1, 1, 1, 1]	                40
        -10	    -5	  5	    5	1	[0, 0, 0, 0, 0, 1, 0]	                25
        11	    8	  10	10	1	[0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1]	20
        11	    8	  10	10	100	[0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1]	60
     */
    public static void main(String[] args) {
        int temperature = -10;
        int t1 = -5;
        int t2 = 5;
        int a = 5;
        int b = 1;
        int[] onboard = {0, 0, 0, 0, 0, 1, 0};

        Lesson_214289 lesson = new Lesson_214289();
        int result = lesson.solution(temperature, t1, t2, a, b, onboard);
        System.out.println(result);
    }
}
