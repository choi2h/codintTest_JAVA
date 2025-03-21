package Programmers.hash.level3;


import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/*
베스트 앨범
URL : https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class Lesson_42579_1 {
    static class Song{
        int index;
        int plays;

        Song(int index, int plays){
            this.index = index;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, PriorityQueue<Song>> genreMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            countMap.put(genres[i], countMap.getOrDefault(genres[i], 0) + plays[i]);

            if(genreMap.containsKey(genres[i])) {
                genreMap.get(genres[i]).add(new Song(i, plays[i]));
            } else {
                PriorityQueue<Song> queue = new PriorityQueue<>(
                        (a,b) -> b.plays==a.plays ? a.index-b.index : b.plays - a.plays
                );
                queue.add(new Song(i, plays[i]));
                genreMap.put(genres[i], queue);
            }
        }

        List<String> keys = new ArrayList<>(countMap.keySet());
        keys.sort((a, b) -> countMap.get(b) - countMap.get(a));
        List<Integer> ans = new ArrayList<>();
        for(String key : keys) {
            PriorityQueue<Song> songs = genreMap.get(key);
            if(!songs.isEmpty()) ans.add(songs.poll().index);
            if(!songs.isEmpty()) ans.add(songs.poll().index);
        }

        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
//        String[] a = {"classic", "pop", "classic", "classic", "pop"};
        String[] a = {"A", "A", "B", "A", "B", "B"};
//        String[] a = {"B"};
//        int[] b = {500};
        int[] b = {5, 5, 6, 5, 7, 7};
//        int[] b = {500, 600, 150, 800, 2500};

        Lesson_42579_1 l = new Lesson_42579_1();
        System.out.print(Arrays.toString(l.solution(a, b)));
    }
}
