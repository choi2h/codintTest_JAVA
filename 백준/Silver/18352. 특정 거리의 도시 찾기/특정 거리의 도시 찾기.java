import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int count;
        List<Integer> nextNodes;

        Node() {
            count = 0;
            nextNodes = new ArrayList<>();
        }

        void addNextNode(int i) {
            nextNodes.add(i);
        }
    }

    private String solution(int nodeCount, Node[] list, int findDistance, int start) {
        list[start].count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            Node curNode = list[queue.poll()];
            for(int nextNode : curNode.nextNodes) {
                if(list[nextNode].count == 0 || list[nextNode].count > curNode.count+1)  {
                    queue.add(nextNode);
                    list[nextNode].count = curNode.count+1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<list.length; i++) {
            Node node = list[i];
            if (node.count-1 == findDistance) sb.append(i).append("\n");
        }

        return sb.length() == 0 ? "-1" : sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Node[] list = new Node[n+1];
        for(int i=0; i<n+1; i++) {
            list[i] = new Node();
        }
        for(int i=0; i<m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st1.nextToken());
            int to = Integer.parseInt(st1.nextToken());
            list[from].addNextNode(to);
        }

        Main q = new Main();
        String result = q.solution(n, list, k, x);
        System.out.println(result);
    }
}