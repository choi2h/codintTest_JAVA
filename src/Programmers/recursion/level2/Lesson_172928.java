package Programmers.recursion.level2;
/*
공원산책
URL : https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
public class Lesson_172928 {

    public int[] solution(String[] park, String[] routes) {
        int[] point = new int[2];

        int parkSize = park.length;
        char[][] parkCoordinate = new char[parkSize][parkSize];
        for(int i=0; i<parkSize; i++) {
            String p = park[i];
            char[] charArray = p.toCharArray();
            for(int j=0; j<charArray.length; j++) {
                char c = charArray[j];
                if(c == 'S') {
                    point[0] = i;
                    point[1] = j;
                }
                parkCoordinate[i][j] = c;
            }
        }

        int y = point[0];
        int x = point[1];
        for(String route : routes) {
            char direction = route.charAt(0);
            int count = Integer.parseInt(String.valueOf(route.charAt(2)));

            boolean isMove = isMove(point, parkCoordinate, y, x, direction, count);

            if(isMove) {
                y = point[0];
                x = point[1];
            }
        }

        point[0] = y;
        point[1] = x;
        return point;
    }

    private boolean isMove(int[] point, char[][] parkCoordinate, int y, int x, char direction, int count) {
        boolean isMove = true;
        for(int i = 0; i< count; i++) {
            movePoint(point, direction);
            if(!checkCanMovePoint(point, parkCoordinate)) {
                isMove = false;
                point[0] = y;
                point[1] = x;
                break;
            }
        }
        return isMove;
    }

    private void movePoint(int[] point, char direction) {
        switch (direction) {
            case 'N':
                point[0]--;
                break;
            case 'S':
                point[0]++;
                break;
            case 'W':
                point[1]--;
                break;
            case 'E':
                point[1]++;
                break;
            default:
        }
    }

    private boolean checkCanMovePoint(int[] point, char[][] park) {
        int y = point[0];
        int x = point[1];

        if(x < 0 && x >= park.length && y < 0 && y >= park.length) {
            return false;
        }

        char p = park[y][x];
        return isMove(p);
    }

    private boolean isMove(char p) {
        return p == 'O' || p == 'S';
    }

    public static void main(String[] args) {
        Lesson_172928 lesson = new Lesson_172928();
//        String[] park = {"SOO","OOO","OOO"};
//        String[] routes = {"E 2","S 2","W 1"};

//        String[] park = {"SOO","OXX","OOO"};
//        String[] routes = {"E 2","S 2","W 1"};

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        int[] result = lesson.solution(park, routes);
        System.out.println("Result : [" + result[0] + "," + result[1] + "]");
    }

}
