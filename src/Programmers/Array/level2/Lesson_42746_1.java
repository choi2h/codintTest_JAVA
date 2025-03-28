package Programmers.Array.level2;

import java.util.Arrays;

public class Lesson_42746_1 {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, (o1, o2) -> {
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            return Integer.compare(a, b) * -1;
        });

        return strArr[0].equals("0") ? "0" :  String.join("", strArr);
    }

    public static void main(String[] args) {
        Lesson_42746_1 obj = new Lesson_42746_1();
        System.out.println(obj.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
