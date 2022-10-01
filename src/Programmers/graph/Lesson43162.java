package Programmers.graph;

import java.util.Scanner;

public class Lesson43162 {

    int[][] coms;
    int ch[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        coms = computers;
        ch = new int[n];

        for(int i=0; i<n; i++) {
            if(ch[i]==0) {
                DFS(i);
                answer++;
            }
        }

        return answer;
    }

    private void DFS(int c) {
        int[] computer = coms[c];

        for(int i=0; i<computer.length; i++) {
            if(computer[i] == 1 && ch[i]==0) {
                ch[i]=1;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] computers = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                computers[i][j] = in.nextInt();
            }
        }

        Lesson43162 lesson43162 = new Lesson43162();
        System.out.println(lesson43162.solution(n, computers));

    }
}
