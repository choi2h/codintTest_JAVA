package Programmers.dfsbfs;

public class Lesson_43165 {
    int count = 0;

    public int solution(int[] numbers, int target) {
        calculate(numbers, 0, 0, target);

        return count;
    }

    private void calculate(int[] numbers, int sum, int index, int target) {
        if(index == numbers.length) {
            if(sum == target) {
                count++;
            }
            return;
        }


        calculate(numbers, sum+numbers[index], index+1, target);
        calculate(numbers, sum-numbers[index], index+1, target);
    }

    /*
    {1, 1, 1, 1, 1}	3	5
    {4, 1, 2, 1}	4	2
     */
    public static void main(String[] args) {
        Lesson_43165 lesson = new Lesson_43165();
//        int[] numbers = {1, 1, 1, 1, 1};
//        int target = 3;

        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        int result = lesson.solution(numbers, target);
        System.out.println("result = " + result);
    }


}

