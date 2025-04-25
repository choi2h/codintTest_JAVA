package baekJoon.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        int[] countArr = new int['z'-'a'+1];
        for(char c : str.toCharArray()){
            countArr[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<countArr.length-1; i++) {
            sb.append(countArr[i]).append(" ");
        }
        sb.append(countArr[countArr.length-1]);

        System.out.println(sb);
    }
}
