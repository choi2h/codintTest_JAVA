package baekJoon.sort;

import java.io.*;

// 수 정렬하기 2
//https://www.acmicpc.net/problem/2751
public class Q2751 {

    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        A = new int[n+1];
        tmp = new int[n+1];
        for(int i=1; i<=n;i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=n; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void mergeSort(int s, int e) { //병합정렬 수행
        if(e-s < 1) {
            return;
        }

        int m = s + (e-s)/2; // 중앙값 구하기
        /* 중앙값을 기준으로 왼쪽 오른쪽 분할 후 정렬 수행 */
        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i=s; i<=e; i++) {
            tmp[i] = A[i];
        }

        /* 위에서 분할 정렬한 두 배열을 병합 정렬*/
        int k = s;
        int index1 = s;
        int index2 = m+1;
        while(index1 <= m && index2 <=e) {
            if(tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }


        /* 한쪽 그룹이 모두 선택되었을 때 나머지 그룹의 값 정리하기 */
        while(index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }

        while(index2 <= e) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
