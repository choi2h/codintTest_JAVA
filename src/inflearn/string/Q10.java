package inflearn.string;

import java.util.Scanner;

/*
    문자거리
 */
public class Q10 {
    public int[] solution(String str, char point) {
//        List<Integer> answer= new ArrayList<>();
//
//        int firstIndex = str.indexOf(point);
//        int nextIndex = str.indexOf(point, firstIndex+1);
//
//        for(int i=0; i<str.length(); i++) {
//            int x = Math.abs(i-firstIndex);
//            int y = Math.abs(nextIndex-i);
//            if(x < y || x == y) {
//                answer.add(x);
//            } else {
//                answer.add(y);
//
//                firstIndex = nextIndex;
//                nextIndex = str.indexOf(point, firstIndex+1);
//            }
//        }

        int[] answer = new int[str.length()];
        int p = 1000;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == point) {
                p=0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 1000;

        for(int i=str.length()-1; i>=0; i--) {
            if(str.charAt(i) == point) {
                p=0;
            } else {
                p++;
                answer[i] = Math.min(answer[i],p);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Q10 q= new Q10();
        Scanner s = new Scanner(System.in);
        String str = s.next();
        char point = s.next().charAt(0);

        for(Integer i : q.solution(str, point)) {
            System.out.print(i + " ");
        }
    }
}
