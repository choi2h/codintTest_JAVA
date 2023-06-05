package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
메모리: 72432KB / 시간 : 560ms
 */
public class Main {

    private StringBuilder sb = new StringBuilder();
    int count=0;

    public int solution(int n) {
      HANOI(n, 1, 2, 3);

      System.out.println(count);
      System.out.println(sb.toString());
      return count;
    }

    private void HANOI(int n, int from, int mid, int to) {
//        System.out.println(n + " : from[" + from + "] mid[" + mid +"] to[" + to +"]");

        if(n==1) {
            sb.append(from + " " + to + "\n");
            count++;
            return;
        }

        HANOI(n-1, from, to, mid);

        sb.append(from + " " + to + "\n");
        count++;

        HANOI(n-1, mid, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        int n = Integer.parseInt(br.readLine());

        main.solution(n);
    }


}
