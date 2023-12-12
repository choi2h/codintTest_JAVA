package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14501 {

    static int[] dp;

    /*
        Bottom-Up 방식으로 풀이
     */
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
        System.out.println("Result=" + result);
    }
}
