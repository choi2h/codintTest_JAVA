package Programmers.dp;

public class Lesson_1843 {

    int[][] maxArr;
    boolean[][] maxVisitArr;
    int[][] minArr;
    boolean[][] minVisitArr;

    public int solution(String arr[]) {
        maxArr = new int[arr.length][arr.length];
        maxVisitArr = new boolean[arr.length][arr.length];
        minArr = new int[arr.length][arr.length];
        minVisitArr = new boolean[arr.length][arr.length];
        return calculateMax(arr, 0, arr.length-1);
    }

    public int calculateMax(String[] arr, int start, int end) {
        if(start == end) {
            return Integer.parseInt(arr[start]);
        }

        if(maxVisitArr[start][end]) {
            return maxArr[start][end];
        }

        int maxValue = Integer.MIN_VALUE;
        for(int i=start; i<=end-2; i+=2) {
            if(arr[i+1].equals("+")) {
                maxValue = Math.max(maxValue, calculateMax(arr, start, i) + calculateMax(arr, i+2, end));
            } else {
                maxValue = Math.max(maxValue, calculateMax(arr, start, i) - calculateMin(arr, i+2, end));
            }
        }

        maxArr[start][end] = maxValue;
        maxVisitArr[start][end] = true;
        return maxValue;
    }

    public int calculateMin(String[] arr, int start, int end) {
        if(start == end) {
            return Integer.parseInt(arr[start]);
        }

        if(minVisitArr[start][end]) {
            return minArr[start][end];
        }

        int minValue = Integer.MAX_VALUE;
        for(int i=start; i<=end-2; i+=2) {
            if(arr[i+1].equals("+")) {
                minValue = Math.min(minValue, calculateMin(arr, start, i) + calculateMin(arr, i+2, end));
            } else {
                minValue = Math.min(minValue, calculateMin(arr, start, i) - calculateMax(arr, i+2, end));
            }
        }

        minArr[start][end] = minValue;
        minVisitArr[start][end] = true;
        return minValue;
    }

    /*
        arr	result
        ["1", "-", "3", "+", "5", "-", "8"]	1
        ["5", "-", "3", "+", "1", "+", "2", "-", "4"]	3
     */
    public static void main(String[] args) {
//        String[] arr = {"1", "-", "3", "+", "5", "-", "8"}; // 1
//
        String[] arr = {"5", "-", "3", "+", "1", "+", "2", "-", "4"}; // 3

        Lesson_1843 lesson = new Lesson_1843();
        int result = lesson.solution(arr);
        System.out.println(result);

    }
}
