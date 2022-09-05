package inflearn.array;

import java.util.Scanner;

/*
    가위 바위 보
    설명
    A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
    가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
    두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.

    입력
    첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
    세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.

    출력
    각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.

    예시 입력 1
    5
    2 3 3 1 3
    1 1 2 2 3

    예시 출력 1
    A
    B
    A
    B
    D
 */
public class Q3 {

    //1:가위, 2:바위, 3:보
    public String solution(int gameCount, int[] a, int[] b) {
        StringBuilder result = new StringBuilder();

        for(int i=0; i<gameCount; i++) {
            int aCard = a[i];
            int bCard = b[i];

            if(aCard == bCard) {
                result.append("D");
            } else if ((aCard==1 && bCard==3) || (!(aCard==3&&bCard==1) && aCard>bCard)) {
                result.append("A");
            } else {
                result.append("B");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int gameCount = in.nextInt();
        int[] a = new int[gameCount];
        int[] b = new int[gameCount];

        for(int i=0;i<gameCount; i++) {
            a[i] = in.nextInt();
        }

        for(int i=0;i<gameCount; i++) {
            b[i] = in.nextInt();
        }

        Q3 q = new Q3();
        String result = q.solution(gameCount, a, b);
        for(char s : result.toCharArray()) {
            System.out.println(s);
        }
    }
}
