package Programmers.search.basic.level1;

public class Lesson_388352 {

    private int[] arr;
    private int[][] questions;
    private int[] answers;
    private int result;

    public int solution(int n, int[][] q, int[] ans) {
        arr = new int[5];
        questions = q;
        answers = ans;
        result = 0;

        dfs(n, 0, 1);

        return result;
    }

    public void dfs(int n, int depth, int cur) {
        if(depth == 5) {
            if(check(arr)) {
                result++;
            };

            return;
        }

        for(int i=cur; i<=n; i++) {
            arr[depth] = i;
            dfs(n, depth+1, i+1);
        }
    }

    private boolean check(int[] arr) {
        for(int i=0; i<questions.length; i++) {
            if(getSameCount(questions[i], arr) != answers[i]) {
                return false;
            }
        }

        return true;
    }

    private int getSameCount(int[] arr1, int[] arr2) {
        int count = 0;

        int i=0;
        int j=0;
        while (i<arr1.length && j<arr2.length) {
            if(arr1[i] == arr2[j]) {
                count++;
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }

    /*
    n	q	ans	result
    10	[[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [3, 7, 8, 9, 10], [2, 5, 7, 9, 10], [3, 4, 5, 6, 7]]	[2, 3, 4, 3, 3]	3
    15	[[2, 3, 9, 12, 13], [1, 4, 6, 7, 9], [1, 2, 8, 10, 12], [6, 7, 11, 13, 15], [1, 4, 10, 11, 14]]	[2, 1, 3, 0, 1]	5
     */
    public static void main(String[] args) {
        Lesson_388352 lesson = new Lesson_388352();

        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};
        System.out.println(lesson.solution(10, q, ans));

//        int[][] q = {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}};
//        int[] ans = {2, 1, 3, 0, 1};
//        System.out.println(lesson.solution(15, q, ans));
    }
}
