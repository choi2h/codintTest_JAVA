import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private int solution(int amount, int[] arr) {
        int min=0;

        for(int i=arr.length-1; i>=0; i--) {
            while(amount-arr[i]>=0) {
                amount = amount-arr[i];
                min++;
            }

            if(amount==0) {
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int count = Integer.parseInt(s[0]);
        int amount = Integer.parseInt(s[1]);
        int[] arr = new int[count];

        for(int i=0; i<count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = main.solution(amount, arr);
        System.out.println(result);
    }
}
