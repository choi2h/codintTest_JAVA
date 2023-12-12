package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q11720 {

    static int solution(String num, int n) {
        int answer=0;

        char[] nums = num.toCharArray();
        for(char c : nums) {
            answer += c-'0';
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String nums = bf.readLine();

        int answer = solution(nums, n);
        System.out.println(answer);
    }
}
