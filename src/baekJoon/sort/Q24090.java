package baekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24090 {

    /*

    quick_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
        if (p < r) then {
            q <- partition(A, p, r);  # 분할
            quick_sort(A, p, q - 1);  # 왼쪽 부분 배열 정렬
            quick_sort(A, q + 1, r);  # 오른쪽 부분 배열 정렬
        }
    }

    partition(A[], p, r) {
        x <- A[r];    # 기준원소
        i <- p - 1;   # i는 x보다 작거나 작은 원소들의 끝지점
        for j <- p to r - 1  # j는 아직 정해지지 않은 원소들의 시작 지점
            if (A[j] ≤ x) then A[++i] <-> A[j]; # i값 증가 후 A[i] <-> A[j] 교환
        if (i + 1 != r) then A[i + 1] <-> A[r]; # i + 1과 r이 서로 다르면 A[i + 1]과 A[r]을 교환
        return i + 1;
    }

     */
    // 오름차순 정렬
    public static int count = 0;
    public static int k = 0;

    public static void quickSort(int[] arr, int start, int end) {
        if(start < end) {
            int pivot = partition(arr, start, end);

            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot+1, end);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int x = arr[right];
        int i = left-1;

        for(int j=left; j<right; j++) {
            if(arr[j] < x) {
                swap (arr, ++i, j);
            }
        }

        if(i+1 != right) {
            swap (arr, i+1, right);
        }

        return i+1;
    }

    public static void swap(int[] arr, int x, int y) {
        if(++count == k) {
            if(arr[y] < arr[x]) {
                System.out.println(arr[y] + " " + arr[x]);
            } else {
                System.out.println(arr[x] + " " + arr[y]);
            }
        }

        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        k = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        quickSort(arr, 0, n-1);
        if(k > count) {
            System.out.println(-1);
        }
    }
}
