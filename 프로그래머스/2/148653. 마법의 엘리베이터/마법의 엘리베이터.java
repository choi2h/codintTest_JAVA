import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int storey) {
        int answer = Integer.MAX_VALUE;
        
        Queue<Integer> numQueue = new LinkedList<Integer>();
        Queue<Integer> countQueue = new LinkedList<Integer>();
        numQueue.add(storey);
        countQueue.add(0);
        while(!numQueue.isEmpty()) {
            int num = numQueue.poll();
            int count = countQueue.poll();
            int next = num/10;
            int n = num%10;
            
            if(next == 0) {
                answer = Math.min(answer, count + Math.min(n, 10-n+1));
                continue;
            }
            
            numQueue.add(next+1);
            countQueue.add(count+(10-n));
            
            numQueue.add(next);
            countQueue.add(count+n);
        }   
            
        return answer;
    }
}