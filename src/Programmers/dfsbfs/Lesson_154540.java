package Programmers.dfsbfs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ["X591X","X1X5X","X231X", "1XXX1"]	[1, 1, 27]
 * ["XXX","XXX","XXX"]	[-1]
 */
public class Lesson_154540 {

    private String[][] map;

    public int[] solution(String[] maps) {
        List<Integer> sums = new ArrayList<>();

        map = new String[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) {
            map[i] = maps[i].split("");
        }

        for(int y = 0; y< map.length; y++) {
            for(int x = 0; x< map[y].length; x++) {
                if(!map[y][x].equals("X")) {
                    int sum = find(y, x);
                    sums.add(sum);
                }
            }
        }

        int[] answer;
        if(!sums.isEmpty()) {
            answer = new int[sums.size()];
            for(int i=0; i<sums.size(); i++) {
                answer[i] = sums.get(i);
            }
            Arrays.sort(answer);
        } else {
            answer = new int[]{-1};
        }

        return answer;
    }

    private int find(int y, int x) {
        if(map[y][x].equals("X")) {
            return 0;
        }

        int sum = Integer.parseInt(map[y][x]);
        map[y][x] = "X";

        if (y > 0) {
            sum += find(y-1, x);
        }

        if(y < map.length-1) {
            sum += find(y+1, x);
        }

        if(x > 0) {
            sum += find(y, x-1);
        }

        if(x < map[y].length-1) {
            sum += find(y, x+1);
        }

        return sum;
    }

    public static void main(String[] args) {
        Lesson_154540 lesson = new Lesson_154540();
//        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
//        String[] maps = {"X5X1X","X1X5X","X2X1X", "1XXX1"};
//        String[] maps = {"1X1X5","X2X2X","3X3X3", "X4X4X"};
//        String[] maps = {"XXXXX","XXXXX","XXXXX", "XXXXX"};
//        String[] maps = {"XXX","XXX","XXX"};
//        String[] maps = {"111","111","111"};
//        String[] maps = {"XXX1X", "X1234", "X3XXX"};
//        String[] maps = {"X591X", "11X5X", "X231X", "1XXX1"};
//        String[] maps = {"X1X", "3XX", "456"};
        String[] maps = {"1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
                "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111X",
                "11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111X1"};
        int[] result = lesson.solution(maps);
        System.out.println(Arrays.toString(result));
    }
}
