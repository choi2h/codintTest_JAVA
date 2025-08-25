import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int findIndex = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[count];
            int index = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            while(count-- > 0) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{index, num});
                arr[index++] = num;
            }

            Arrays.sort(arr, Collections.reverseOrder());
            index = 0;
            while(index < arr.length && !queue.isEmpty()) {
                if(queue.peek()[1] == arr[index]) {
                    index++;
                    int[] num = queue.poll();
                    if(num[0] == findIndex) break;
                } else {
                    queue.offer(queue.poll());
                }
            }

            sb.append(index).append("\n");
        }

        System.out.print(sb);
    }
}