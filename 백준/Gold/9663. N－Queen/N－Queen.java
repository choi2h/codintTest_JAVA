import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    private static int answer = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] record = new int[n][2];
        for(int i=0; i<n; i++) {
            record[i][0] = -1;
            record[i][1] = -1;
        }

        bfs(n, arr, record, 0);
        
        System.out.print(answer);
    }

    private static void bfs(int n, int[][] arr, int[][] record, int i) {
        if(i >= n) {
            answer++;
            return;
        }

        for(int j=0; j<n; j++) {
            if(checkAvailable(n, record, i, j)) {
                record[i][0] = i;
                record[i][1] = j;
                bfs(n, arr, record, i+1);
            }
        }

    }

    private static boolean checkAvailable(int n, int[][] record, int i, int j) {
        for(int q=0; q<i; q++) {
            if(record[q][0] == i || record[q][1] == j) return false;
        }

        int k = 1;
        while(i+k < n || j+k < n || i-k >=0 || j-k >=0) {
            if(i+k < n && j+k < n && isExistQueen(record, i, i+k, j+k)) return false;
            if(i+k <n && j-k >= 0 && isExistQueen(record, i, i+k, j-k)) return false;
            if(i-k >= 0 && j+k < n && isExistQueen(record, i, i-k, j+k)) return false;
            if(i-k >= 0 && j-k >= 0 && isExistQueen(record, i, i-k, j-k)) return false;
            k++;
        }

        return true;
    }

    private static boolean isExistQueen(int[][] record, int now, int i, int j) {
        for(int k=0; k<now; k++) {
            if(record[k][0] == i && record[k][1]==j) {
                return true;
            }
        }

        return false;
    }
}