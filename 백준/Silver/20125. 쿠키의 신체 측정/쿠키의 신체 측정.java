import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        char[][] arr = new char[n][n];
        for(int i=0; i<n; i++) {
            arr[i] = reader.readLine().toCharArray();
        }


        int[] head = findHead(arr);
        int[] breath = new int[]{head[0]+1, head[1]};
        // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이
        int leftArm = breath[1]-1;
        while(leftArm >= 0) {
            if(arr[breath[0]][leftArm] == '*') leftArm--;
            else break;
        }

        int rightArm = breath[1]+1;
        while(rightArm < n) {
            if(arr[breath[0]][rightArm] == '*') rightArm++;
            else break;
        }

        int body = breath[0]+1;
        while(body < n) {
            if(arr[body][breath[1]] == '*') body++;
            else break;
        }

        int leftLeg = body;
        while(leftLeg < n) {
            if(arr[leftLeg][breath[1]-1] == '*') leftLeg++;
            else break;
        }

        int rightLeg = body;
        while(rightLeg < n) {
            if(arr[rightLeg][breath[1]+1] == '*') rightLeg++;
            else break;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(breath[0]+1).append(" ").append(breath[1]+1).append("\n");
        builder.append(breath[1]-leftArm-1).append(" ");
        builder.append(rightArm-breath[1]-1).append(" ");
        builder.append(body-breath[0]-1).append(" ");
        builder.append(leftLeg-body).append(" ");
        builder.append(rightLeg-body);
        System.out.println(builder);
    }

    private static int[] findHead(char[][] arr) {
        int[] head = new int[2];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j] == '*') {
                    head[0] = i;
                    head[1] = j;
                    return head;
                }
            }
        }

        return head;
    }
}