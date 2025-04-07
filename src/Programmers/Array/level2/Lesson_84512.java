package Programmers.Array.level2;

public class Lesson_84512 {
//    String[] arr = new String[]{"A", "E", "I", "O", "U"};



    public int solution(String word) {
        int answer = 0;
        String s = "AEIOU";

        String[] wordArr = word.split("");
        for (int i=0; i<wordArr.length; i++) {
            int j = s.indexOf(wordArr[i]);

            int x=0;
            for(int k=s.length()-i-1; k>0; k--) {
                if(j!=0) x += (int) Math.pow(s.length(), k);
            }

            answer += (x * j) + (j + 1);
        }

        return answer;
    }

    private static int find(String word) {
        String[] arr = new String[]{"A", "E", "I", "O", "U"};
        int count = 0;

        for(String s : arr) {
             count++;
             if(word.equals(s)) return count;
            for(String s2 : arr) {
                count++;
                if(word.equals(s+s2)) return count;
                for(String s3 : arr) {
                    count++;
                    if(word.equals(s+s2+s3)) return count;
                    for(String s4 : arr) {
                        count++;
                        if(word.equals(s+s2+s3+s4)) return count;
                        for(String s5 : arr) {
                            count++;
                            if(word.equals(s+s2+s3+s4+s5)) return count;
                        }
                    }
                }
            }
        }

        return 0;
    }

    private int getAddCount(String s, String[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(s.equals(arr[i])) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
        Lesson_84512 sol = new Lesson_84512();
        System.out.println(sol.solution("AAAAE"));
        System.out.println(Math.pow(5,0));

        System.out.println(find("EE"));
    }
}
