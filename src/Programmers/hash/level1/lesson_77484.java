package Programmers.hash.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lesson_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        List<Integer> winNumList = new ArrayList<>();
        for(int i=0; i<win_nums.length; i++) {
            winNumList.add(win_nums[i]);
        }

        int correctCount = 0;
        int zeroCount = 0;

        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) zeroCount++;
            else {
                if(winNumList.contains(lottos[i])) {
                    correctCount++;
                    winNumList.remove(winNumList.indexOf(lottos[i]));
                }
            }
        }

        answer[0] = getRank(zeroCount + correctCount);
        answer[1] = getRank(correctCount);

        return answer;
    }

    private int getRank(int correctCount) {
        switch (correctCount) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default:
                return 6;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 6;
        int[] lottos = new int[count];
        int[] win_nums = new int[count];

        for(int i=0; i<lottos.length; i++) {
            lottos[i] = in.nextInt();
        }

        for(int i=0; i<lottos.length; i++) {
            win_nums[i] = in.nextInt();
        }

        lesson_77484 l = new lesson_77484();
        int[] result = l.solution(lottos, win_nums);
        for(int i = 0; i<2; i++) {
            System.out.println(result[i]);
        }
    }
}
