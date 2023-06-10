package Programmers.etc.level1;

/*
바탕화면 정리
URL : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */
public class Lesson_161990 {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int size = wallpaper.length;

        int lux = size;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;
        for(int i=0; i<size; i++) {
            char[] charList = wallpaper[i].toCharArray();
            for(int j=0; j<charList.length; j++) {
                char c = charList[j];
                if(c == '#') {
                    if(lux > i) {
                        lux = i;
                    }

                    if(luy > j) {
                        luy = j;
                    }

                    if (rdx < i) {
                        rdx = i;
                    }

                    if(rdy < j) {
                        rdy = j;
                    }
                }
            }
        }

        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx+1;
        answer[3] = rdy+1;

        return answer;
    }

    /*
    .
    #
     */
    public static void main(String[] args) {
        Lesson_161990 lesson = new Lesson_161990();
//        String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#",
//                ".#.....#.", "..#...#..", "...#.#...", "....#...."};

        String[] wallpaper = {"...#"};
//        String[] wallpaper = {"#"};
        int[] result = lesson.solution(wallpaper);
        System.out.println(result[0] + ", " + result[1] + ", " + result[2] + ", " + result[3]);
    }
}
