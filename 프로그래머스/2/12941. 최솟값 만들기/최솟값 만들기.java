import java.util.Arrays;

class Solution{
    public int solution(int[] A, int[] B){
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int i=0, j=B.length-1;
        while(i<A.length && j>=0) {
            answer += A[i++]*B[j--];
        }

        return answer;
    }
}