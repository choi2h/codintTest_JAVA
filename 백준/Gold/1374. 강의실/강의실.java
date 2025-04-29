import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        int[][] courses = new int[count][2];
        for(int i = 0; i < count; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            tokenizer.nextToken();
            courses[i][0] = Integer.parseInt(tokenizer.nextToken());
            courses[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(courses, (c1, c2) -> c1[0] == c2[0] ? c1[1] - c2[1] : c1[0] - c2[0]);

        PriorityQueue<Integer> room = new PriorityQueue<>();
        for(int[] course: courses) {
            if(!room.isEmpty() && room.peek() <= course[0]) room.poll();
            room.add(course[1]);
        }

        System.out.println(room.size());
    }
}