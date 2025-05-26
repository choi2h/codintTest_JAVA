import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i<count; i++) {
            System.out.println(getResult(br.readLine()));
        }
    }

    private static int getResult(String str) {
        char[] charArray = str.toCharArray();
        int removeCount = dfs(charArray, 0, str.length()-1, 0);

        return removeCount > 1 ? 2: removeCount;
    }

    private static int dfs(char[] charArray, int l, int r, int removeCount) {
        if(l >= r || removeCount>=2) return removeCount;

        if(charArray[l] == charArray[r]) return dfs(charArray, l+1, r-1, removeCount);
        else return Math.min(dfs(charArray, l+1, r, removeCount+1), dfs(charArray, l, r-1, removeCount+1)) ;
    }
}