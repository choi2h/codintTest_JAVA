package Programmers;

public class lesson_86491 {
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

        lesson_86491 l = new lesson_86491();

        int result = l.solution(sizes);
        System.out.println(result);
    }
}
