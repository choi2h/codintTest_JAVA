package Programmers.search.basic.level2;


public class Lesson_388353 {

    private static final String BLANK = "0";

    // 세로로 n줄 / 가로로 m줄 nXm
    // 출고 요청이 들어오면 접근 가능한 컨테이너 모두 꺼냄 => 접근 가능 컨테이너 : 4면 중 1면 이상이 외부와 연결된 컨테이너
    // 알파벳 하나로 요청 시 접근 가능한 컨테이너 모두 꺼냄
    // 알파벳 두번 반복 요청 시 요청된 모든 종류의 컨테이너 꺼냄
    public int solution(String[] storage, String[] requests) {
        String[][] arr = new String[storage.length][storage[0].length()];
        for (int i = 0; i < storage.length; i++) {
            arr[i] = storage[i].split("");
        }

        int answer = arr.length * arr[0].length;
        for (int i = 0; i < requests.length; i++) {
            if (requests[i].length() == 1) {
                answer -= findForkLift(arr, requests[i]);
            } else {
                answer -= findCrane(arr, requests[i].substring(1));
            }
        }

        return answer;
    }

    private int findForkLift(String[][] arr, String s) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        return find(arr, s, 0, 0, visited);
    }

    private int find(String[][] arr, String s, int x, int y, boolean[][]visited) {
        if(x >= arr.length || y >= arr[0].length || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int count = 0;

        if(x==0 || x == arr.length-1) {
            count += find(arr, s, x, y+1, visited);
        }

        if(arr[x][y].equals(s)) {
            arr[x][y] = BLANK;
            count += 1;
        } else if(arr[x][y].equals(BLANK)) {
            if(x > 0) {
                count += find(arr, s, x-1, y, visited);
            }

            if(x < arr.length-1) {
                count += find(arr, s, x+1, y, visited);
            }

            if(y > 0) {
                count += find(arr, s, x, y-1, visited);
            }

            if(y < arr.length-1) {
                count += find(arr, s, x, y+1, visited);
            }
        } else if(x != 0 && x < arr.length-1){
            count += find(arr, s, x, arr[x].length-1, visited);
        }

        if(y==0 || y == arr[x].length-1){
            count += find(arr, s, x+1, y, visited);
        }

        return count;
    }

    private int findCrane(String[][] arr, String s) {
        int count = 0;

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[j][i].equals(s)) {
                    arr[j][i] = BLANK;
                    count++;
                }
            }
        }

        return count;
    }

    //["AZWQY", "CAABX", "BBDDA", "ACACA"]	["A", "BB", "A"]	11
    //["HAH", "HBH", "HHH", "HAH", "HBH"]	["C", "B", "B", "B", "B", "H"]
    public static void main(String[] args) {
        Lesson_388353 lesson = new Lesson_388353();
//        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
//        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
//        String[] storage = {"AAAA", "AAAA", "AAAA", "AAAA"};
//        String[] storage = {"AAAA", "AAAA", "AAAA", "AAAA"};
        String[] storage = {"HAH", "HBH", "HHH", "HAH", "HBH"};
//        String[] requests = {"A", "BB", "A"};
//        String[] requests = {"A", "C", "Z", "B"};
//        String[] requests = {"A"};
        String[] requests = {"C", "B", "B", "B", "B", "H"};

        System.out.println(lesson.solution(storage, requests));
    }
}
