package Programmers.Array;

/*
    문제
    https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=java#
 */
public class lesson_77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] graph = new int[rows][columns];

        int n = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                graph[i][j] = n++;
            }
        }


        for(int i=0; i<queries.length; i++) {
            int[] query = queries[i];
            int y1 = query[0]-1;
            int x1 = query[1]-1;
            int y2 = query[2]-1;
            int x2 = query[3]-1;

            int min=Integer.MAX_VALUE;

            int tmp = graph[y1][x1];
            for(int x=x1; x<x2; x++) {
                min = Math.min(min, tmp);
                int tmp2 = graph[y1][x+1];
                graph[y1][x+1] = tmp;
                tmp = tmp2;
            }

            for(int y=y1; y<y2; y++) {
                min = Math.min(min, tmp);
                int tmp2 = graph[y+1][x2];
                graph[y+1][x2] = tmp;
                tmp = tmp2;
            }

            for(int x=x2; x>x1; x--) {
                min = Math.min(min, tmp);
                int tmp2 = graph[y2][x-1];
                graph[y2][x-1] = tmp;
                tmp = tmp2;
            }

            for(int y=y2; y>y1+1; y--) {
                min = Math.min(min, tmp);
                int tmp2 = graph[y-1][x1];
                graph[y-1][x1] = tmp;
                tmp = tmp2;
            }

            graph[y1][x1] = tmp;
            answer[i] = Math.min(min, tmp);
        }
        return answer;
    }


    public static void main(String[] args) {
         int rows = 6;
         int columns = 20;
         int[][] queries = new int[][]{
                 {2,2,5,4},{3,3,6,6},{5,1,6,3}
         } ;
    //     int[][] queries = new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}} ;
    //     int[][] queries = new int[][]{{1,1,100,97}};

         lesson_77485 l = new lesson_77485();
         int[] result = l.solution(rows, columns, queries);
         for(int i=0; i<result.length; i++) {
             System.out.println(result[i] + ", ");
         }
    }
}
