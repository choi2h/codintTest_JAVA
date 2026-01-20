import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> friends = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            addFriend(friends, a, b);
            addFriend(friends, b, a);
            if (!counts.containsKey(a)) counts.put(a, 0);
            if (!counts.containsKey(b)) counts.put(b, 0);
        }

        int minFriend = 0;
        int minCount = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> nodeQueue = new LinkedList<>();
        for (int key : counts.keySet()) {
            visited[key] = true;
            find(key, friends, nodeQueue, counts, visited);
            nodeQueue.clear();

            int sum = sumAndReset(counts);
            if (sum < minCount) {
                minCount = sum;
                minFriend = key;
            } if (sum == minCount) minFriend = Math.min(minFriend, key);

            Arrays.fill(visited, false);
        }

        System.out.println(minFriend);
    }

    private static void find(int n, Map<Integer, Set<Integer>> friends,
            Queue<Integer> nodeQueue, Map<Integer, Integer> counts, boolean[] visited) {
        nodeQueue.add(n);

        while(!nodeQueue.isEmpty()) {
            int cur = nodeQueue.poll();

            int curCnt = counts.get(cur);
            for (int next : friends.get(cur)) {
                if (visited[next] || next == n) continue;

                if (counts.get(next) == 0) counts.put(next, curCnt+1);
                visited[next] = true;
                nodeQueue.add(next);
            }
        }
    }

    private static void addFriend(Map<Integer, Set<Integer>> friends, int a, int b) {
        Set<Integer> aFriends = friends.getOrDefault(a, new HashSet<>());
        aFriends.add(b);
        friends.put(a, aFriends);
    }

    private static int sumAndReset(Map<Integer, Integer> counts) {
        int sum = 0;
        for (int key : counts.keySet()) {
            sum += counts.get(key);
            counts.put(key, 0);
        }

        return sum;
    }
}