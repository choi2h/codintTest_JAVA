package inflearn.array;

import java.util.Scanner;
/*
    봉우리
    설명
    지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
    각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
    격자의 가장자리는 0으로 초기화 되었다고 가정한다.
    만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

    입력
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)
    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
    출력
    봉우리의 개수를 출력하세요.

    예시 입력 1
    5
    5 3 7 2 3
    3 7 1 6 1
    7 2 5 3 4
    4 3 6 4 1
    8 7 3 5 2
    예시 출력 1
    10
 */
public class Q10 {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};

    public int solution(int n, int[][] table) {
        int result=0;

//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=n; j++) {
//                int number = table[i][j];
//                if((number > table[i][j-1]) && (number > table[i][j+1])) {
//                    if(number > table[i-1][j] && (number > table[i+1][j])) {
//                        result++;
//                    }
//                }
//            }
//        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                boolean flag = true;
                for(int k=0; k<4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && table[nx][ny] >= table[i][j] ) {
                        flag = false;
                        break;
                    }
                }

                if(flag) result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        int[][] table = new int[n+2][n+2];
//        for(int i=1; i<=n; i++) {
//            for(int j=1; j<=n; j++) {
//                table[i][j] = in.nextInt();
//            }
//        }
        int[][] table = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                table[i][j] = in.nextInt();
            }
        }

        Q10 q = new Q10();
        int result = q.solution(n, table);
        System.out.println(result);
    }
}
