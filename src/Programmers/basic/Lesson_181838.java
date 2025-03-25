package Programmers.basic;

import java.time.LocalDate;

public class Lesson_181838 {
    public int solution(int[] date1, int[] date2) {
        return LocalDate.of(date1[0], date1[1], date1[2]).isBefore(LocalDate.of(date2[0], date2[1], date2[2])) ? 1 : 0;
    }
}
