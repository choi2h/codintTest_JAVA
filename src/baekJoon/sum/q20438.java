package baekJoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int totalCount = Integer.parseInt(input[0]);

        // 자는 학생번호 체크
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] sleepNums= new int[totalCount+3];
        while (st1.hasMoreTokens()) {
            sleepNums[Integer.parseInt(st1.nextToken())] = -1;
        }

        // 출석 코드 전달 학생
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> passNums = new ArrayList<>();
        while (st2.hasMoreTokens()) {
            int num = Integer.parseInt(st2.nextToken());
            if(sleepNums[num] != -1) passNums.add(num);
        }
        passNums.sort(Integer::compareTo);

        // 학생 수 누적
        int[] studentNumbers = new int[totalCount+3];
        for(int i=3; i<studentNumbers.length; i++) {
            // 이전 학생수 기록
            studentNumbers[i] = studentNumbers[i-1];

            // 졸고 있는 학생이면 패스
            if(sleepNums[i] == -1) continue;

            // 배수로 나눔이 되는 숫자가 있는지 확인
            for(int j=0; j<passNums.size() && i>=passNums.get(j); j++) {
                // 나누어지는 수가 있으면 출석 성공으로 출석 학생 수 증가
                if(i%passNums.get(j) == 0) {
                    studentNumbers[i]++;
                    break;
                }
            }
        }

        for (int i=0; i<Integer.parseInt(input[3]); i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st3.nextToken());
            int end = Integer.parseInt(st3.nextToken());
            // 구간의 총인원 - 구간의 출석인원
            System.out.println((end-start+1)-(studentNumbers[end] - studentNumbers[start-1]));
        }
    }
}
