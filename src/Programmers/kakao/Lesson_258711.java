package Programmers.kakao;

import java.util.*;

public class Lesson_258711 {

    Map<Integer, List<Integer>> incomingEdgeMap = new HashMap<>();
    Map<Integer, List<Integer>> outingEdgeMap = new HashMap<>();

    public int[] solution(int[][] edges) {
        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];

            List<Integer> startVertex = outingEdgeMap.getOrDefault(start, new ArrayList<>());
            startVertex.add(end);
            outingEdgeMap.put(start, startVertex);

            List<Integer> endVertex = incomingEdgeMap.getOrDefault(end, new ArrayList<>());
            endVertex.add(start);
            incomingEdgeMap.put(end, endVertex);
        }

        System.out.println("outingEdge = " + outingEdgeMap);
        System.out.println("incomingEdge = " + incomingEdgeMap);

        int createdVertex = findCreatedVertex();
        int totalGraphCount = outingEdgeMap.get(createdVertex).size();
        outingEdgeMap.remove(createdVertex);

        int stickGraphCount = getStickGraphCount();
        int eightGraphCount = getEightGraphCount(createdVertex);
        int donutGraphCount = totalGraphCount - (stickGraphCount+eightGraphCount);

        int[] answer = new int[4];
        answer[0] = createdVertex;
        answer[1] = donutGraphCount;
        answer[2] = stickGraphCount;
        answer[3] = eightGraphCount;

        return answer;
    }

    private int findCreatedVertex() {
        for(int vertex : outingEdgeMap.keySet()) {
            List<Integer> incomingEdges = incomingEdgeMap.get(vertex);
            if((incomingEdges == null || incomingEdges.isEmpty()) && outingEdgeMap.get(vertex).size() >= 2) {
                return vertex;
            }
        }

        return 0;
    }

    private int getStickGraphCount() {
        int stickGraphCount = 0;
        for(int i : incomingEdgeMap.keySet()) {
            List<Integer> outingEdges = outingEdgeMap.get(i);
            if(outingEdges == null || outingEdges.isEmpty()) {
                stickGraphCount++;
            }
        }

        return stickGraphCount;
    }

    private int getEightGraphCount(int createdVertex) {
        int eightGraphCount = 0;
        for(int key : outingEdgeMap.keySet()) {
            int outingEdgeCount = outingEdgeMap.get(key).size();
            int incomingEdgeCount = getIncomingEdgeCount(createdVertex, key);

            if(outingEdgeCount == 2 && incomingEdgeCount == 2) {
                eightGraphCount++;
            }
        }

        return eightGraphCount;
    }

    private int getIncomingEdgeCount(int createdVertex, int vertex) {
        List<Integer> incomingEdges = incomingEdgeMap.get(vertex);
        if(incomingEdges == null || incomingEdges.isEmpty()) {
            return 0;
        }

        for(int v : incomingEdges) {
            if(v == createdVertex) {
                return incomingEdges.size()-1;
            }
        }

        return incomingEdges.size();
    }

    public static void main(String[] args) {
        Lesson_258711 lesson = new Lesson_258711();
//        int[][] arr = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        int[][] arr = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {7, 11}, {4, 8}, {9, 6}, {10, 11},
                {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
//        int[][] arr = {{1, 12}, {8, 3}, {12, 7}, {7, 11}, {9, 6}, {10, 11}, {6, 10}, {3, 5},
//                 {11, 1}, {5, 3}, {11, 9},{3, 8}, {4, 11}, {4, 8}};
//        int[][] arr = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8},
//                {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};

        int[] result = lesson.solution(arr);
        System.out.println("result = " + Arrays.toString(result));
    }
}
