package Programmers.Array.level2;

/*
    행렬 테두리 회전하기
    https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=java#

    테스트 1 〉	통과 (0.04ms, 74.4MB)
    테스트 2 〉	통과 (0.03ms, 77.7MB)
    테스트 3 〉	통과 (18.54ms, 91.1MB)
    테스트 4 〉	통과 (10.19ms, 104MB)
    테스트 5 〉	통과 (16.08ms, 87.9MB)
    테스트 6 〉	통과 (17.29ms, 93.4MB)
    테스트 7 〉	통과 (19.84ms, 89.9MB)
    테스트 8 〉	통과 (13.07ms, 96MB)
    테스트 9 〉	통과 (14.86ms, 98.2MB)
    테스트 10 〉	통과 (8.54ms, 91MB)
    테스트 11 〉	통과 (13.54ms, 94.9MB)
 */
public class Lesson_77485 {
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

         Lesson_77485 l = new Lesson_77485();
         int[] result = l.solution(rows, columns, queries);
         for(int i=0; i<result.length; i++) {
             System.out.println(result[i] + ", ");
         }
    }
}
