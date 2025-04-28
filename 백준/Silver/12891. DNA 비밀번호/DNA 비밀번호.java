import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int findLength = Integer.parseInt(input1[1]);

        char[] strArray = br.readLine().toCharArray();

        int[] findCountArray = new int[4];
        String[] countArray= br.readLine().split(" ");
        for(int i=0; i<4; i++) {
            findCountArray[i] = Integer.parseInt(countArray[i]);
        }

        int[] checkArray = new int[4];
        int start = 0, end = 0, answer = 0;
        while(end < strArray.length) {
            char c = strArray[end++];
            if(c == 'A') checkArray[0]++;
            else if(c =='C') checkArray[1]++;
            else if(c =='G') checkArray[2]++;
            else if(c =='T') checkArray[3]++;

            if(end-start < findLength) continue;

            boolean isUsablePassword = true;
            for(int i=0; i<checkArray.length; i++) {
                if (findCountArray[i] > checkArray[i]) {
                    isUsablePassword = false;
                    break;
                }
            }

            if(isUsablePassword) answer++;
            char c2 = strArray[start++];
            if(c2 == 'A') checkArray[0]--;
            else if(c2 =='C') checkArray[1]--;
            else if(c2 =='G') checkArray[2]--;
            else if(c2 =='T') checkArray[3]--;
        }

        System.out.println(answer);
    }
}