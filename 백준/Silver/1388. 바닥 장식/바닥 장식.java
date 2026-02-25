import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final char W_FLOOR = '-';
    private static final char H_FLOOR = '|';
    private static final char INIT = '0';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNums = br.readLine().split(" ");
        int N = Integer.parseInt(inputNums[0]);
        int M = Integer.parseInt(inputNums[1]);

        char[][] floor = new char[N][M];
        int count = 0;
        for (int x=0; x<N; x++) {
            floor[x] = br.readLine().toCharArray();
        }


        for (int x=0; x<N; x++) {
            for (int y=0; y<M; y++) {
                if (floor[x][y] == INIT) continue;

                char cur = floor[x][y];
                if (cur == W_FLOOR) {
                    while (y < M && floor[x][y] == W_FLOOR) {
                        floor[x][y] = INIT;
                        y++;
                    }

                    y--;
                } else if (cur == H_FLOOR) {
                    int checkX = x;
                    while (checkX < N && floor[checkX][y] == H_FLOOR) {
                        floor[checkX][y] = INIT;
                        checkX++;
                    }
                }

                count++;
            }
        }

        System.out.println(count);
    }
}