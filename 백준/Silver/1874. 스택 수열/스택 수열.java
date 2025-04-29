import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String solutionWithBufferedReaderAndArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int num = 0;
        int index = -1;
        int[] array = new int[count];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            int findNumber = Integer.parseInt(br.readLine());

            while(array[0] == 0 || array[index] < findNumber) {
                array[++index] = ++num;
                sb.append("+").append("\n");
            }

            if(array[index] > findNumber) {
                return "NO";
            }

            array[index--] = 0;
            sb.append("-").append("\n");
        }

        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        String result = solutionWithBufferedReaderAndArray();
        System.out.println(result);
    }
}
