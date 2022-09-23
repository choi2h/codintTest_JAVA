package inflearn.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Q10 {

    public int count(int[] arr, int distance) {
        int cnt = 1; // 마구간에 들어간 말의 개수(1번재에는 무조건 말을 넣고 시작한다.)
        int endPoint = arr[0]; // 마지막 말의 위치
        for(int i=1; i<arr.length; i++) {
            if(arr[i] - endPoint >= distance) { //현재 마구간의 위치와 마지막 말의 위치가 distance보다 작아야 한다. 그러므로 크거나 같으면 말을 넣음
                cnt++; // 마구간에 말 한마리 추가
                endPoint = arr[i]; // 현재 말의 위치를 endpoint로 설정
            }
        }

        return cnt;
    }

    public int solution(int n, int c, int[] x) {
        int answer=0;

        Arrays.sort(x); // 좌표 오름차순 정렬
        int lt = Arrays.stream(x).min().getAsInt(); // 마구간의 좌표 중 가장 작은 값 추출
        int rt = Arrays.stream(x).max().getAsInt(); // 마구간의 좌표 중 가장 큰 값 추출

        while(lt<=rt) {
            int mid = (lt+rt)/2; // 가장 작은 값과 가장 큰 값의 중앙값 mid 설정(이중 분할)

            int horseCount = count(x, mid); // mid 거리만큼 간격을 둘 시 마구간에 넣을 수 있는 말의 개수 확인
            if(horseCount >= c) { // 말의 개수가 현수가 가지고 있는 말의 개수 c보다 많이 넣거나 동일하게 넣을 수 있을 시 해당 간격은 가능
                answer = mid; // 가능하다고 생각하는 값 저장
                lt = mid+1; // 최대값을 원했으니 가장 가능한 가장 큰값을 찾기 위해 이중분할 중 오른쪽으로 이동
            } else {
                rt = mid-1; // 현수의 모든 말을 넣을 수 없으므로 간격을 더 좁히기 위해 이중분할 중 왼쪽으로 이동
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        int[] x = new int[n];
        for(int i=0; i<n; i++) {
            x[i] = in.nextInt();
        }

        Q10 q = new Q10();
        int result = q.solution(n, c, x);
        System.out.println(result);
    }
}
