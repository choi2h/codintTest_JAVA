package Programmers.hash.level3;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lesson_64064 {

    Set<Integer> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        Arrays.sort(user_id);
        Arrays.sort(banned_id);

        boolean[] visited = new boolean[user_id.length];
        find(user_id, banned_id, 0, visited);


        return set.size();
    }

    public void find(String[] userIds, String[] bannedIds, int index, boolean[] visited) {
        if(index >= bannedIds.length) {
            int result=0;
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) result = result*10+(i+1);
            }
            set.add(result);
            return;
        }

        for(int i=0; i<userIds.length; i++) {
            if(!visited[i] && isSameFormat(userIds[i], bannedIds[index])) {
                visited[i] = true;
                find(userIds, bannedIds, index+1, visited);
                visited[i] = false;
            }

            if(bannedIds[index].charAt(0) != '*' && bannedIds[index].charAt(0) < userIds[i].charAt(0)) {
                break;
            }
        }

    }

    public boolean isSameFormat(String userId, String bannedId) {
        if(userId.length() != bannedId.length()) return false;

        for(int i=0; i<bannedId.length(); i++) {
            if(bannedId.charAt(i) == '*') continue;
            if(userId.charAt(i) != bannedId.charAt(i))  return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Lesson_64064 lesson = new Lesson_64064();
        int result = lesson.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
//        int result = lesson.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"});
        System.out.println(result);
    }
}
