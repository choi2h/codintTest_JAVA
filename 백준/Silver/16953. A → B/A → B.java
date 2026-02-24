import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        Queue<Long> queue = new LinkedList<>();
        Queue<Integer> cntQueue = new LinkedList<>();
        queue.add(A);
        cntQueue.add(1);
        int answer = -1;
        while(!queue.isEmpty() && !cntQueue.isEmpty()) {
            long cur = queue.poll();
            int nextCnt = cntQueue.poll()+1;

            long mul = cur*2;
            long sum = (cur*10)+1;

            if (mul == B || sum == B) {
                answer = nextCnt;
                break;
            }

            if (mul < B) {
                queue.add(mul);
                cntQueue.add(nextCnt);
            }

            if (sum < B) {
                queue.add(sum);
                cntQueue.add(nextCnt);
            }
        }

        System.out.println(answer);
    }
}