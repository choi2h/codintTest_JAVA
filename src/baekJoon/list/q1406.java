package baekJoon.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(reader.readLine());
        int count = Integer.parseInt(reader.readLine());

        int cur=sb.length();
        for(int i=0; i<count; i++){
            String[] input = reader.readLine().split(" ");
            switch(input[0]){
                case "L" : {
                    if(cur>0) cur--;
                    break;
                }
                case "D": {
                    if(cur<sb.length()) cur++;
                    break;
                }
                case "B" : {
                    if(cur>0) sb.deleteCharAt(--cur);
                    break;
                }
                case "P" : {
                    if(cur == sb.length()) sb.append(input[1]);
                    else sb.insert(cur, input[1]);
                    cur++;
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
