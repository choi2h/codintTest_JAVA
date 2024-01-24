package baekJoon.sort;

import java.io.*;
import java.util.*;

/*
버블 소트
https://www.acmicpc.net/problem/1377
 */
public class Q1377 {

//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int N = Integer.parseInt(br.readLine());
//
//        Number[] numbers = new Number[N + 1]; // N+1을 하는 이유는 index는 1부터 시작하기 때문이다
//        for (int i = 1; i <= N; i++) { // index는 1부터 시작할 것이며 / N+1까지 생성했으니 N까지의 인덱스가 존재한다.
//            int temp = Integer.parseInt(br.readLine()); // 입력한 정수값을 받아
//            numbers[i] = new Number(temp, i); // 리스트에 넣어준다.
//        }
//        Arrays.sort(numbers, 1, N + 1); // 숫자를 기준으로 오름차순 정렬
//
//        int max = 0;
//        for (int i = 1; i <= N; i++) { // 해당 숫자의 인덱스가 몇 칸 움직였는지 계산
//            max = Math.max(max, numbers[i].index - i); // -> (이동한 횟수 - 1)번
//        }
//
//        bw.write((max + 1) + "\n"); // 위에서 구한 값은 (이동한 횟수 - 1)번이므로 1 더함.
//        bw.close();
//        br.close();
//    }
//}

    // 버블 정렬이 몇번의 루프를 통해 완성되는지 출력
/*    public static void solution(int n, int[] arr) {
        boolean isChanged;
        for(int i=1; i<=n+1; i++) {
            isChanged = false;
            for(int j=1; j<=n-i; j++) {
                if(arr[j] > arr[j+1]) {
                    isChanged = true;
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    System.out.println(j + "[" + arr[j] + "] changed " + j+1 + "["  + arr[j+1] + "]");
                }
            }

            if(!isChanged) {
                System.out.println(i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] list = new int[n+1];
        for(int i=1; i<=n; i++) {
            int num = Integer.parseInt(br.readLine());
            list[i] = num;
        }

        solution(n, list);
    }*/


    public static void solution(Number[] list) {
        Arrays.sort(list, 1, list.length);


        int maxMoveCount=0;
        for(int i=1; i<list.length; i++){
            maxMoveCount = Math.max(maxMoveCount, list[i].getIndex()-i);
        }

        System.out.println(maxMoveCount+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Number[] list = new Number[n+1];
        for(int i=1; i<=n; i++) {
            int num = Integer.parseInt(br.readLine());
            list[i] = new Number(num, i);
        }

        solution(list);
    }
}


class Number implements Comparable<Number>{

    int num;
    int index;

    public Number(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Number o) {
        return this.num - o.num;
    }
}