package Programmers.dfsbfs;

public class Lesson_43163 {
    int answer;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        if(!isExist(target, words)) return 0;

        answer = 0;
        visited = new boolean[words.length];
        find(begin, target, words, 0);

        return answer;
    }

    private void find(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = answer == 0 ? count : Math.min(answer, count);
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(visited[i]) continue;

            if(convertCount(begin, words[i], target) == 1) {
                visited[i] = true;
                find(words[i], target, words, count+1);
                visited[i] = false;
            }
        }
    }

    private boolean isExist(String target, String[] words) {
        for(String word : words) {
            if(word.equals(target)) return true;
        }

        return false;
    }

    private int convertCount(String before, String after, String target) {
        int count = 0;
        for(int i = 0; i < before.length(); i++) {
            if(before.charAt(i) != target.charAt(i) && before.charAt(i) != after.charAt(i)) count += 1;
        }

        return count;
    }

    /*
    "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
    "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
     */
    public static void main(String[] args) {
        Lesson_43163 lesson = new Lesson_43163();
        System.out.println(lesson.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(lesson.solution("AAAA", "AABB", new String[]{"AABA", "AABB"}));
        System.out.println(lesson.solution("abc", "cde", new String[]{"adc", "ade", "cde", "bbc", "bdc"}));
        System.out.println(lesson.solution("abc", "cde", new String[]{"adc", "abc", "adc","ade", "cde", "bbc", "bdc"}));
        System.out.println(lesson.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}
