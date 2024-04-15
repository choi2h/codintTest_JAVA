package Programmers.kakao;


public class Lesson_150369 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 배달 박스 개수를 저장할 변수
        int deliverCount = 0;
        // 픽업 박스 개수를 저장할 변수
        int pickupCount = 0;
        // 가장 먼 집(가장 마지막 인덱스)부터 가장 가까운 집(가장 처음 인덱스)까지 순회
        for(int i=n-1; i>=0; i--) {
            // 해당 집에 배달 박스 개수 추가
            deliverCount += deliveries[i];
            // 해당 집에 픽업 박스 개수 추가
            pickupCount += pickups[i];

            // 배달 and 픽업 박스가 다 떨어질 때 까지 순회
            while (deliverCount>0 || pickupCount>0) {
                // 한번에 배달 할 수 있는 개수(cap)만큼 빼서 한번의 배달 완료
                deliverCount -= cap;
                // 한번에 수거 할 수 있는 개수(cap)만큼 빼서 한번의 수거 완료
                pickupCount -= cap;

                // 현재 인덱스가 가장 먼 집의 위치임으로 현재 집의 왕복 거리를 정답에 더해줌
                answer += (i+1)*2L;
            }
        }

        return answer;
    }

   /* public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 배달 박스 배열을 순회할 인덱스
        int dIndex = n-1;
        // 수거 박스 배열을 순회할 인덱스
        int pIndex = n-1;
        // 모든 배달이 끝날 때 까지 순회
        while (dIndex>=0 || pIndex>=0) {
            // --> 최대 박스 개수 cap을 넘지 않아야 함
            int currentBoxCount = cap;
            long move = 0;


            // 일단 배달부터 달림
            while (currentBoxCount>0 && dIndex>=0) {
                int deliveryBoxCount = deliveries[dIndex];
                // 배달이 0인 집은 인덱스 생략
                if(deliveryBoxCount == 0) {
                    dIndex--;
                     continue;
                }

                move = Math.max(move, dIndex+1);
                if(currentBoxCount < deliveryBoxCount) {
                    deliveries[dIndex] = deliveryBoxCount-currentBoxCount;
                    currentBoxCount=0;
                } else {
                    deliveries[dIndex--] = 0;
                    currentBoxCount -= deliveryBoxCount;
                }
            }

            currentBoxCount = 0;


            while(currentBoxCount<cap && pIndex>=0) {
                int pickupBoxCount = pickups[pIndex];
                // 수거가 0인 집은 인덱스 생략
                if(pickupBoxCount == 0) {
                    pIndex--;
                    continue;
                }

                move = Math.max(move, pIndex+1);

                // --> 최대 박스 개수 cap을 넘지 않아야 함
                if(currentBoxCount+pickupBoxCount > cap) {
                    pickups[pIndex] = pickups[pIndex]-(cap-currentBoxCount);
                    currentBoxCount = cap;
                } else {
                    pickups[pIndex--] = 0;
                    currentBoxCount += pickupBoxCount;
                }
            }


            // 배달과 수거 중 더 먼 집(인덱스 수가 더 큰쪽)을 향해 들림
            // 만약 수거하는 곳이 더 멀리 있다면 가는길에 배달을 두고 감
            // 만약 배달앟는 곳이 더 멀리 있다면 배달 후 돌아오는 길에 수거


            answer += move;
        }


        return answer * 2;
    }*/

    public static void main(String[] args) {
        Lesson_150369 lesson = new Lesson_150369();
        //4, 4, [25, 24, 51, 0], [51, 0, 0, 49]
        // 트럭에 실을 수 있는 최대 물류 개수
//        int cap = 2;
//        int cap = 1;
//        int cap = 2;
//        int cap = 3;
//        int cap = 2;
        int cap = 4;
        // 집 수
//        int n = 7;
//        int n = 5;
//        int n = 2;
//        int n = 2;
//        int n = 2;
        int n = 4;
        // 각 집의 배달 박스 개수
//        int[] deliveries = {1, 0, 3, 1, 2};
//        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
//        int[] deliveries = {0, 0, 1, 0, 0};
//        int[] deliveries = {0, 0};
//        int[] deliveries = {2, 4};
//        int[] deliveries = {0, 6};
        int[] deliveries = {25, 24, 51, 0};

        // 각 집의 수거 박스 개수
//        int[] pickups = {0, 3, 0, 4, 0};
//        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
//        int[] pickups = {0, 0, 0, 0, 0};
//        int[] pickups = {0, 4};
//        int[] pickups = {4, 2};
//        int[] pickups = {0, 0};
        int[] pickups = {51, 0, 0, 49};
        long result = lesson.solution(cap, n, deliveries, pickups);
        System.out.println("result = " + result);
    }
}
