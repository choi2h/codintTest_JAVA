package Programmers.search.basic.level1;

import java.util.Arrays;

public class Lesson_70129 {
    public int[] solution(String s) {
        int changeBinaryCount = 0;
        int removeZeroCount = 0;

        while (!s.equals("1")) {
            String removeZeroString = s.replaceAll("0", "");
            removeZeroCount += s.length()-removeZeroString.length();
            s = Integer.toBinaryString(removeZeroString.length());
            changeBinaryCount++;
        }

        return new int[]{changeBinaryCount, removeZeroCount};
    }

//    private String getBinary(int n) {
//        StringBuilder binary = new StringBuilder();
//        while(n > 1) {
//            binary.insert(0, n % 2);
//            n = n/2;
//        }
//
//        return n == 1 ? binary.insert(0, 1).toString() : binary.toString();
//    }

    /*
    "110010101001"	[3,8]
    "01110"	[3,3]
    "1111111"	[4,1]
     */
    public static void main(String[] args) {
        Lesson_70129 lesson = new Lesson_70129();
        int[] result = lesson.solution("1111111");
        System.out.println(Arrays.toString(result));
    }

}
