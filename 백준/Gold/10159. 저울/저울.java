import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static class Node {
        List<Integer> preNode;
        List<Integer> nextNode;

        public Node() {
            this.preNode = new ArrayList<>();
            this.nextNode = new ArrayList<>();
        }
    }

    private String solution(int nodeCount, Node[] list) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=nodeCount; i++) {
            boolean[] visited = new boolean[list.length+1];
            getKnowCount(list, i, true, visited);
            getKnowCount(list, i, false, visited);

            int count=0;
            for(int j=1; j<=list.length; j++) {
                if(visited[j]) count++;
            }
            sb.append(nodeCount-count).append("\n");
        }

        return sb.toString();
    }

    private void getKnowCount(Node[] list, int start, boolean isPrev, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        queue.addAll(list[start].preNode);
        while(!queue.isEmpty()) {
            int curNode = queue.poll();
            if(curNode != start && visited[curNode]) continue;
            visited[curNode] = true;

            List<Integer> conn = isPrev ? list[curNode].preNode : list[curNode].nextNode;
            for(int j : conn) {
                if(!visited[j]) queue.add(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] arr = new Node[n+1];
        for(int i=1; i<n+1; i++) {
            arr[i] = new Node();
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            arr[to].preNode.add(from);
            arr[from].nextNode.add(to);
        }

        Main q = new Main();
        System.out.println(q.solution(n, arr));
    }
}