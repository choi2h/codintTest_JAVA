package baekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
수 정렬하기
https://www.acmicpc.net/problem/2750
 */
public class Q2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] array = new int[count];
        for(int i=0; i<count; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<count; i++) {
            for(int j=0; j<count-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<array.length-1; i++) {
            sb.append(array[i]).append("\n");
        }

        sb.append(array[count-1]);
        System.out.println(sb);
    }
}
