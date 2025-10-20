import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tables = new int[n];
        for(int i=0; i<n; i++) {
            tables[i] = Integer.parseInt(br.readLine());
        }

        if(n<=2) {
            if(n==1) System.out.print(tables[0]);
            else if(n==2) System.out.print(tables[0] + tables[1]);
            return;
        }
        
        int[] wine = new int[n];
        wine[0] = tables[0];
        wine[1] = tables[0] + tables[1];
        wine[2] = Math.max(Math.max(wine[1], wine[0] + tables[2]), tables[1] + tables[2]);
        for(int i=3; i<n; i++) {
            int cur = tables[i];
            wine[i] = Math.max(Math.max(wine[i-1], wine[i-2]+cur), wine[i-3]+tables[i-1]+tables[i]);
        }

        System.out.print(wine[n-1]);
    }
}