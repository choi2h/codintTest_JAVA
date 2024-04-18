package Programmers.kakao;

import java.util.Arrays;

// 2023 KAKAO BLIND RECRUITMENT
// 표현 가능한 이진트리
public class Lesson_150367 {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        // 모든 넘버 확인
        for(int i=0; i<numbers.length; i++) {
            // 10진수를 2진수로 변경
            String binaryNumber = convertBinaryNumber(numbers[i]);
            // 포화트리로 만듦
            binaryNumber = makePerfectBinaryTree(binaryNumber);

            // 조건에 맞는 이진트리가 생성 가능한지 확인
            boolean isPossible = checkNode(0, binaryNumber.length()-1, binaryNumber, false);

            // 생성 여부 동일 인덱스에 저장
            answer[i] = isPossible ? 1 : 0;
        }

        return answer;
    }

    private boolean checkNode(int start, int end, String binaryNumber, boolean isParentDummyNode) {
        // 재귀의 끝.
        if(start > end) {
            return true;
        }

        // 중앙노드 == 현재 범위의 top 노드 인덱스 확인
        int mid = start==end ? start : findMidIndex(start, end);


        // 일반 노드=1    더미 노드=0
        char currentNode = binaryNumber.charAt(mid);
        // 자식 노드에 일반 노드가 있는데 부모 노드가 더미 노드일 수는 없다.
        // 더미노드의 자식에는 더미노드만 있을 수 있다.
        if(isParentDummyNode && currentNode == '1') {
            return false;
        }

        // 부모 노드가 더미노드가 아니였으나 현재 내가 더미노드이면
        // 다음 자식노드로 넘어가기 전에 너의 부모는 더미 노드라고 알려줘야함
        if(!isParentDummyNode && currentNode == '0') {
            isParentDummyNode = true;
        }

        // 트리 왼쪽
        boolean leftPossible = checkNode(start, mid-1, binaryNumber, isParentDummyNode);
        // 트리 오른쪽
        boolean rightPossible = checkNode(mid+1, end, binaryNumber, isParentDummyNode);

        // 트리의 왼쪽 오른쪽 중 하나라도 불가하다면 불가 판정 -> false로 반환
        return leftPossible && rightPossible;
    }

    // 해당 범위의 중앙 값 찾는 메소드
    private int findMidIndex(int start, int end) {
        return start + ((end-start)/2);

    }

    // 십진수를 이진수로 변환해주는 메소드
    private String convertBinaryNumber(long num) {
        StringBuilder sb = new StringBuilder();

        while (num >= 1) {
            if(num == 1) {
                sb.append(1);
                break;
            }

            int n = num%2 == 0 ? 0 : 1;
            sb.append(n);

            num = num/2;
        }

        return sb.reverse().toString();
    }

    private String makePerfectBinaryTree(String binaryNumber) {
        return getZeroStringForPerfectBinaryTree(binaryNumber.length())+ binaryNumber;
    }

    private String getZeroStringForPerfectBinaryTree(int nodeCount) {
        int fillZeroCount=0;
        int b=1;
        while (true) {
            if (nodeCount <= Math.pow(2, b)-1) {
                fillZeroCount = (int) (Math.pow(2, b)-1 - nodeCount);
                break;
            }

            b++;
        }

        String fillZero = "0";
        return fillZero.repeat(fillZeroCount);
    }


    /*
        [7, 42, 5]	[1, 1, 0]
        [63, 111, 95]	[1, 1, 0]
     */
    public static void main(String[] args) {
        Lesson_150367 lesson = new Lesson_150367();

        long[] numbers = {7, 42, 5};
//        long[] numbers = {63, 111, 95};
        int[] result = lesson.solution(numbers);
        System.out.println(Arrays.toString(result));
    }
}
