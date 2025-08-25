import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            else if(n == 0) queue.poll();
            else {
                if(queue.size()>=size) continue;
                queue.offer(n);
            }
        }

        if(queue.isEmpty()) {
            System.out.println("empty");
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }

        System.out.println(sb);
    }

}