package Programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lesson_258709 {

    private int maxWinCount = 0;
    private int[] maxWinDiceMix;

    public int[] solution(int[][] dice) {
        // 한 사람이 가져가는 수 있는 주사위 개수
        int maxDiceCount = dice.length/2;
        // 주사위 분배 경우의 수 저장 배열
        int[][] mixArr = new int[2][maxDiceCount];
        // 모든 경우의 수를 보면 a가 가져갈 수 있는 경우의 수와 b가 가져갈 수 있는 경우의 수가 같다.
        // 중복되는 경우의 수를 생략하기 위해 모든 경우의 수의 반만 확인한다.
        // 반만 조회하기 위해서는 가장 첫번째 주사위를 a타입에 할당한 후 모든 주사위 조합의 경우를 구하고,
        // a타입과 b타입에 할당된 주사위 조합 중 이긴 횟수가 더 많은 주사위 조합을 플레이어 a에게 주면 된다.
        mixArr[0][0] = 1;
        // 주사위 조합 확인
        checkAllCaseDiceMix(dice, mixArr, 1, 1, 0);

        return maxWinDiceMix;
    }


    // 주사위를 조합할 수 있는 모든 경우의 수를 구한다.
    private void checkAllCaseDiceMix(int[][] dice, int[][] mixArr, int index, int aIndex, int bIndex) {
        // 주사위를 반으로 다 나누어 가졌을 때
        if(dice.length <= index) {
            System.out.println("mixArr : a=" + Arrays.toString(mixArr[0]) + " b=" + Arrays.toString(mixArr[1]));

            // a조합과 b조합을 변수에 저장
            // aMix라고 해서 a가 가져간 주사위 조합이 아닌
            // a타입의 주사위 조합 / b타입의 주사위 조합으로 보면 이해가 쉽다.
            int[] aMix = mixArr[0];
            int[] bMix = mixArr[1];

            // 각 주사위 조합이 나올 수 있는 모든 점수를 구함
            List<Integer> aScores = getScores(dice, aMix);
            List<Integer> bScores = getScores(dice, bMix);

            // 구한 점수를 오름차순으로 정렬
            aScores.sort(Comparator.comparingInt(o -> o));
            bScores.sort(Comparator.comparingInt(o -> o));

            // 두 주사위 조합 모두 이긴 횟수를 구한다
            int[] winCountArr = getWinCountArr(aScores, bScores);
            int aWinCount =winCountArr[0];
            int bWinCount = winCountArr[1];

            // a조합이 b조합보다 이긴 횟수가 많고
            // 지금까지의 최대 이긴 횟수보다 많으면
            // 플레이어 A는 a조합의 주사위 조합이 적절하다고 판단. => 전역변수에 저장
            if(aWinCount > bWinCount && aWinCount > maxWinCount) {
                System.out.println("Change max win count!!! diceMix=" + Arrays.toString(aMix) + ", winCount=" + aWinCount + ", maxWinCount=" + maxWinCount);
                maxWinCount = aWinCount;
                // Arrays.copyOf()를 사용하는 이유는
                // 전역변수에 aMix의 참조값을 저장하므로 다음 루프를 돌 때 전역변수의 값도 함께 변경된다.
                // aMix의 실제값을 저장하기 위해 해당 배열을 복사함
                maxWinDiceMix = Arrays.copyOf(aMix, aMix.length);
            }
            // b조합이 a조합보다 이긴 횟수가 많고
            // 지금까지의 최대 이긴 횟수보다 많으면
            // 플레이어 A는 b조합의 주사위 조합이 적절하다고 판단. => 전역변수에 저장
            else if(bWinCount > maxWinCount) {
                System.out.println("Change max win count!!! diceMix=" + Arrays.toString(bMix) + ", winCount=" + bWinCount + ", maxWinCount=" + maxWinCount);
                maxWinCount = bWinCount;
                maxWinDiceMix = Arrays.copyOf(bMix, bMix.length);
            }

            System.out.println("maxWinDiceMix = " + Arrays.toString(maxWinDiceMix));
        }

        // 경우의 수 생성
        // 현재 주사위 index를 a타입에 한번 b타입테 한번씩 할당하여 모든 주사위 조합을 만든다.
        // 만약 a타입의 주사위 개수가 다 찼다면 남은 주사위는 다 b타입에 할당한다.
        // 반대로, b타입의 주사위 개수가 다 찼다면 남은 주사위는 다 a타입에 할당한다.

        // A타입에 할당할 경우
        if(aIndex < dice.length/2) {
            mixArr[0][aIndex] = index+1;
            checkAllCaseDiceMix(dice, mixArr, index+1, aIndex+1, bIndex);
        }

        // B타입에 할당할 경우
        if(bIndex < dice.length/2) {
            mixArr[1][bIndex] = index+1;
            checkAllCaseDiceMix(dice, mixArr, index+1, aIndex, bIndex+1);
        }
    }

    // 이긴 횟수를 구하는 메소드
    private int[] getWinCountArr(List<Integer> aScores, List<Integer> bScores) {
        int aWinCount = 0;
        int bWinCount = 0;

        // 이분탐색으로 현재 a인덱스의 점수보다 낮은 b인덱스를 찾는다.
        // 이전에 오름차순 정렬을 했으므로, 해당 0~b인덱스까지는 현재 a인덱스의 점수로 다 이길 수 있다.
        // b인덱스까지의 점수 개수(bIndex+1)을 이긴횟수에 누적해주면 a타입의 총 이긴 횟수를 구할 수 있다.
        for (int aScore : aScores) {
            // 이분 탐색
            // 왼쪽 인덱스(start)
            int lt = 0;
            // 오른쪽 인덱스(end)
            int rt = bScores.size() - 1;
            // 중앙값
            int mid = 0;
            while (lt <= rt) {
                // 인덱스 범위 내에서 중앙 값을 찾는다.
                mid = lt + (rt - lt) / 2;

                // 중앙값에 해당하는 b타입의 점수를 가져온다.
                int bScore = bScores.get(mid);
                // 만약, b점수가 a보다 작다면 a가 이길 수 있으므로
                if (bScore < aScore) {
                    // 중앙값이 b타입의 모든 점수 중 가장 큰 값일 때
                    if (bScores.size() <= mid + 1) {
                        // a점수로 모든 b점수를 이길 수 있다고 판단하며,
                        // b타입의 모든 점수의 개수를 a승리 카운트에 누적해준다.
                        aWinCount += bScores.size();
                        break;
                    }
                    // 현재 b점수는 a점수보다 작은데
                    // 이 다음 b점수는 a점수보다 크거나 같을 때,
                    // a점수는 현재 b점수까지만 이길 수 있다고 판단하여,
                    else if (bScores.get(mid + 1) >= aScore) {
                        // 현재 b점수까지의 개수를 a승리 카운트에 누적해준다.
                        aWinCount += mid + 1;
                        break;
                    }
                    // 현재 b점수도 a점수보다 작고 다음 b점수도 a점수보다 낮으면
                    // a가 이길 수 있는 점수가 더 있다고 판단.
                    // 현재 보다 더 큰 점수를 확인하기 위해
                    // lt(start)를 중앙값+1로 설정하여 중앙값 기준 오른쪽 범위를 확인한다.
                    else {
                        lt = mid + 1;
                    }
                }
                // b점수가 a점수보다 크므로 a가 이길 수 없다고 판단.
                // 중앙값을 기준으로 더 적은 점수를 확인하기 위해
                // rt(end)를 중앙값-1로 설정하여 중앙값 기준 왼쪽 범위 확인한다.
                else {
                    rt = mid - 1;
                }
            }

            // a타입의 승리 횟수를 다 확인한 후 바로 b의 승리 횟수를 구할 수 있다.
            // 위에서 구한 중앙값까지는 b가 a한테 지는 점수이다.
            // 그렇다면 그 이후의 점수는 비기거나 a한테 이길 수 있는 점수로 판단된다.
            // 비기는 경우를 빼고 이기는 경우를 구하여 b타입의 승리 횟수를 구한다.
            // bIndex탐색 범위 : mid~bScore.size()
            while (mid >= 0 && mid < bScores.size()) {
                // a점수가 b점수보다 작다면
                if (aScore < bScores.get(mid)) {
                    // 현재 인덱스를 포함한 이후 모든 점수의 개수를 승리 횟수에 누적한다.
                    bWinCount += bScores.size() - mid;
                    break;
                }
                // a점수가 b점수와 작지 않다면 (아마 비기는 경우)
                // 더 큰 점수를 확인해보기 위해 mid(bIndex로 쓰이고 있는 변수)를 하나씩 증가하여 확인해본다.
                else {
                    mid++;
                }
            }
        }

        System.out.println("winCount : a=" + aWinCount + ", b=" + bWinCount);
        return new int[]{aWinCount, bWinCount};
    }

    // 모든 점수 경우의 수 구함
    private List<Integer> getScores(int[][] dice, int[] mixArr) {
        // 점수들을 저장할 리스트 생성
        List<Integer> scoreList = new ArrayList<>();
        // 경우의 수 재귀
        sumAllCaseScore(dice, mixArr, 0, 0, scoreList);

        return scoreList;
    }

    private void sumAllCaseScore(int[][] dices, int[] mixArr, int index, int sumScore, List<Integer> scoreList) {
        // 모든 주사위가 다 굴려졌다면
        if(mixArr.length <= index) {
            // 해당 점수를 리스트에 추가한다.
            scoreList.add(sumScore);
            return;
        }

        // 현재 순서의 주사위 가져오기
        int diceIndex = mixArr[index]-1;
        int[] dice = dices[diceIndex];
        // 가져온 주사위의 6면 모두를 굴려봐야 한다.
        for(int i=0; i<6; i++) {
            // 다음 주사위를 굴리기 위해 index는 +1을 해준다.
            // 굴려서 나온 점수를 더하여 sumScore 인자에 넘겨주어 점수를 누적한다.
            sumAllCaseScore(dices, mixArr, index+1, sumScore+dice[i], scoreList);
        }
    }


    /*
    [[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]	[1, 4]
    {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}}	{2}
    {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}}	{1, 3}
     */

    public static void main(String[] args) {
        Lesson_258709 lesson = new Lesson_258709();
//        int[][] dice = {{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}};
//        int[][] dice = {{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}};
        int[][] dice = {{40, 41, 42, 43, 44, 45}, {43, 43, 42, 42, 41, 41}, {1, 1, 80, 80, 80, 80}, {70, 70, 1, 1, 70, 70}};
        int[] result = lesson.solution(dice);
        System.out.println(Arrays.toString(result));
    }
}
