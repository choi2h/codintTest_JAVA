package baekJoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(delivery(n));
    }

    static int delivery(int n) {
        // 5로 나누었을 때
        if(n%5 == 0) {
            return n/5;
        }

        // 5와 3으로 적절히 나누었을 때
        if(n > 5) {
            for(int i=n/5; i>0; i--) {
                int m = n - i*5;
                if(m%3 == 0) {
                    return i+m/3;
                }
            }
        }

        // 3으로 나누었을 때
        if(n%3 == 0) {
            return n/3;
        }

        // 나누어지지 않을 때
       return -1;
    }
}
