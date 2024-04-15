package Programmers.kakao;

import java.util.HashMap;
import java.util.Map;

public class Lesson_268712 {

    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> nameIndexMap = new HashMap<>();

        for(int i=0; i<friends.length; i++) {
            nameIndexMap.put(friends[i], i);
        }
        System.out.println("friends.length = " + friends.length);
        // 선물 기록 배열
        int[][] giftRecords = new int[friends.length][friends.length];
        // 선물 지수 배열
        int[] giftScore = new int[friends.length];

        // 선물 기록을 확인하며 선물 지수 계산
        for (String gift : gifts) {
            // 준 사람 " " 받은사람 배열
            String[] record = gift.split(" ");
            int giverIndex = nameIndexMap.get(record[0]);
            int receiverIndex = nameIndexMap.get(record[1]);

            // 선물 기록에 선물 줬던 기록 계산
            int[] giveRecord= giftRecords[giverIndex];
            giveRecord[receiverIndex] = giveRecord[receiverIndex]+1;

            // 선물을 준 사람은 선물 지수 +1
            giftScore[giverIndex] = giftScore[giverIndex] + 1;
            // 선물을 받은 사람은 선물 지수 -1
            giftScore[receiverIndex] = giftScore[receiverIndex] - 1;
        }

        // 결과적으로 구할 제일 선물을 많이 받을 개수 저장 변수
        int maxReceiveGift = 0;
        // 받는 선물 기록 배열
        int[] receiveGiftRecord = new int[friends.length];

        // 선물 기록을 확인하며 내가 받을 선물 계산
        for(int i=0; i<giftRecords.length; i++) {
            for(int j=i+1; j<giftRecords.length; j++) {
                // i번째 이름이 j번째 이름에게 선물을 줬던 횟수
                int giveCount1 = giftRecords[i][j];
                // j번째 이름이 i번째 이름에게 선물을 줬던 횟수
                int giveCount2 = giftRecords[j][i];

                System.out.println(i + " -> " + j + " : " + giveCount1);
                System.out.println(j + " -> " + i + " : " + giveCount2);

                // 선물 횟수가 더 많은 사람이 선물을 받음
                if(giveCount1 > giveCount2) {
                    receiveGiftRecord[i] = receiveGiftRecord[i]+1;
                } else if(giveCount2 > giveCount1) {
                    receiveGiftRecord[j] = receiveGiftRecord[j]+1;
                }
                // 선물 횟수가 같으면 선물지수가 더 큰사람이 선물을 받음
                else {
                    System.out.println("선물지수 : i=" + giftScore[i] + " j=" + giftScore[j]);
                    if(giftScore[i] > giftScore[j]) {
                        receiveGiftRecord[i] = receiveGiftRecord[i]+1;
                    } else if(giftScore[j] > giftScore[i]) {
                        receiveGiftRecord[j] = receiveGiftRecord[j]+1;
                    }
                    // 선물지수가 같으면 선물을 주고받지 않음
                }

                int maxCount = Math.max(receiveGiftRecord[j], receiveGiftRecord[i]);
                maxReceiveGift = Math.max(maxReceiveGift, maxCount);
            }
        }

        return maxReceiveGift;
    }

    public static void main(String[] args) {
        Lesson_268712 lesson = new Lesson_268712();
//        String[] friends = {"muzi", "ryan", "frodo", "neo"};
//        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] friends = {"a", "b", "c"};
//        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
//        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};

        int result = lesson.solution(friends, gifts);
        System.out.println(result);
    }

}
