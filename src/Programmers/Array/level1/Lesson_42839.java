package Programmers.Array.level1;


import java.util.HashSet;
import java.util.Set;

public class Lesson_42839 {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        String[] arr = numbers.split("");
        boolean[] visited = new boolean[arr.length];
        find(arr, "", visited);
        return (int) set.stream().filter(i -> {
            for(int j = 2; j < i/2; j++) {
                if(i%j == 0) return false;
            }

            return true;
        }).count();
    }

    private void find(String[] arr, String num, boolean[] visited) {
        if(!num.isEmpty() && Integer.parseInt(num) > 1) set.add(Integer.parseInt(num));
        if(num.length() >= arr.length)  {
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            find(arr, num + arr[i], visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Lesson_42839 obj = new Lesson_42839();
//        System.out.println(obj.solution("17"));
        System.out.println(obj.solution("011"));
    }

}
