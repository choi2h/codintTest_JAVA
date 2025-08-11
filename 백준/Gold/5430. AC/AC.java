import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (testCount-- > 0) {
            String functionStr = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String numStr = br.readLine();
            String answer = getAnswer(functionStr, n, numStr);

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static String getAnswer(String functions, int n, String numsStr) {
        while (functions.contains("RR")) {
            functions = functions.replaceAll("RR", "");
        }

        String onlyD = functions.replaceAll("R", "");
        if(onlyD.length() > n) return "error";

        numsStr = numsStr.replace("[", "");
        numsStr = numsStr.replace("]", "");
        String[] nums = numsStr.split(",");
        return getResultString(functions, nums);
    }

    private static String getResultString(String functions, String[] nums) {
        Deque<String> q = new ArrayDeque<>(Arrays.asList(nums));
        boolean isReverse = false;
        for(String s : functions.split("")) {
            if(s.equals("R")) isReverse = !isReverse;
            else if(s.equals("D")) {
                if(isReverse) q.removeLast();
                else q.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!q.isEmpty()) {
            if(isReverse) sb.append(q.removeLast());
            else sb.append(q.removeFirst());

            if(!q.isEmpty()) sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }
}