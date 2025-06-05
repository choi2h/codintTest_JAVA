import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[][] move_point = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            String[] st = br.readLine().split("");
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }


        List<Integer> apt = new ArrayList<>();
        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(arr[x][y] == 1) {
                   int size = getSize(arr, x, y);
                    apt.add(size);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(apt.size()).append("\n");
        apt.sort(Comparator.comparingInt(a -> a));
        for(int i : apt) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static int getSize(int[][] arr, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int size=0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            if(arr[cx][cy] == 0) continue;
            arr[cx][cy] = 0;
            size++;
            for(int[] move : move_point) {
                int mx = cx+move[0], my = cy+move[1];
                if(!isValidIndex(mx, arr.length) || !isValidIndex(my, arr[0].length) || arr[mx][my] == 0) continue;
                queue.offer(new int[]{mx, my});
            }
        }

        return size;
    }

    private static boolean isValidIndex(int idx, int max) {
        return idx >= 0 && idx < max;
    }
}