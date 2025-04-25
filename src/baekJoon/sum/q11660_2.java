package baekJoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11660_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int arrLength = Integer.parseInt(str[0]);
        int resultCount = Integer.parseInt(str[1]);

        int[][] sumArr = new int[arrLength][arrLength];
        for(int i = 0; i < arrLength; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < arrLength; j++){
                int num = Integer.parseInt(st.nextToken());
                if(i == 0) {
                    if(j==0) sumArr[i][j] = num;
                    else sumArr[i][j] = num + sumArr[i][j-1];
                }
                else {
                    if(j==0) sumArr[i][j] = num + sumArr[i-1][j];
                    else sumArr[i][j] = num + sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1];
                }
            }
        }

        for(int i=0;i<resultCount;i++){
            String[] arr = br.readLine().split(" ");
            System.out.println(getResult(arr, sumArr));
        }
    }

    private static int getResult(String[] arr, int[][] sumArr) {
        int startX = Integer.parseInt(arr[0])-1;
        int startY = Integer.parseInt(arr[1])-1;
        int endX = Integer.parseInt(arr[2])-1;
        int endY = Integer.parseInt(arr[3])-1;

        int result = 0;
        if(startX == 0 && startY == 0) result = sumArr[endX][endY];
        else if(startX == 0) result = sumArr[endX][endY]- sumArr[endX][startY-1];
        else if(startY == 0) result = sumArr[endX][endY]- sumArr[startX-1][endY];
        else result = sumArr[endX][endY]- sumArr[startX-1][endY]- sumArr[endX][startY-1] + sumArr[startX-1][startY-1];

        return result;
    }
}

