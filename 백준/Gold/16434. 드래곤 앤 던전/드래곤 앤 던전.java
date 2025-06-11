import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long initAttack = Integer.parseInt(input[1]);

        int[][] map = new int[n][3];
        long a = initAttack;
        long useHp = 0;
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(input2[0]);
            map[i][1] = Integer.parseInt(input2[1]);
            map[i][2] = Integer.parseInt(input2[2]);

            if(map[i][0] == 1) useHp += (long) map[i][2] / a * map[i][1];
            else {
                a += map[i][1];
                useHp += map[i][2];
            }
        }

        long min=0, max= useHp, answer = 0;
        while(min <= max) {
            long mid = (min+max)/2;

            boolean isSuccess = isSuccessToMap(map, initAttack, mid);
            if(isSuccess) {
                answer = mid;
                max = mid-1;
            } else min = mid+1;
        }

        System.out.println(answer);
    }

    private static boolean isSuccessToMap(int[][] map, long attack, long maxHp) {
        long curHp = maxHp;
        for(int[] cur : map) {
            if(cur[0] == 1) {
                long attackCount = cur[2]/attack;
                curHp -= cur[2]%attack == 0 ? (attackCount - 1) *cur[1] : attackCount *cur[1];
            } else {
                attack += cur[1];
                curHp = Math.min(maxHp, curHp + cur[2]);
            }

            if(curHp <= 0) return false;
        }

        return true;
    }
}