import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            String name = br.readLine();
            nameMap.put(name, i+1);
            indexMap.put(i+1, name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            String in = br.readLine();
            if (Character.isDigit(in.charAt(0))) sb.append(indexMap.get(Integer.parseInt(in)));
            else sb.append(nameMap.get(in));

            sb.append("\n");
        }

        System.out.print(sb);
    }
}