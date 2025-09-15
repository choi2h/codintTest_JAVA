import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] move = {{0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}};
    private static int[] width; 
    private static int[] height; 
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        width = new int[C==1 ? 1 : C*2-2];
        height = new int[R==1 ? 1 : R*2-2];

        for (int i=0; i<width.length; i++) {
            width[i] = i>=C ? C-(i-C)-2 : i;
        }

        for(int i=0; i<height.length; i++) {
            height[i] = i>=R ? R-(i-R)-2 : i;
        }

        int[][] arr = new int[R][C];
        Shark[] sharks = new Shark[M+1];
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int r= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());

            s = d == 1 || d ==2 ? s%((R-1)*2) : s%((C-1)*2);
            Shark shark = new Shark(r-1, c-1, s, d, z);
            arr[r-1][c-1] = i;
            sharks[i] = shark;
        }

        int answer = 0;
        for(int i=0; i<C; i++) {
            // 상어 잡기
            answer += getShark(arr, sharks, i);
            
            int[][] newArr = new int[R][C];
            
            // 상어 이동
            for(int j=1; j<=M; j++) {
                if(sharks[j] == null) continue;
                moveShark(arr, newArr, sharks, j);
            }

            arr = newArr;
        }

        System.out.print(answer);
    }

    private static void moveShark(int[][] arr, int[][] newArr, Shark[] sharks, int cur) {
        Shark shark = sharks[cur];
        shark.move();
        if(newArr[shark.r][shark.c] > 0) removeDuplicationShark(newArr, sharks, shark.r, shark.c, cur);
        else newArr[shark.r][shark.c] = cur;
    }

    private static int getShark(int[][] arr, Shark[] sharks, int king) {
        for(int k=0; k<R; k++) {
            if(arr[k][king] > 0) {
                int index = arr[k][king];
                int size = sharks[index].z;
                sharks[index] = null;
                arr[k][king] = 0;
                return size;
            }
        }

        return 0;
    }

    private static void removeDuplicationShark(int[][] arr, Shark[] sharks, int r, int c, int cur) {
        Shark shark = sharks[cur];
        int sharkIndex = arr[r][c];
        Shark shark2 = sharks[sharkIndex];

        if(shark.z > shark2.z) {
            arr[shark.r][shark.c] = cur;
            sharks[sharkIndex] = null;
        } else if(shark.z < shark2.z) {
            sharks[cur] = null;
        }
    }

    private static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        // 1 위 2 아래 3 오른쪽 4 왼쪽
        void move() {        
            int[] moveBase = move[d];
            int rIndex = r+(s*moveBase[0]);
            int cIndex = c+(s*moveBase[1]);

            rIndex = rIndex == 0 ? rIndex : rIndex%height.length;
            cIndex = cIndex == 0 ? cIndex : cIndex%width.length;

            rIndex = rIndex >= 0 ? rIndex : height.length+rIndex;
            cIndex = cIndex >= 0 ? cIndex : width.length+cIndex;

            r = height[rIndex];
            c = width[cIndex];

            if(d==1) d = rIndex<R ? 1: 2;
            else if(d==2) d =  rIndex < R ? 2 : 1;
            else if(d==3) d =  cIndex < C ? 3 : 4;
            else if(d==4) d =  cIndex < C ? 4 : 3;
        }
    }
}