package Programmers.recursion.level2;
/*
쿼드압축 후 개수 세기
URL : https://school.programmers.co.kr/tryouts/71862/challenges


테스트 1 〉	통과 (0.35ms, 71.9MB)
테스트 2 〉	통과 (0.22ms, 77MB)
테스트 3 〉	통과 (0.10ms, 79.1MB)
테스트 4 〉	통과 (0.06ms, 72.2MB)
테스트 5 〉	통과 (16.56ms, 101MB)
테스트 6 〉	통과 (8.33ms, 89.9MB)
테스트 7 〉	통과 (9.95ms, 95.4MB)
테스트 8 〉	통과 (8.52ms, 90.1MB)
테스트 9 〉	통과 (6.70ms, 98.7MB)
테스트 10 〉	통과 (4.18ms, 114MB)
테스트 11 〉	통과 (0.05ms, 79.8MB)
테스트 12 〉	통과 (0.04ms, 77.5MB)
테스트 13 〉	통과 (5.69ms, 94MB)
테스트 14 〉	통과 (11.06ms, 115MB)
테스트 15 〉	통과 (17.22ms, 146MB)
테스트 16 〉	통과 (8.48ms, 96.2MB)
 */
public class Lesson_71862 {

    // 결과값을 담을 배열 생성
    // arr[0] : 0의 개수  arr[1] : 1의 개수
    private int[] answer = new int[2];

    /*
    1 1  0 0
    1 0  0 0

    1 0  0 1
    1 1  1 1


    1 1  1 1  1 1  1 1
    0 1  1 1  1 1  1 1

    0 0  0 0  1 1  1 1
    0 1  0 0  1 1  1 1

    0 0  0 0  0 0  1 1
    0 0  0 0  0 0  0 1

    0 0  0 0  1 0  0 1
    0 0  0 0  1 1  1 1
     */
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        Lesson_71862 lesson = new Lesson_71862();
        int[] result = lesson.solution(arr);

        for(int i =0; i<result.length; i++) {
            System.out.println(i + " : " + result[i]);
        }

    }

    public int[] solution(int[][] arr) {
        int start = 0;
        int end = arr.length-1;

        find(arr, start, end, start, end);

        return answer;
    }

    // 재귀 함수
    private void find(int[][] arr, int cStart, int cEnd, int rStart, int rEnd) {
        System.out.println("start=" + cStart + "end=" + cEnd + "start=" + rStart + "end=" + rEnd);

        // 범위에 해당하는 0의 개수 가져옴
        int zeroCount = getZeroCount(arr, cStart, cEnd, rStart, rEnd);

        // 행의 개수 (정사각형 한 변의 개수)
        int cCount = cEnd-cStart+1;
        // 범위 내의 총 숫자 개수 (정사각형 크기)
        int totalCount = cCount * cCount;
        // 전부 1이거나 / 전부 0이거나  / 총 크기가 더 이상 나눌 수 없는 4일 때
        if(zeroCount== 0 || totalCount == zeroCount || totalCount == 4) {
            // 전역변수 결과 배열에 0과 1의 숫자 합함
            plusZeroAndOneCountToAnswer(zeroCount, totalCount);
        } else {
            // 현재 확인한 정사각형을 4등분하기 위해 행과 열 중간 값 구함
            int cHaf = (cStart + cEnd)/2;
            int rHaf = (rStart + rEnd)/2;

            // 4등분한 정사각형의 왼쪽 위 정사각형 재귀
            find(arr, cStart, cHaf, rStart, rHaf);
            // 4등분한 정사각형의 왼쪽 아래 정사각형 재귀
            find(arr, cStart, cHaf, rHaf+1, rEnd);
            // 4등분한 정사각형의 오른쪽 위 정사각형 재귀
            find(arr, cHaf+1, cEnd, rStart, rHaf);
            // 4등분한 정사각형의 오른쪽 아래 정사각형 재귀
            find(arr, cHaf+1, cEnd, rHaf+1, rEnd);
        }
    }

    private void plusZeroAndOneCountToAnswer(int zeroCount, int totalCount) {
        //전부 1이면 1의 개수 1 증가
        if(zeroCount == 0) {
            answer[1] = answer[1] + 1;
        }
        // 전부 0이면 0의개수 1 증가
        else if(zeroCount == totalCount) {
            answer[0] = answer[0] + 1;
        }
        // 모두 통일되는 숫자가 아닐때는 각각의 개수만큼 0과 1 증가
        else {
            answer[0] = answer[0] + zeroCount;
            answer[1] = answer[1] + totalCount-zeroCount;
        }

        System.out.println("count : 0(" + answer[0] + ") 1(" + answer[1] + ")" );
    }

    private int getZeroCount(int[][] arr, int cStart, int cEnd, int rStart, int rEnd) {
        int zeroCount = 0;

        // i(가로) j(세로) 전부 순회하며 0의 개수 구함
        for(int i = cStart; i <= cEnd; i++) {
            for(int j = rStart; j <= rEnd; j++) {
                int num = arr[i][j];
                System.out.println("arr ["  + i + "][" + j + "] = " + num);

                if (num == 0) {
                    zeroCount++;
                }
            }
        }

        System.out.println("zeroCount="  + zeroCount);
        return zeroCount;
    }
}
