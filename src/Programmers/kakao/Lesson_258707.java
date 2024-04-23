package Programmers.kakao;

// 게임은 아래와 같은 경우에 종료됩니다.
// 1. 카드 뭉치에 카드가 없는 경우
// 2. 더 이상 n+1의 값으로 낼 수 있는 카드가 없는 경우

/*
    1. 제출해야 할 수 `n+1` 값을 변수에 저장
    2. `n+1` 개의 원소가 들어갈 수 있는 배열 생성
        1. 해당 숫자 카드의 상태를 나타내는 배열이다.
        2. 카드 뭉치에 있으면 0 / 내 손에 있으면 1 / keep 2 / 제출 했으면 3
    3. 처음 받은 카드를 상태 배열에 체크한다.
    4. 새로 뽑은 두 카드 keep.
    5. 짝을 맞춰서 있으면 제출
        5-1. 내 손에 있는 카드 중에 카드 짝이 맞는지 확인 후 제출
        5-2. coin이 1개 이상 남아있는지 확인
            5-2-1. 내 손에 있는 카드와 keep 해놓은 카드 중 짝이 맞는지 확인 후 제출 (coin 1개 사용)
            5-2-2. keep 해놓은 카드 중 짝이 맞는지 확인 후 제출 (coin 2개 사용)
    6. 만약 제출을 하지 못했다면 게임 종료 / 제출했다면 4번 반복
 */

/*
    2024 KAKAO WINTER INTERNSHIP
    n + 1 카드게임
    https://school.programmers.co.kr/learn/challenges?order=recent&partIds=37527%2C58464
 */
public class Lesson_258707 {

    int[] checkArr;
    int submitNumber;
    int currentCoin;

    public int solution(int coin, int[] cards) {
        checkArr = new int[cards.length+1];
        submitNumber = cards.length+1;
        currentCoin = coin;
        for(int i=0; i<cards.length/3; i++) {
            checkArr[cards[i]] = 1;
        }

        // 1라운드부터 시작
        int round = 1;
        // 한 라운드당 카드를 두장씩 뒤집어야 한다.
        // 처음 1/3장은 가져갔으니 그 다음카드부터 뒤집는다.
        for(int i=cards.length/3; i<cards.length; i+=2) {
            // 이번 라운드에 뒤집을 카드 두장 확인 후 keep
            checkArr[cards[i]] = 2;
            checkArr[cards[i+1]] = 2;

            boolean isSubmit = false;
            // 내가 가지고 있는 카드 중에서 제출할 수 있는지 확인 후 제출
            // 내 손에서 제출했으면 다음 라운드로 넘어감
            if(submitOnMyCards()) {
                isSubmit = true;
            }
            // 손에 코인이 있는지 확인
            else if(currentCoin > 0) {
                // 손에 있는 카드 한장 / keep해둔 카드 한장 중 제출할 수 있다면 => coin 1개를 이용하여 제출
                // 코인이 2개 이상 있는지 확인 && keep 해 둔 카드 중에서 제출할 수 있다면 => coin 2개를 사용하여 제출
                // 제출했다면 다음 라운드 진행
                if(submitOnMyCardsAndKeepCards() || (currentCoin>=2 && submitOnKeepCards())) {
                    isSubmit = true;
                }
            }

            if(isSubmit) {
                // 다음 라운드 진출
                round++;
            }
            // 제출하지 못했다면 게임 종료
            else {
                break;
            }
        }

        return round;
    }

    private boolean submitOnMyCards() {
        for(int j=1; j<=checkArr.length/2; j++) {
            int card1 = checkArr[j];
            int card2 = checkArr[submitNumber-j];

            if(card1 == 1 && card2 == 1) {
                checkArr[j] = 3;
                checkArr[submitNumber-j] = 3;
                return true;
            }
        }

        return false;
    }

    private boolean submitOnMyCardsAndKeepCards() {
        for(int j=1; j<=checkArr.length/2; j++) {
            int card1 = checkArr[j];
            int card2 = checkArr[submitNumber-j];

            if((card1 == 1 && card2 == 2) || (card2==1 && card1==2)) {
                checkArr[j] = 3;
                checkArr[submitNumber-j] = 3;
                currentCoin--;
                return true;
            }
        }

        return false;
    }

    private boolean submitOnKeepCards() {
        for(int j=1; j<=checkArr.length/2; j++) {
            int card1 = checkArr[j];
            int card2 = checkArr[submitNumber-j];

            if(card1 == 2 && card2 == 2) {
                checkArr[j] = 3;
                checkArr[submitNumber-j] = 3;
                currentCoin -= 2;
                return true;
            }
        }

        return false;
    }





    /*
        4	{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}	5
        3	{1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12}	2
        2	{5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7}	4
        10	{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18} 1
     */
    public static void main(String[] args) {
//        int coin = 4;
        int coin = 3;
//        int coin = 2;
//        int coin = 4;
//        int[] cards = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        int[] cards = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11, 12};
//        int[] cards = {5, 8, 1, 2, 9, 4, 12, 11, 3, 10, 6, 7};
//        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

        Lesson_258707 lesson = new Lesson_258707();
        int result = lesson.solution(coin, cards);
        System.out.println("result = " + result);
    }
}

/*
 public int solution(int coin, int[] cards) {
        // 카드 상태 저장 배열
        int[] myCards = new int[cards.length+1];
        // 두 카드의 합이 나와야 할 값
        int sum = cards.length+1;
        // 처음에 전체카드의 1/3을 가지고 시작한다.
        for(int i=0; i<cards.length/3; i++) {
            myCards[cards[i]] = 1;
        }

        // 1라운드부터 시작
        int round = 1;
        // 한 라운드당 카드를 두장씩 뒤집어야 한다.
        // 처음 1/3장은 가져갔으니 그 다음카드부터 뒤집는다.
        for(int i=cards.length/3; i<cards.length; i=i+2) {
            // 카드 제출 여부 확인 변수
            boolean isSubmit = false;
            // 내가 가지고 있는 카드 중에서 제출할 수 있는지 확인 후 제출
            for(int j=1; j<=myCards.length/2; j++) {
                int card1 = myCards[j];
                int card2 = myCards[sum-j];

                if(card1 == 1 && card2 == 1) {
                    myCards[j] = 3;
                    myCards[sum-j] = 3;
                    isSubmit = true;
                    round++;
                    break;
                }
            }

            // 이번 라운드에 뒤집을 카드 두장 확인 후 keep
            myCards[cards[i]] = 2;
            myCards[cards[i+1]] = 2;

            // 내 손에서 제출했으면 다음 라운드로 넘어감
            if(isSubmit) {
                continue;
            }

            // 제출하지 못했으나 카드를 가져올 수 있는 코인이 없다면 게임 종료
            if(coin <= 0) {
                break;
            }

            // 손에 있는 카드 한장 / keep해둔 카드 한장 중 제출할 수 있다면
            // coin 1개를 이용하여 제출
            for(int j=1; j<=myCards.length/2; j++) {
                int card1 = myCards[j];
                int card2 = myCards[sum-j];

                if((card1 == 1 && card2 == 2) || (card2==1 && card1==2)) {
                    myCards[j] = 3;
                    myCards[sum-j] = 3;
                    coin--;
                    isSubmit = true;
                    round++;
                    break;
                }
            }

            // 제출했다면 다음 라운드 진행
            if(isSubmit) {
                continue;
            }

            // 코인이 2개 이상 있는지 확인
            if(coin>=2) {
                // keep 해 둔 카드 중에서 제출할 수 있다면 coin 두개를 사용하여 제출
                for(int j=1; j<=myCards.length/2; j++) {
                    int card1 = myCards[j];
                    int card2 = myCards[sum-j];

                    if(card1 == 2 && card2 == 2) {
                        myCards[j] = 3;
                        myCards[sum-j] = 3;
                        coin = coin-2;
                        isSubmit = true;
                        round++;
                        break;
                    }
                }
            }

            // 끝까지 제출하지 못했다면 게임 종료
            if(!isSubmit) {
                break;
            }
        }

        return round;
    }
 */