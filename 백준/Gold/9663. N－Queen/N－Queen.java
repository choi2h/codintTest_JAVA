import java.util.Scanner;

public class Main {

    private static int answer, n = 0;
    private static boolean[] col,slash,bslash;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new boolean[n];
        slash = new boolean[n*2];
        bslash = new boolean[n*2];

        setQueen(0);

        System.out.print(answer);
    }


    private static void setQueen(int row) {
        if(row == n) {
            answer++;
            return;
        }

        for(int i=0; i<n; i++) {
            if(col[i] || slash[row+i] || bslash[row-i+n]) continue;
            col[i] = slash[row+i] = bslash[row-i+n] = true;
            setQueen(row+1);
            col[i] = slash[row+i] = bslash[row-i+n] = false;
        }
    }
}