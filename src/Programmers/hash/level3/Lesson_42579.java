package Programmers.hash.level3;

import java.util.*;

/*
베스트 앨범
URL : https://school.programmers.co.kr/learn/courses/30/lessons/42579

테스트 1 〉	통과 (2.58ms, 72.9MB)
테스트 2 〉	통과 (3.95ms, 73.6MB)
테스트 3 〉	통과 (4.97ms, 91.8MB)
테스트 4 〉	통과 (3.01ms, 75MB)
테스트 5 〉	통과 (4.10ms, 75.6MB)
테스트 6 〉	통과 (4.09ms, 76.4MB)
테스트 7 〉	통과 (2.63ms, 79.4MB)
테스트 8 〉	통과 (2.74ms, 72.6MB)
테스트 9 〉	통과 (2.52ms, 74MB)
테스트 10 〉	통과 (4.40ms, 88.7MB)
테스트 11 〉	통과 (3.42ms, 76MB)
테스트 12 〉	통과 (2.57ms, 75.9MB)
테스트 13 〉	통과 (4.15ms, 78.7MB)
테스트 14 〉	통과 (2.84ms, 77.3MB)
테스트 15 〉	통과 (2.54ms, 74.5MB)
 */
public class Lesson_42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresPlayCountMap = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            String g = genres[i];
            genresPlayCountMap.put(g,  genresPlayCountMap.getOrDefault(g, 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(genresPlayCountMap.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        List<Integer> answer = new ArrayList<>();
       for(Map.Entry<String, Integer> entry: entries) {
            List<Play> playList = new ArrayList<>();

            for(int i=0; i<plays.length; i++) {
                if(genres[i].equals(entry.getKey())) {
                    Play play = new Play(i, plays[i]);
                    playList.add(play);
                }
            }

            Collections.sort(playList);
            for(int i=0; i<playList.size(); i++) {
                if(i==2) {
                    break;
                }
                answer.add(playList.get(i).index);
            }
       }

        return answer.stream().mapToInt(i->i).toArray();
    }

    static class Play implements Comparable<Play>{
        int index;
        int playCount;

        public Play(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }

        @Override
        public int compareTo(Play o) {
            return this.playCount==o.playCount ?  this.playCount-o.index : o.playCount-this.playCount;
        }
    }


    public static void main(String[] args) {
//        String[] a = {"classic", "pop", "classic", "classic", "pop"};
        String[] a = {"A", "A", "B", "A", "B", "B"};
//        String[] a = {"B"};
//        int[] b = {500};
        int[] b = {5, 5, 6, 5, 7, 7};
//        int[] b = {500, 600, 150, 800, 2500};

        Lesson_42579 l = new Lesson_42579();
        for(int i : l.solution(a, b)){
            System.out.print(i + " ");
        }
    }
}
