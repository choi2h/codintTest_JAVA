package Programmers.etc.level1;

/*
옹알이(2)
URL : https://school.programmers.co.kr/learn/courses/30/lessons/133499
 */
public class Lesson_133499 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] ableSpeak = {"aya", "ye", "woo", "ma"};

        for(String babble : babbling) {
            if(isCanSpeak(ableSpeak, babble)) {
                answer++;
            }
        }

        return answer;
    }

    // ayayeaya - o
    // ayaayaye - x
    // yeayaye - o
    // yayae - x
    private boolean isCanSpeak(String[] ableSpeak, String b) {
        // "aya", "ye", "woo", "ma"
        b = b.toLowerCase();
        for(String speak : ableSpeak) {
            if(b.contains(speak+speak)) {
                return false;
            }
        }

        for(String speak : ableSpeak) {
            b = b.replace(speak, " ");
        }

        b = b.replace(" ", "");
        return b.length() == 0;
    }

    public static void main(String[] args) {
        Lesson_133499 lesson = new Lesson_133499();
//        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
//        String[] babbling = {"aya", "yee", "u", "maa"};
        String[] babbling = {"ayaayaye", "ayayeaya", "yeayaye", "ayaayayeayaayaye", "aya", "ye", "woo", "ma", "ayayewooma", "mawooyeaya", "wooeye", "mamamamamamama", "yayae"}; //8
        int result = lesson.solution(babbling);
        System.out.println(result);
    }
}
