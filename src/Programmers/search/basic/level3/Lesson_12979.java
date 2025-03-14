package Programmers.search.basic.level3;

// 기지국 설치
// https://school.programmers.co.kr/learn/courses/30/lessons/12979
public class Lesson_12979 {
    // 아파트 개수 n
    // 기지국 설치 아파트 번호 stations
    // 전파 도달 거리 w - 설치국 기준으로 양쪽으로 w만큼 전달
//    public int solution(int n, int[] stations, int w) {
//        int answer = 0;
//        int s = 1;
//        int bound = w*2+1;
//
//        for (int station : stations) {
//            int be = station - w;
//            if (s >= be) {
//                s = station + w + 1;
//                continue;
//            }
//
//            int gap = be - s;
//            answer += gap > 0 ? (gap%bound>0 ? gap/bound+1 : gap/bound) : 1;
//
//            s = station + w + 1;
//        }
//
//        if(s <= n) {
//            int gap = n-s;
//            answer += gap > 0 ? (gap%bound>0 ? gap/bound+1 : gap/bound) : 1;
//        }
//
//        return answer;
//    }

    // 재풀이
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;
        int stationsIndex = 0;

        while (index <= n) {
            if(stationsIndex < stations.length && index >= stations[stationsIndex]-w) {
                index = stations[stationsIndex]+w+1;
                stationsIndex++;
            } else {
                index += w*2+1;
                answer++;
            }
        }

        return answer;
    }

    // 대박이네,,
//    public int solution(int n, int[] stations, int w) {
//        int answer = 0;
//        int index = 0;
//        int stationPointer = 0;
//
//        while(index < n) {
//            if(stationPointer < stations.length && index >= (stations[stationPointer]-1)-w) {
//                index = (stations[stationPointer]-1) + w + 1;
//                stationPointer++;
//            }else {
//                index = index + w*2+1;
//                answer++;
//            }
//        }
//
//
//        return answer;
//    }

    public static void main(String[] args) {
        Lesson_12979 lesson = new Lesson_12979();
//        int result = lesson.solution(11, new int[]{4, 11},1);
        int result = lesson.solution(11, new int[]{7, 11},1);
//        int result = lesson.solution(16, new int[]{9},2);
        System.out.println(result);

    }
}
