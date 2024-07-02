package Programmers.kakao;

public class Lesson_118668 {


    public int solution(int alp, int cop, int[][] problems) {
        // 목표 알고력
        int goal_a=0;
        // 목표 코딩력
        int goal_c=0;
        // 목표치를 구하는 for문
        for(int i =0; i<problems.length;i++){
            goal_a=Math.max(problems[i][0],goal_a);
            goal_c=Math.max(problems[i][1],goal_c);
        }

        // 초기 알고력&코딩력이 목표 알고력&코딩력보다 높으면 시간이 들지 않는다. => 모든 문제를 다 풀 수 있다.
        if(goal_a<=alp&&goal_c<=cop){
            return 0;
        }

        // 초기 알고력이 목표 알고력보다 높으면 초기 알고력을 목표 알고력으로 초기화해준다.
        if(alp>=goal_a){
            alp=goal_a;
        }
        // 초기 코딩력 목표 코딩력보다 높으면 초기 코딩력을 목표 코딩력으로 초기화해준다.
        if(cop>=goal_c){
            cop=goal_c;
        }

        // dp[i][j] 정의 : 알고력 i, 코딩력 j을 도달 할 수 있는 최단시간
        int[][] dp =new int[goal_a+2][goal_c+2];

        // 모든 경우를 맥스값으로 초기화
        for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        // 초기 셋팅에 0으로 초기화
        dp[alp][cop]=0;

        //
        for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){

                // 알고력 : 알고력+1에 이미 셋팅된 값과 현재 시간에서 +1시킨 값 중에 작은 값 세팅
                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);
                // 코딩력 : 코딩력+1에 이미 셋팅된 값과 현재 시간에서 +1시킨 값 중에 작은 값 세팅
                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);

                // 문제를 풀어보자.
                for(int[] p :problems){
                    // 현재 알고력이 문제를 풀 수 있는 알고력보다 크고
                    // 현재 코딩력이 문제를 풀 수 있는 코딩력보다 크면
                    if(i>=p[0]&&j>=p[1]){
                        // 현재 알고력+증가 알고력이 목표 알고력보다 크고
                        // 현재 코딩력+증가 코딩력이 목표 코딩력보다 크면
                        if(i+p[2]>goal_a&&j+p[3]>goal_c){
                            // 목표 알고력&코딩력에 해당 값과, 현재까지의 시간+문제를 풀는 시간 중 더 작은 값을 저장
                            dp[goal_a][goal_c]=Math.min(dp[goal_a][goal_c],dp[i][j]+p[4]);
                        }
                        // 현재 알고력+증가 알고력이 목표 알고력보다 크면
                        else if(i+p[2]>goal_a){

                            dp[goal_a][j+p[3]]=Math.min(dp[goal_a][j+p[3]],dp[i][j]+p[4]);
                        }
                        else if(j+p[3]>goal_c){
                            dp[i+p[2]][goal_c]=Math.min(dp[i+p[2]][goal_c],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]<=goal_a&&j+p[3]<=goal_c){
                            dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                        }
                    }

                }
            }
        }

        return dp[goal_a][goal_c];
    }

    // 알고력이 현재 문제를 푸는 것과 하나씩 플러스 하는 것 중 어떤게 더 빨리 채울 수 있는지 확인
    // 코딩력이 현재 문제를 푸는 것과 하나씩 플러스 하는 것 중 어떤게 더 빨리 채울 수 있는지 확인


    private int getCapacityTime(int alp, int cop, int nextAlp, int nextCop) {
        int time = 0;

        if(nextAlp > alp) {
            time += nextAlp-alp;
        }

        if(nextCop > cop) {
            time += nextCop-cop;
        }

        return time;
    }


}
