package baekJoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] xList = new int[1000*100000];
        int[] yList = new int[1000*100000];
        int index = 0;
        for (int i = 0; i<n; i++) {
            String[] value = br.readLine().split(" ");
            int x = Integer.parseInt(value[0]);
            int y = Integer.parseInt(value[1]);
            int p = Integer.parseInt(value[2]);

            for(int j=0; j<p; j++) {
                xList[index] = x;
                yList[index++] = y;
            }
        }

        Arrays.sort(xList, 0, index);
        Arrays.sort(yList, 0, index);

        // 어딘가 한 집은 이동을 안하는게 이득임
        // 기존 마을이 있는 곳 중 하나에 좌표를 고정하면 됨
        int mid = (index-1)%2 != 0 ? (index+1)/2 : index/2;

        System.out.println(xList[mid] + " " + yList[mid]);
    }
}


/*
 int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            int x = xList[i];
            for(int j=0; j<n; j++) {
                int y = yList[j];
                int sumMoveCount = 0;
                for(int k=0; k<n; k++) {
                    Village village = villages.get(k);

                    int moveCount = village.x > x ? village.x-x : x-village.x;
                    moveCount += village.y > y ? village.y-y : y-village.y;
                    moveCount = moveCount*village.p;

                    sumMoveCount += moveCount;
                }

                if(sum > sumMoveCount) {
                    minX = x;
                    minY = y;
                    sum = sumMoveCount;
                } else if(sum == sumMoveCount) {
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                }
            }
        }
 */