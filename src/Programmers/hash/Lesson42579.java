package Programmers.hash;

import java.util.*;

public class Lesson42579 {
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
//        String[] a = {"A", "A", "B", "A", "B", "B"};
        String[] a = {"B"};
        int[] b = {500};
//        int[] b = {5, 5, 6, 5, 7, 7};
//        int[] b = {500, 600, 150, 800, 2500};

        Lesson42579 l = new Lesson42579();
        for(int i : l.solution(a, b)){
            System.out.print(i + " ");
        }
    }
}
