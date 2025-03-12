package Programmers.search.basic.level1;

/*
최소직사각형
URL : https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Lesson_86491_1 {
    public int solution(int[][] sizes) {
        int width = 0, height = 0;
        for(int[] size : sizes) {
            width = Math.max(Math.max(size[0], size[1]), width);
            height = Math.max(Math.min(size[0], size[1]), height);
        }

        return width * height;
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

        Lesson_86491_1 l = new Lesson_86491_1();
        System.out.println(l.solution(sizes));
        System.out.println(l.solution(new int[][]{{10, 5}, {5, 10}, {10, 4}}));
        System.out.println(l.solution(new int[][]{{3, 5}, {6, 2}}));
    }
}
