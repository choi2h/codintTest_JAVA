import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = (Integer.parseInt(input[0]));
        int m = (Integer.parseInt(input[1]));

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String word = br.readLine();
            if(word.length() < m) continue;
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        list.sort((a,b) ->
            map.get(a) == map.get(b) ? 
                (a.length() == b.length() ? 
                    isBeforeBThanA(a,b)
                    : b.length() - a.length()
                ) : map.get(b) - map.get(a)
        );

        StringBuilder sb = new StringBuilder();
        for(String key : list) {
            sb.append(key).append("\n");
        }
        System.out.print(sb);
    }

    private static int isBeforeBThanA(String a, String b) {
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) == b.charAt(i)) continue;
            return  a.charAt(i) - b.charAt(i);
        }

        return 0;
    }
    
}