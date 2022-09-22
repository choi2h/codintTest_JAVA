package inflearn.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y-o.y;
        else return this.x-o.x;
    }
}

public class Q7 {
/*

    public int[][] solution(int[][] arr) {

        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i][0] > arr[j][0]) {
                    int[] tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else if(arr[i][0] == arr[j][0]) {
                    if(arr[i][1] > arr[j][1]) {
                        int[] tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }

        return arr;
    }
*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Point> arr = new ArrayList<>();
        for( int i=0; i<n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr.add(new Point(x, y));
        }

        Collections.sort(arr); //위에서 재정의한 Comparable의 compare to 메소드를 통해 정렬을 하게 됨

        for(Point o : arr){
            System.out.print(o.x + " " + o.y);
        }
        /*
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            for(int j=0; j<2; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        Q7 q = new Q7();
        int[][] result = q.solution(arr);
        for(int[] i : result){
            System.out.println(i[0] + " " + i[1]);
        }*/
    }
}
