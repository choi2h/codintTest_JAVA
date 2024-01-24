package baekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 버블 소트
// https://www.acmicpc.net/problem/1517
public class Q1517 {

    public static int[] arr;
    public static int[] tmp;

    public static long count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        tmp = new int[n];
        String[] nums = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(nums[i]);
            arr[i] = num;
            tmp[i] = num;
        }

        mergeSort(0, n-1);

        for(int i=0; i<arr.length; i++) {
            arr[i] = tmp[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(count);

    }

    /*
        병합정렬 실행
     */
    public static void mergeSort(int start, int end) {
        if(end-start < 1) {
            return;
        }

        // 분할하여 정렬하는 과정
        int middle = start + (end-start)/2; // 중앙값 구하기
        mergeSort(start, middle); // 중앙값을 기준으로 왼쪽 정렬
        mergeSort(middle+1, end); // 중앙값을 기준으로 오른쪽 정렬


        // 분할 후 정렬된 데이터를 기존 arr에 복사
        for(int i=start; i<=end; i++) {
            arr[i] = tmp[i];
        }

        // 분할 정렬한 두개의 그룹을 하나로 병합하는 과정
        int index = start;
        // 두 그룹의 가장 처음 인덱스를 기준으로 비교하여 tmp 배열에 정렬
        int p1=start, p2=middle+1;
        while(p1 <= middle && p2 <= end) {
            if(arr[p1] <= arr[p2]) {
                tmp[index++] = arr[p1++];
            } else {
                // 뒤에서 앞으로 온 만큼 swap이 발생 -> 4칸 앞으로 오면 4만큼 발생한 것
                count += p2 - index;
                tmp[index++] = arr[p2++];
            }
        }

        // 하나의 그룹이 끝나고 나머지 하나의 그룹에 남은 수 정렬
        while(p1 <= middle) {
            tmp[index++] = arr[p1++];
        }

        while (p2 <= end) {
            tmp[index++] = arr[p2++];
        }
    }
}
