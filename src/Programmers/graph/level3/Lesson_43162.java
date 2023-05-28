package Programmers.graph.level3;

import java.util.Scanner;

/*
네트워크
URL : https://school.programmers.co.kr/learn/courses/30/lessons/43162

테스트 1 〉	통과 (0.03ms, 78MB)
테스트 2 〉	통과 (0.02ms, 79.9MB)
테스트 3 〉	통과 (0.03ms, 76.2MB)
테스트 4 〉	통과 (0.02ms, 78.6MB)
테스트 5 〉	통과 (0.02ms, 71.9MB)
테스트 6 〉	통과 (0.05ms, 74.3MB)
테스트 7 〉	통과 (0.02ms, 77.3MB)
테스트 8 〉	통과 (0.06ms, 75.8MB)
테스트 9 〉	통과 (0.05ms, 85.4MB)
테스트 10 〉	통과 (0.06ms, 74.1MB)
테스트 11 〉	통과 (0.25ms, 75.5MB)
테스트 12 〉	통과 (0.22ms, 78.6MB)
테스트 13 〉	통과 (0.12ms, 75MB)
 */
public class Lesson_43162 {

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

        Lesson_43162 lesson43162 = new Lesson_43162();
        System.out.println(lesson43162.solution(n, computers));

    }
}
