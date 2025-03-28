package Programmers.dfsbfs;

import java.util.Arrays;
import java.util.Comparator;

public class Lesson_43164 {
    private String[] answer;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));

        boolean[] visited = new boolean[tickets.length];
        String[] route = new String[tickets.length+1];
        route[0] = "ICN";

        find(tickets, visited, route, 1);

        return answer;
    }

    private void find(String[][] tickets, boolean[] visited, String[] route, int cnt) {
        if(cnt >= route.length) {
            answer = Arrays.copyOf(route, route.length);
            return;
        }

        for(int i=0; i<tickets.length; i++) {
            if(visited[i]) continue;
            if(!visited[i] && tickets[i][0].equals(route[cnt-1])) {
                visited[i] = true;
                route[cnt] = tickets[i][1];
                find(tickets, visited, route, cnt+1);
                visited[i] = false;

                if(answer != null) return;
            }
        }
    }

    public static void main(String[] args) {
        Lesson_43164 obj = new Lesson_43164();
//        String[][] tickets = new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets = new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ICN"}, {"ATL","HND"}};
        System.out.println(Arrays.toString(obj.solution(tickets)));
    }
}
