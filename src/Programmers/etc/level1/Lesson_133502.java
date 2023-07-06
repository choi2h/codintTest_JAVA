package Programmers.etc.level1;

import java.util.Stack;

/*
햄버거 만들기
URL : https://school.programmers.co.kr/learn/courses/30/lessons/133502
 */
public class Lesson_133502 {

    /*
    1: 빵
    2: 야채
    3: 고기

    햄버거 (빵 - 야채 - 고기 - 빵)
     */
    public int solution(int[] ingredient) {
        int answer = 0;

        int index = 0;
        int[] stack = new int[ingredient.length];
        for(int i : ingredient) {
            stack[index] = i;

            if(index >=3) {
                if(stack[index] == 1 && stack[index-1] == 3 && stack[index-2] == 2 && stack[index-3] == 1) {
                    index = index-4;
                    answer++;
                }
            }

            index++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Lesson_133502 lesson = new Lesson_133502();
//        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1, 2, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1}; //4
//        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
//        int[] ingredient = {1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1}; // 2
        int result = lesson.solution(ingredient);
        System.out.println(result);
    }

    /*
        Stack<Integer> s = new Stack<>();

        for(int i : ingredient) {
            s.push(i);

            int size = s.size();
            if(size >= 4) {
                if(s.get(size-1) == 1 && s.get(size-2) == 3 && s.get(size-3) == 2 && s.get(size-4) == 1) {
                    s.pop();
                    s.pop();
                    s.pop();
                    s.pop();

                    answer++;
                }
            }
        }
     */
}
