package Programmers.kakao;


import java.util.Arrays;

public class Lesson_150368 {

    // 이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
    // 할인을 안하는 이모티콘은 없는 듯
    int[] discounts = {10, 20, 30, 40};
    int maxSubscribe = 0;
    int maxBuyCost = 0;


    public int[] solution(int[][] users, int[] emoticons) {
        int[] discountInfo = new int[emoticons.length];
        dfs(users, emoticons, discountInfo, 0);

        return new int[]{maxSubscribe, maxBuyCost};
    }

    //  재귀
    private void dfs(int[][] users, int[] emoticons, int[] discountInfo, int count) {
        // 모든 이모티콘에 대한 할인 퍼센테이지 경우의 수가 정해졌다면
        if(count == emoticons.length) {
            // 구독 수와 구매 가격 계산 start
            int subscribeCount = 0;
            int buyCost = 0;

            // 경우의 수에 대해 모든 사용자 확인
            for (int[] user : users) {
                // 사용자의 최소 할인 퍼센테이지
                int myDiscount = user[0];
                // 사용자의 최대 구매 금액
                int myMaxCost = user[1];

                // 내가 구매한 이모티콘 가격 저장 변수
                int myCost = 0;
                // 경우의 수에 맞춰 이모티콘 전체 순회
                for (int j = 0; j < discountInfo.length; j++) {
                    // 이모티콘의 가격
                    int price = emoticons[j];
                    // 이 이모티콘의 할인 퍼센테이지
                    int discount = discountInfo[j];

                    // 이모티콘의 할인 퍼센테이지가 내 최소 할인 퍼센테이지보다 이상인지 확인
                    if (myDiscount <= discount) {
                        // 이상이라면 해당 이모티콘 구매 -> 구매 가격을 나의 구매 금액에 더해줌
                        myCost += discountedCost(price, discount);
                    }
                }

                // 구매 가능 이모티콘을 모두 구매한 가격이 내 최대 금액 이상이라면
                if (myCost >= myMaxCost) {
                    // 사용자는 구매하지 않고 이모티콘 플러스에 가입
                    subscribeCount++;
                }
                // 금액이 미달된다면
                else {
                    // 해당되는 이모티콘만 구매
                    buyCost += myCost;
                }
            }

            // 최대 구독자 수 보다 현재 경우의 수가 구독자 수가 높다면
            if(maxSubscribe < subscribeCount) {
                // 결과값 변경
                maxSubscribe = subscribeCount;
                maxBuyCost = buyCost;
            }
            // 최대 구독자 수와 현재 경우의 수의 구독자 수가 같다면
            else if (maxSubscribe == subscribeCount) {
                // 구매금액만 더 높은 금액으로 변경
                maxBuyCost = Math.max(maxBuyCost, buyCost);
            }
        } else {
            // discounts[0~3] => 가능한 할인율 10~40%
            for(int i=0; i<4; i++) {
                // 현재 이모티콘 인덱스에 해당 할인율을 넣어 모든 경우의 수를 구한다.
                discountInfo[count] = discounts[i];
                dfs(users, emoticons, discountInfo, count+1);
            }
        }
    }


    private int discountedCost(int price, int discount) {
        // 할인된 가격 = (가격/100) * (100-할인퍼센테이지)
        return (price / 100) * (100 - discount);
    }


    /*
    {{40, 10000}, {25, 10000}}	{7000, 9000}	{1, 5400}
    {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}	{1300, 1500, 1600, 4900}	{4, 13860}
     */
    public static void main(String[] args) {
        Lesson_150368 lesson = new Lesson_150368();

//        int[][] users = {{40, 10000}, {25, 10000}};
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
//        int[] emoticons = {7000, 9000};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] result = lesson.solution(users, emoticons);
        System.out.println(Arrays.toString(result));
    }
}
