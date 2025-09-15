import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    private static int R, C, RCycle, CCycle;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        Shark[] sharks = new Shark[M+1];
        RCycle = 2 * (R-1);
        CCycle = 2 * (C-1);
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int r= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());

            if(d <= 2) s = s%RCycle;
            else s = s%CCycle;

            Shark shark = new Shark(r-1, c-1, s, d, z);
            arr[r-1][c-1] = i;
            sharks[i] = shark;
        }

        int answer = 0;
        for(int i=0; i<C; i++) {
            // 상어 잡기
            answer += getShark(arr, sharks, i);
            
            // 상어 이동
            resetArray(arr);
            for(int j=1; j<=M; j++) {
                if(sharks[j] == null) continue;
                moveShark(arr, sharks, j);
            }
        }

        System.out.print(answer);
    }

    private static void resetArray(int[][] arr) {
        for(int[] a : arr) {
            Arrays.fill(a, 0);
        }
    }

    private static void moveShark(int[][] arr, Shark[] sharks, int cur) {
        Shark shark = sharks[cur];
        shark.move();
        if(arr[shark.r][shark.c] == 0) arr[shark.r][shark.c] = cur;
        else removeDuplicationShark(arr, sharks, shark.r, shark.c, cur);
    }

    private static int getShark(int[][] arr, Shark[] sharks, int c) {
        for(int r=0; r<R; r++) {
            if(arr[r][c] == 0) continue;

            int index = arr[r][c];
            int size = sharks[index].z;
            sharks[index] = null;
            return size;
        }

        return 0;
    }

    private static void removeDuplicationShark(int[][] arr, Shark[] sharks, int r, int c, int cur) {
        int shark1Size = sharks[cur].z;
        int shark2Size = sharks[arr[r][c]].z;

        if(shark1Size > shark2Size) {
            sharks[arr[r][c]] = null;
            arr[r][c] = cur;
        } else sharks[cur] = null;
    }

    private static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        // 1 위 2 아래 3 오른쪽 4 왼쪽
        void move() {        
            if (d <= 2) {
              int currentPos = (d == 1) ? RCycle - r : r;
              currentPos = (currentPos + s) % RCycle;
              if (currentPos >= R) {
                  this.r = RCycle - currentPos;
                  this.d = 1;
              } else {
                  this.r = currentPos;
                  this.d = 2;
              }
          } else { 
             int currentPos = (d == 4) ? CCycle - c : c;
              currentPos = (currentPos + s) % CCycle;
              if (currentPos >= C) {
                  this.c = CCycle - currentPos;
                  this.d = 4;
              } else {
                  this.c = currentPos;
                  this.d = 3;
              }
          }
        }
    }
}