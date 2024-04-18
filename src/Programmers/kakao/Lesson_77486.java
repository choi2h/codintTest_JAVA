package Programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
// 다단계 칫솔 판매
public class Lesson_77486 {

    private static final int TOOTH_BRUSH_PRICE = 100;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> refMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
            refMap.put(enroll[i], referral[i]);
        }

        Map<String, Integer> resultMap = new HashMap<>();
        for(int i=0; i<seller.length; i++) {
            String sellerName = seller[i];
            int salePrice = amount[i] * TOOTH_BRUSH_PRICE;

            while (salePrice > 0) {
                int tenPercentOfPrice = Math.max(salePrice/10, 0);
                int sumPrice = resultMap.getOrDefault(sellerName, 0) + (salePrice-tenPercentOfPrice);
                resultMap.put(sellerName, sumPrice);

                if(refMap.get(sellerName).equals("-")) {
                    break;
                }

                salePrice = tenPercentOfPrice;
                sellerName = refMap.get(sellerName);
            }
        }


        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++) {
            int price = resultMap.getOrDefault(enroll[i], 0);
            answer[i] = price;
        }

        return answer;
    }


    /*
    {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
    {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
    {"young", "john", "tod", "emily", "mary"}
    {12, 4, 2, 5, 10}
    {360, 958, 108, 0, 450, 18, 180, 1080}

    {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"}
    {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"}
    {"sam", "emily", "jaimie", "edward"}
    {2, 3, 5, 4}
    {0, 110, 378, 180, 270, 450, 0, 0}
     */
    public static void main(String[] args) {
        Lesson_77486 lesson = new Lesson_77486();
//        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//        String[] seller = {"young", "john", "tod", "emily", "mary"};
//        int[] amount = {12, 4, 2, 5, 10};

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};
        int[] result = lesson.solution(enroll, referral, seller, amount);
        System.out.println("result = " + Arrays.toString(result));
    }
}
