import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, result;
    private static List<ChickenStore> stores = new ArrayList<>();
    private static List<Home> homes = new ArrayList<>();
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) stores.add(new ChickenStore(i, j));
                else if(map[i][j] == 1) homes.add(new Home(i, j));
            }
        }

        int storeSize = stores.size();
        for (Home home: homes) {
            home.initDists(storeSize);
            for (int i=0; i<storeSize; i++) {
                ChickenStore store = stores.get(i);
                home.dists[i] = Math.abs(store.x-home.x) + Math.abs(store.y-home.y);
            }
        }

        result = Integer.MAX_VALUE;
        find(0, 0, new int[homes.size()][m]);
        System.out.println(result);
    }

    private static void find(int cnt, int idx, int[][] records) {
        if (cnt == m) {
            result = Math.min(result, getTotalDist(records));
            return;
        }

        for (int i=idx; i<stores.size(); i++) {
            for (int j=0; j<homes.size(); j++) {
                records[j][cnt] = homes.get(j).dists[i];
            }

            find(cnt+1, i+1, records);
        }
    }

    private static int getTotalDist(int[][] records) {
        int sum=0;

        for (int[] dists : records) {
            int min = Integer.MAX_VALUE;
            for (int d : dists) {
                min = Math.min(d, min);
            }

            sum += min;
        }

        return sum;
    }

    private static class ChickenStore {
        int x;
        int y;

        ChickenStore(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Home {
        int x;
        int y;
        int[] dists;

        Home(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void initDists(int n) {
            dists = new int[n];
        }
    }
}