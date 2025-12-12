import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class Main {

    private static Map<Integer, Integer> countingMap = new HashMap<>();
    private static Comparator<Integer> comparator = (o1, o2) -> {
        int v1 = countingMap.get(o1), v2 = countingMap.get(o2);
        return v1 == v2 ? o1-o2 : v1 - v2;
    };

    static int nextInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    // R연산 : 배열 A의 모든 행에 대해서 정렬 수행,  행 > 열 적용
    // C연산 : 배열 A의 모든 열에 대해서 정렬 수행,  열 > 행 적용
    public static void main(String[] args) throws IOException {
        int r = nextInt()-1, c = nextInt()-1;
        int k = nextInt();

        int[][] nums = new int[100][100];
        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++) {
                nums[x][y] = nextInt();
            }
        }

        int x_size = 3, y_size = 3, time = 0;
        while (nums[r][c] != k && time <= 100) {
            if (y_size > x_size) x_size = c_calculate(nums, x_size, y_size);
            else  y_size = r_calculate(nums, x_size, y_size);

            time++;
        }

        System.out.println(time<=100 ? time : -1);
    }

    public static int r_calculate(int[][] nums, int x_size, int y_size) {
        int x=0, y=0;
        int max_size = 0;
        while (x < x_size) {
            while (y < y_size) {
                if (nums[x][y] > 0) {
                    countingMap.put(nums[x][y], countingMap.getOrDefault(nums[x][y], 0) + 1);
                    nums[x][y] = 0;
                }
                y++;
            }

            List<Integer> keys = new ArrayList<>(countingMap.keySet());
            keys.sort(comparator);
            int iy=0;
            for (int key: keys) {
                if (iy >= 100) break;
                nums[x][iy++] = key;
                nums[x][iy++] = countingMap.get(key);

                countingMap.remove(key);
            }
            max_size = Math.max(max_size, iy);
            x++;
            y=0;
        }

        return max_size;
    }

    public static int c_calculate(int[][] nums, int x_size, int y_size) {
        int x=0, y=0;
        int max_size = 0;
        while (y < y_size) {
            while (x < x_size) {
                if (nums[x][y] > 0) {
                    countingMap.put(nums[x][y], countingMap.getOrDefault(nums[x][y], 0) + 1);
                    nums[x][y] = 0;
                }
                x++;
            }

            List<Integer> keys = new ArrayList<>(countingMap.keySet());
            keys.sort(comparator);
            int ix=0;
            for (int key: keys) {
                if (ix >= 100) break;
                nums[ix++][y] = key;
                nums[ix++][y] = countingMap.get(key);

                countingMap.remove(key);
            }
            max_size = Math.max(max_size, ix);
            y++;
            x=0;
        }

        return max_size;
    }

}