package Programmers.basic;
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class Lesson_12914 {

    public long solution(int n) {
        int[] records = new int[n+1];

        for(int i=0; i<=n; i++) {
            if(i<=1) records[i] = 1;
            else records[i] = (records[i-1] + records[i-2])%1234567;
        }
        return records[n];
    }

    public static void main(String[] args) {
        Lesson_12914 l = new Lesson_12914();
        System.out.println(l.solution(4));
    }
}
