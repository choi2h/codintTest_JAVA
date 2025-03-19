package Programmers.hash.level2;

import java.util.*;

public class Lesson_42577_1 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i = 1; i<phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1])) return false;
        }

        return true;
    }
}
