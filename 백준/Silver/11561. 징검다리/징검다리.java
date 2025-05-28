import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new Scanner(System.in);
        long t = Long.parseLong(sc.nextLine());

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<t; i++) {
            long n = Long.parseLong(sc.nextLine());
            sb.append(find(n)).append("\n");
        }

        System.out.println(sb);
    }

    private static long find(long n) {
        long answer = 0;
        long min=1, max=(long) Math.sqrt((2*n)+1);
        while(min <= max) {
            long mid = (min+max)/2;

            long sum = mid * (mid+1) / 2;

            if(sum <= n) {
                answer = mid;
                min = mid+1;
            } else max = mid-1;
        }

        return answer;
    }
}