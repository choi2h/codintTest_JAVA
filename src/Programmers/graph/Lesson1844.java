package Programmers.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lesson1844 {

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

        Lesson1844 q =  new Lesson1844();
        System.out.println(q.solution(maps));
    }
}
