package baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
스택 수열
https://www.acmicpc.net/problem/1874
 */
public class q1874 {

    //1. Scanner + Stack
    //
    //2. BufferedReader + Stack
    //
    //1 . Scanner + array
    //
    //2. BufferedReader + array

    // 1. Scanner + Stack
    public static String solutionWithScannerAndStack() {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장

        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<count; i++) {
            int findNumber = sc.nextInt();
            while (stack.isEmpty() || stack.peek() != findNumber) {
                if(num <= count) {
                    sb.append("+").append("\n");
                    stack.push(++num);
                }

                    if(stack.peek() > findNumber) {
                    return "NO";
                }
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        return sb.toString();
    }

    // 2. BufferedReader + Stack
    public static String solutionWithBufferedReaderAndStack() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int num = 0;
        int findNumber;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            findNumber = Integer.parseInt(br.readLine());

            while(stack.isEmpty() || findNumber != stack.peek()) {
                stack.push(++num);
                sb.append("+").append("\n");

                if(stack.peek() > findNumber) {
                    return "NO";
                }
            }

            stack.pop();
            sb.append("-").append("\n");
        }


        return sb.toString();
    }

    // 1 . Scanner + array
    public static String solutionWithScannerAndArray() {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        StringBuilder sb = new StringBuilder();	// 출력할 결과물 저장

        int num = 0;
        int index = -1;
        int[] array = new int[count];
        for(int i=0; i<count; i++) {
            int findNumber = sc.nextInt();

            while(array[0] == 0 || array[index] != findNumber) {
                array[++index] = ++num;
                sb.append("+").append("\n");

                if(array[index] > findNumber) {
                    return "NO";
                }
            }

            array[index--] = 0;
            sb.append("-").append("\n");
        }


        return sb.toString();
    }

    //2. BufferedReader + array
    public static String solutionWithBufferedReaderAndArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int num = 0;
        int index = -1;
        int[] array = new int[count];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            int findNumber = Integer.parseInt(br.readLine());

            while(array[0] == 0 || array[index] < findNumber) {
                array[++index] = ++num;
                sb.append("+").append("\n");
            }

            if(array[index] > findNumber) {
                return "NO";
            }

            array[index--] = 0;
            sb.append("-").append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
//        String result = solutionWithScannerAndStack();
//        String result = solutionWithBufferedReaderAndStack();
//        String result = solutionWithScannerAndArray();
        String result = solutionWithBufferedReaderAndArray();
        System.out.println(result);



    }
}
