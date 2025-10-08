import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static final String UPDATE = "UPDATE";
    private static final String EMPTY = "EMPTY";
    private static final String MERGE = "MERGE";
    private static final String UNMERGE = "UNMERGE";
    private static final String PRINT = "PRINT";
    
    private String[] values;
    private int[] arr;
    
    public String[] solution(String[] commands) {
        List<String> prints = new ArrayList<>();
        values = new String[2501];
        arr = new int[2501];
        for(int i=0; i<2501; i++) {
            arr[i] = i;
        }
        
        Arrays.fill(values, EMPTY);
        
        for(String command : commands) {
            String[] input = command.split(" ");
            
            if(input[0].equals(UPDATE)) {
                if(input.length == 3) {
                    updateValue(input[1], input[2]);
                } else {
                    int x = convertNum
                        (Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                    update(x, input[3]);   
                }
            } else if(input[0].equals(MERGE)) {
                int x1 = convertNum
                    (Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                int x2 = convertNum
                    (Integer.parseInt(input[3]),Integer.parseInt(input[4]));
                merge(x1, x2);
            } else if(input[0].equals(UNMERGE)) {
                int x = convertNum
                        (Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                unmerge(x);
            } else if(input[0].equals(PRINT)) {
                int x = convertNum
                        (Integer.parseInt(input[1]),Integer.parseInt(input[2]));
                prints.add(values[find(x)]);
            }
        }   
        
        String[] answer = new String[prints.size()];
        for(int i=0; i<prints.size(); i++) {
            answer[i] = prints.get(i);
        }
        return answer;
    }
    
    private void update(int x, String value) {
        values[find(x)] = value;
    }
    
    private void updateValue(String before, String after) {
        for(int i=1; i<values.length; i++) {
            if(values[i].equals(before)) values[i] = after;
        }
    }
    
    private void merge(int x1, int x2) {
        int fx1 = find(x1);
        int fx2 = find(x2);
        
        if(fx1 == fx2) return;
        
        if(values[fx1].equals(EMPTY) && !values[fx2].equals(EMPTY)) {
            union(fx2, fx1);
        } else {
            values[fx2] = EMPTY;
            union(fx1, fx2);
        }
    }
    
    private void unmerge(int x) {
        int parents = find(x);
        String value = values[parents];
        
        List<Integer> resetList = new ArrayList<>();
        for(int i=1; i<values.length; i++) {
            if(find(i) == parents) resetList.add(i);
        }
        
        for(int i : resetList) {
            arr[i] = i;
            values[i] = EMPTY;
        }
        
        values[x] = value;
    }
    
    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        arr[fb] = fa;
    }
    
    private int find(int a) {
        if(arr[a] == a) return a;
        
        return arr[a] = find(arr[a]);
    }
    
    public int convertNum(int x, int y) {
        return (50 * (x - 1)) + y;
    }
}