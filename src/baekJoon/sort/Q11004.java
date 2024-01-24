package baekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// K번째 수
// 퀵정렬을 이용한 k번째 수 구하기
public class Q11004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }

        quickSort(arr, 0, n - 1, k-1);

        System.out.println(Arrays.toString(arr));
        System.out.println("k= " + arr[k-1]);
    }
    private static void quickSort(int[] arr, int start, int end, int k){
        int pivot = partition(arr, start, end);

        if(pivot == k) { // k번째 수가 pivot이면 더이상 정렬 할 필요 없음
            return;
        } else if(pivot > k) { // K가 pivot보다 작으면 pivot보다 작은 수들(왼쪽) 내에서 정렬을 수행한다.
            quickSort(arr, start, pivot-1, k);
        } else { // K가 pivot보다 크면 pivot보다 큰 수들(오른쪽) 내에서 정렬을 수행한다.
            quickSort(arr, pivot+1, end, k);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int middle = (start+end)/2;
        swap(arr, start, middle); // 중앙값을 첫번째 요소로 이동하기
        int pivot = arr[start];
        int i = start, j = end;
        while(i < j) {
            while(pivot < arr[j]) { // 피벗보다 작은 수가 나올 때 까지 j-- : 오른쪽 포인터 왼쪽으로 이동
                j--;
            }
            while (i<j && pivot >= arr[i]) { // 오른쪽 포인터가 왼쪽 포인터를 지나지 않았을 때, 피벗보다 큰 수가 나올 때 까지 왼쪽 포인터 오른쪽으로 이동
                i++;
            }

            swap(arr, i, j);
        }

        //i==j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        arr[start] = arr[i];
        arr[i] = pivot;
        return i;
    }

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}
