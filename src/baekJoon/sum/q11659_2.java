package baekJoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
구간 합 구하기 4
https://www.acmicpc.net/problem/11659
 */
public class q11659_2 {

    public static int[] getSumArray(int[] numbers) {
        int[] sumNumbers = new int[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            if(i==0) {
                sumNumbers[i] = numbers[i];
            } else {
                sumNumbers[i] = sumNumbers[i-1]+numbers[i];
            }
        }

        return sumNumbers;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int numberCount = Integer.parseInt(line1[0]);
        int caseCount = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] nums = new int[numberCount];
        for(int i=0; i<line2.length; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        int[] results = new int[caseCount];
        int[] sumNumbers = getSumArray(nums);
        for(int i=0; i<caseCount; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);

            results[i] = start == 1 ? sumNumbers[end-1] : sumNumbers[end-1] - sumNumbers[start-2];
        }

        for(int result : results) {
            System.out.println(result);
        }
    }
}
