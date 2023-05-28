package Programmers.graph.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
게임맵 최단 거리
URL : https://school.programmers.co.kr/learn/courses/30/lessons/1844

테스트 1 〉	통과 (0.13ms, 78.1MB)
테스트 2 〉	통과 (0.16ms, 69.9MB)
테스트 3 〉	통과 (0.21ms, 79.2MB)
테스트 4 〉	통과 (0.14ms, 80.4MB)
테스트 5 〉	통과 (0.19ms, 86.4MB)
테스트 6 〉	통과 (0.14ms, 69.9MB)
테스트 7 〉	통과 (0.17ms, 78.1MB)
테스트 8 〉	통과 (0.24ms, 79.6MB)
테스트 9 〉	통과 (0.15ms, 76.7MB)
테스트 10 〉	통과 (0.17ms, 72.9MB)
테스트 11 〉	통과 (0.20ms, 76.7MB)
테스트 12 〉	통과 (0.19ms, 78.1MB)
테스트 13 〉	통과 (0.22ms, 70.8MB)
테스트 14 〉	통과 (0.17ms, 72.2MB)
테스트 15 〉	통과 (0.23ms, 74.7MB)
테스트 16 〉	통과 (0.12ms, 80.9MB)
테스트 17 〉	통과 (0.71ms, 71.8MB)
테스트 18 〉	통과 (0.13ms, 77.8MB)
테스트 19 〉	통과 (0.13ms, 65.9MB)
테스트 20 〉	통과 (0.15ms, 71MB)
테스트 21 〉	통과 (0.11ms, 76.2MB)

효율성  테스트
테스트 1 〉	통과 (6.59ms, 56.7MB)
테스트 2 〉	통과 (2.02ms, 54.1MB)
테스트 3 〉	통과 (6.05ms, 55MB)
테스트 4 〉	통과 (5.77ms, 53.5MB)
 */
public class Lesson_1844 {

    public int solution(int[][] maps) {
        int min = Integer.MAX_VALUE;

        int n = maps.length;
        int m = maps[n-1].length;

        Queue<int[]> queue = new LinkedList();
        maps[0][0] = 0;
        queue.offer(new int[]{0, 0, 1});

        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];

            if(x==n-1 && y==m-1) {
                min = Math.min(min, count);
                continue;
            }

            if(x<n-1) {
                if(maps[x+1][y] == 1) {
                    maps[x+1][y] = 0;
                    queue.offer(new int[]{x+1,y, count+1});
                }
            }

            if(x>0) {
                if(maps[x-1][y] == 1) {
                    maps[x-1][y] = 0;
                    queue.offer(new int[]{x-1,y, count+1});
                }
            }

            if(y<m-1) {
                if(maps[x][y+1] == 1) {
                    maps[x][y+1] = 0;
                    queue.offer(new int[]{x,y+1, count+1});
                }
            }

            if(y>0) {
                if(maps[x][y-1] == 1) {
                    maps[x][y-1] = 0;
                    queue.offer(new int[]{x, y-1, count+1});
                }
            }


        }

        if(min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

//    private void DFS(int count, int x, int y) {
//        if(x==n-1 && y==m-1) {
//            min = Math.min(min, count);
//            return;
//        }
//
//
//        ch[x][y] = 1;
//
//        if(x<n-1) {
//            if(ch[x+1][y] == 0 && map[x+1][y] == 1) {
//                DFS(count+1,  x+1, y);
//            }
//        }
//
//        if(x>0) {
//            if(ch[x-1][y] == 0 && map[x-1][y] == 1) {
//                DFS(count+1,  x-1, y);
//            }
//        }
//
//        if(y<m-1) {
//            if(ch[x][y+1] == 0 && map[x][y+1] == 1) {
//                DFS(count+1,  x, y+1);
//            }
//        }
//
//        if(y>0) {
//            if(ch[x][y-1] == 0 && map[x][y-1] == 1) {
//                DFS(count+1,  x, y-1);
//            }
//        }
//
//
//        ch[x][y] = 0;
//    }
//
//    private void check(int count, int x, int y) {
//        DFS(count, x, y);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] maps = new int[5][5];

        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                maps[i][j] = in.nextInt();
            }
        }

        Lesson_1844 q =  new Lesson_1844();
        System.out.println(q.solution(maps));
    }
}
