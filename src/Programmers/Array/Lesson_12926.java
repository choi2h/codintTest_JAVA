package Programmers.Array;

public class Lesson_12926 {

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)) sb.append(c);
            else sb.append(getAlphabet(c, n));
        }
        return sb.toString();
    }

    private char getAlphabet(char c, int n) {
        if(Character.isLowerCase(c) && c+n > 'z') return (char) (c + n - ('z' - 'a' + 1));
        if(Character.isUpperCase(c) && c+n > 'Z') return (char) (c + n - ('Z' - 'A' + 1));

        return (char)(c+n);
    }

    public static void main(String[] args) {
        Lesson_12926 lesson = new Lesson_12926();
        System.out.println(lesson.solution("a B z", 4));

        System.out.println(Character.isLowerCase('a'));
    }
}
