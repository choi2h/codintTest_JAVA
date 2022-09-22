package inflearn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q6 {
        public List<Integer> solution(int[] arr) {
        /*    int[] answer = new int[2];

            int left = 0;
            int right = 0;

            for(int i=arr.length-1; i>0; i--) {
                if(arr[i] < arr[i-1]) {
                    answer[1] = i+1;
                    left = arr[i-1];
                    if(i+1 < arr.length){
                        right = arr[i+1];
                    }
                    break;
                }
            }

            for(int i=0; i<answer[1]; i++) {
                if(right == 0 && arr[i] >= left) {
                    answer[0] = i+1;
                    break;
                } else if(arr[i] >= left && arr[i] <=right) {
                    answer[0] = i+1;
                    break;
                }
            }*/

            List<Integer> answer = new ArrayList<>();
            int[] tmp = arr.clone();
            Arrays.sort(tmp);
            for(int i=0; i<arr.length; i++) {
                if(arr[i] != tmp[i]) answer.add(i+1);
            }

            return answer;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = in.nextInt();
            }

            Q6 q = new Q6();
            for(int i : q.solution(arr)) {
                System.out.print(i + " ");
            }
        }
}
