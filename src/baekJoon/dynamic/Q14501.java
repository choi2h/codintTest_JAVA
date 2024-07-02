package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14501 {

    static int[] dp;

    static int solution(int n, int[] t, int[] p) {
        dp = new int[n+1];

        for(int i=n; i>=1; i--) {
            // 상담이 끝나는 날짜 구함
            int endDate= i + t[i]-1;

            // 마지막날까지 상담을 끝낼 수 없다면 > 해당 상담은 할 수 없음
            if(endDate > n) {
                // 마지막 날이 아니라면 현재까지 가장 최대값 저장
                if(i < n) {
                    dp[i] = dp[i+1];
                }
                continue;
            }

            // 근무 마지막 날이라면
            if(i==n) {
                // 상담 점수 그대로 저장
                dp[i] = p[i];
            }
            // 마지막날 상담이 끝난다면
            else if(endDate == n) {
                // 오늘의 상담을 했을 때와, 오늘 이후에 다른 상담을 진행했을 때 중 돈을 더 많이 버는쪽을 택하여 저장
                dp[i] = Math.max(dp[i+1], p[i]);
            } else {
                // 오늘의 상담을 했을 때(오늘 상담이 끝나고 그 뒤 상담에 대한 값도 더해줌)와,
                // 오늘 이후에 다른 상담을 진행했을 때 중 돈을 더 많이 버는쪽을 택하여 저장
                dp[i] = Math.max(dp[i+1], dp[endDate+1] + p[i]);
            }
        }

        // 누적된 최대값 리턴
        return dp[1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] t = new int[n+1];
        int[] p = new int[n+1];
        for(int i=1; i<=n; i++) {
            String[] s = bf.readLine().split(" ");

            t[i] = Integer.parseInt(s[0]);
            p[i] = Integer.parseInt(s[1]);
        }

        int result = solution(n, t, p);
        System.out.println(result);
    }
}

/*
    static int[] dp;

    *//*
        Bottom-Up 방식으로 풀이
     *//*
    static int solution(int n, int[] t, int[] p) {
        dp = new int[n+1];

        for(int i=1; i<=n; i++) {
            // 오늘 시작하는 업무가 끝나는 날짜 확인
            // -1을 하는 이유는 작업기간이 1부터 시작하기 때문에 [하루걸린다 = 오늘안에 끝난다]라고 판단
            int finishDate = i+t[i]-1;

            // 퇴사날까지 끝낼 수 없는 일이면 하지 않는다.
            if(finishDate > n) {
                System.out.println("Can not finish work. i=" + i + "t=" + t[i]);
                dp[i] = Math.max(dp[i], dp[i-1]);
                continue;
            }

            // 업무가 끝나는 날(finishDate)에 현재 날짜[i]기준으로
            // 어제[i-1] 포인트 + 오늘 업무 포인트를 합친 것과 업무가 끝나는 날 원래 가지고 있는 포인트를 비교하여
            // 가장 큰 포인트를 저장
            dp[finishDate] = Math.max(dp[i-1]+p[i], dp[finishDate]);

            if(finishDate != i) {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }

        int answer = 0;
        for(int r : dp) {
            answer = Math.max(r, answer);
        }

        return answer;
    }*/
