package Programmers.search.basic.level1;

/*
최소직사각형
URL : https://school.programmers.co.kr/learn/courses/30/lessons/86491

테스트 1 〉	통과 (7.67ms, 81.2MB)
테스트 2 〉	통과 (8.58ms, 77.1MB)
테스트 3 〉	통과 (7.05ms, 83.2MB)
테스트 4 〉	통과 (10.11ms, 76.4MB)
테스트 5 〉	통과 (7.29ms, 78MB)
테스트 6 〉	통과 (7.09ms, 88.4MB)
테스트 7 〉	통과 (7.18ms, 77.4MB)
테스트 8 〉	통과 (7.31ms, 76.6MB)
테스트 9 〉	통과 (7.19ms, 80.4MB)
테스트 10 〉	통과 (7.12ms, 76.4MB)
테스트 11 〉	통과 (7.65ms, 78.4MB)
테스트 12 〉	통과 (7.61ms, 75.9MB)
테스트 13 〉	통과 (7.35ms, 77.2MB)
테스트 14 〉	통과 (7.46ms, 76.2MB)
테스트 15 〉	통과 (7.63ms, 83.6MB)
테스트 16 〉	통과 (8.25ms, 85.9MB)
테스트 17 〉	통과 (10.52ms, 83MB)
테스트 18 〉	통과 (12.98ms, 94.6MB)
테스트 19 〉	통과 (12.13ms, 92.2MB)
테스트 20 〉	통과 (12.13ms, 89.5MB)
 */
public class Lesson_86491 {
    public int solution(int[][] sizes) {
        int max = Integer.MIN_VALUE;
        int minimum = Integer.MIN_VALUE;

        for(int i=0; i<sizes.length; i++) {
            int[] size = sizes[i];
            int width = size[0];
            int length = size[1];

            if(width < length) {
                max = getBigger(length, max);
                minimum = getBigger(width, minimum);
            } else {
                max = getBigger(width, max);
                minimum = getBigger(length, minimum);
            }
        }

        System.out.println("Max=" + max + ", Minimum=" + minimum);


        return max * minimum;
    }

    private int getBigger(int a, int b) {
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        int[][] sizes = new int[4][2];

        sizes[0][0] = 60;
        sizes[0][1] = 50;

        sizes[1][0] = 30;
        sizes[1][1] = 70;

        sizes[2][0] = 60;
        sizes[2][1] = 30;

        sizes[3][0] = 80;
        sizes[3][1] = 40;

        Lesson_86491 l = new Lesson_86491();

        int result = l.solution(sizes);
        System.out.println(result);
    }
}
