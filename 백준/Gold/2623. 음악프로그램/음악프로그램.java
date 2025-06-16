import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Singer {
        List<Integer> pre;
        List<Integer> post;

        public Singer(int n) {
            pre = new ArrayList<>();
            post = new ArrayList<>();
        }

        void addPre(int n) {
            pre.add(n);
        }

        void addPost(int n) {
            post.add(n);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n+1];
        for(int i=0; i<m; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            list[i] = new ArrayList<>();
            int x = Integer.parseInt(input.nextToken());
            for(int j=0; j<x; j++) {
                int next = Integer.parseInt(input.nextToken());
                list[i].add(next);
            }
        }

        boolean isValid = true;
        Singer[] singers = new Singer[n+1];
        for(int i=0; i<n+1; i++) {
            singers[i] = new Singer(n+1);
        }

        for(List<Integer> l : list) {
            if(l == null) continue;
            for(int i=0; i<l.size()-1; i++) {
                int pre = l.get(i);
                int post = l.get(i+1);

                singers[post].addPre(pre);
                singers[pre].addPost(post);
            }
        }

        if(!isValid) {
            System.out.println(0);
            return;
        }

        String answer = solution(singers);
        System.out.println(answer);
    }

    private static String solution(Singer[] singers) {
        int[] orders = new int[singers.length];
        for(int i=1; i<singers.length; i++) {
            if(singers[i].pre.isEmpty()) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean[] visited = new boolean[singers.length];
            int count = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();

                if(visited[cur]) continue;
                visited[cur] = true;
                count++;
                for (int next : singers[cur].pre) {
                    if(next == i) return "0";
                    if(!visited[next]) queue.add(next);
                }
            }

            orders[i] = count;
        }


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<orders.length; i++) {
            for(int j=1; j<orders.length; j++) {
                if(orders[j] == i) sb.append(j).append("\n");
            }
        }

        return sb.toString();
    }
}