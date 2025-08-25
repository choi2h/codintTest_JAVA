import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            String input = br.readLine();

            if(input.startsWith("push_back")) {
                queue.addLast(Integer.parseInt(input.split(" ")[1]));
            } else if(input.startsWith("push_front")) {
                queue.addFirst(Integer.parseInt(input.split(" ")[1]));
            } else if(input.equals("pop_back")) {
                sb.append(queue.isEmpty() ? -1 : queue.removeLast()).append("\n");
            } else if(input.equals("pop_front")) {
                sb.append(queue.isEmpty() ? -1 : queue.removeFirst()).append("\n");
            } else if(input.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if(input.equals("empty")) {
                sb.append(queue.isEmpty() ? 1:0).append("\n");
            } else if(input.equals("front")) {
                sb.append(queue.isEmpty() ? -1 : queue.getFirst()).append("\n");
            } else if(input.equals("back")) {
                sb.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
            }
        }

        System.out.print(sb);
    }

}