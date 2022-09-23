package inflearn.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
    songCount : DVD에 들어가는 곡의 수 (최대 1,000)
        순서가 그대로 유지되어야 한다.
        한 노래를 쪼개서 넣을 수 없다.
    dvdCount : 사용될 DVD의 개수 (최대 N)
        모든 DVD는 같은 크기로 제조되어야 한다.
    DVD의 최소 크기를 알아보자.

    int[] songs : DVD에 들어갈 N개의 노래 배열

    예시 입력 1
    9 3
    1 2 3 4 5 6 7 8 9
    예시 출력 1
    17

    아이디어 : 이분 검색
    시간복잡도 : O(log2N)
 */
public class Q9 {

    public int count(int[] arr, int capacity) { //capacity는 DVD의 용량을 의미한다.
        int cnt = 1;
        int sum = 0;
        for(int x : arr) {
            if(sum+x > capacity) { //sum과 현재 x를 합한 값이 가용한 DVD의 용량보다 클 경우
                cnt++; //사용 DVD의 개수를 증가시킴
                sum = x; // sum의 값은 현재 x의 값으로 초기화 하여 다시 더하기 시작한다.
            } else {
                sum +=x; // 아직 DVD의 용량보다 적으므로 노래를 계속 추가해준다.
            }
        }

        return cnt; // 가용한 DVD의 용량을 기준으로 총 사용된 DVD의 개수 반환
    }

    public int solution(int dvdCount, int[] songs) {
        int answer=0;

        int lt = Arrays.stream(songs).max().getAsInt(); // songs 배열 중 가장 큰 수(가장 긴 노래)를 가져옴
        int rt = Arrays.stream(songs).sum(); // songs 배열의 모든 값을 더한 값
        while(lt <= rt) { //이분 검색방법으로 lt와 rt가 엇갈리기 전까지 찾는다.
            int mid = (lt+rt)/2; // lt부터 rt사이의 중앙값을 mid로 설정
            if(count(songs, mid) <= dvdCount) { // 하나의 DVD가 mid값을 넘지 않도록 개수를 센 총 DVD의 개수가 dvdCount보다 작거나 같은지 확인
                answer = mid; // 위의 조건 true 시 적용 가능한 값이므로 answer에 값 저장
                rt = mid-1; // DVD의 개수에 여분이 있다고 판단 : DVD의 크기를 더 줄여서 확인하고자 mid-1로 right값 변경 (이중 분할 중 왼쪽 작은 수의 값 사용)
            } else {
                lt=mid+1; // 위 if문의 false결과로 제한된 DVD의 개수가 초과했으므로 사용이 불가능하다. = 좀 더 넉넉한 DVD의 크기가 필요하다 판단 lt에 mid+1을 하여 이중 분할 중 오른쪽 큰수의 값 사용
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int songCount = in.nextInt();
        int dvdCount = in.nextInt();
        int[] songs = new int[songCount];
        for(int i=0; i<songCount; i++) {
            songs[i] = in.nextInt();
        }

        Q9 q = new Q9();
        int result = q.solution(dvdCount, songs);
        System.out.println(result);
    }

}
