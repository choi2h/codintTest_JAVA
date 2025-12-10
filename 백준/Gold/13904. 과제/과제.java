import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] tasks = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            tasks[i][0] = Integer.parseInt(input[0]);
            tasks[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));
        int last_day = tasks[N-1][0];
        int[] check = new int[last_day +1];
        for (int i=0; i<N; i++) {
            int[] tmp = new int[last_day+1];
            int deadline = tasks[i][0];
            int score = tasks[i][1];
            for (int d=1; d<=deadline; d++) {
                tmp[d] = Math.max(check[d], check[d-1]+score);
            }

            check = tmp;
        }

        int max_score = 0;
        for (int score: check) {
            max_score = Math.max(max_score, score);
        }
        System.out.print(max_score);
    }

}
