package baekJoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Q11408 {

    // arr => int[work_num][employee_num] = pay
    static int solution(int n, int m, PriorityQueue<WorkInfo>[] arr) {
        int[] pay_mem = new int[m+1];
        int[] employee_mem = new int[m+1];

        Arrays.sort(arr, new Comparator<PriorityQueue<WorkInfo>>() {
            @Override
            public int compare(PriorityQueue<WorkInfo> o1, PriorityQueue<WorkInfo> o2) {
                return o1.size()-o2.size();
            }
        });


        for(int i=0; i<arr.length; i++) {
            if(arr[i].isEmpty()) {
                continue;
            }

            WorkInfo workInfo = arr[i].peek();
            if(employee_mem[workInfo.employeeNum] > 0) {
                // 내 다음 + 지금 페이
                // 지금 페이-해당 일 페이 + 해당 일 다음 페이 + 내 페이
                // 둘 중 큰거 사용



            } else {
                arr[i].poll();
                employee_mem[workInfo.employeeNum] = i;
            }

        }

        return 0;
    }



    // 직원 N
    // 할일 M
    // 각 직원 한개의 일만 가능, 각각의 일은 한 사람이 담당
    // 최대 업무 /최소 임금의 수를 구하라
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        // 일 번호 / 급여 / 하는 사람
        PriorityQueue<WorkInfo>[] arr = new PriorityQueue[m+1];
        for(int i=1; i<=m; i++) {
            arr[i] = new PriorityQueue<>((o1, o2) -> (o1.pay-o2.pay)*-1);
        }

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            for(int j=1; j<line.length; j=j+2) {
                int workNum = Integer.parseInt(line[j]);
                int pay = Integer.parseInt(line[j+1]);
                WorkInfo workInfo = new WorkInfo(i, pay);
                arr[workNum].add(workInfo);

            }
        }

        solution(n, m, arr);
        /*
        5 5
        2 1 3 2 2
        1 1 5
        2 2 1 3 7
        3 3 9 4 9 5 9
        1 1 0
         */
    }

    static class WorkInfo implements Comparable<WorkInfo>{
        int employeeNum;
        int pay;

        WorkInfo(int employeeNum, int pay) {
            this.employeeNum = employeeNum;
            this.pay = pay;
        }

        @Override
        public int compareTo(WorkInfo o) {
            return this.pay-o.pay;
        }
    }
}
