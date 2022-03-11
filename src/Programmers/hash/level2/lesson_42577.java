package Programmers.hash.level2;

import java.util.*;

class Solution_42577 {
    /*
    프로그래머스 > 해시 > Level1 > Lesson_42577 > 전화번호 목록
    URL : https://programmers.co.kr/learn/courses/30/lessons/42577

    정확성  테스트
    테스트 1 〉	통과 (0.05ms, 75.8MB)
    테스트 2 〉	통과 (0.10ms, 78MB)
    테스트 3 〉	통과 (0.06ms, 72.2MB)
    테스트 4 〉	통과 (0.09ms, 75.1MB)
    테스트 5 〉	통과 (0.08ms, 88.6MB)
    테스트 6 〉	통과 (0.09ms, 75.6MB)
    테스트 7 〉	통과 (0.08ms, 77.6MB)
    테스트 8 〉	통과 (0.05ms, 67.7MB)
    테스트 9 〉	통과 (0.08ms, 76.6MB)
    테스트 10 〉	통과 (0.10ms, 78.4MB)
    테스트 11 〉	통과 (0.09ms, 71.2MB)
    테스트 12 〉	통과 (0.06ms, 74.4MB)
    테스트 13 〉	통과 (0.09ms, 76.2MB)
    테스트 14 〉	통과 (3.38ms, 72.4MB)
    테스트 15 〉	통과 (2.46ms, 80.9MB)
    테스트 16 〉	통과 (5.23ms, 79.8MB)
    테스트 17 〉	통과 (7.56ms, 86.3MB)
    테스트 18 〉	통과 (10.95ms, 84.6MB)
    테스트 19 〉	통과 (4.54ms, 89.3MB)
    테스트 20 〉	통과 (7.52ms, 80.3MB)
    효율성  테스트
    테스트 1 〉	통과 (2.60ms, 58.5MB)
    테스트 2 〉	통과 (3.16ms, 56.8MB)
    테스트 3 〉	통과 (326.08ms, 251MB)
    테스트 4 〉	통과 (222.65ms, 135MB)
     */

    public boolean solution(String[] phone_book) {
        Map<String, String> phoneNumberMap = new HashMap<>();


        for(String number : phone_book) {
            phoneNumberMap.put(number, number);
        }

        for(String number : phone_book) {
            for(int index=0; index<number.length(); index++) {
                String temp = number.substring(0, index);
                if(phoneNumberMap.containsKey(temp)) {
                    return false;
                }
            }
        }




//        for(int i=0; i<phone_book.length; i++){
//            String number1 = phone_book[i];
//            for(int j=i+1; j< phone_book.length; j++){
//                String number2 = phone_book[j];
//
//                if(number1.length() < number2.length()){
//                    if(number2.startsWith(number1)){
//                        return false;
//                    }
//                } else {
//                    if(number1.startsWith(number2)){
//                        return false;
//                    }
//                }
//
//
//            }
//        }

        return true;
    }
}
