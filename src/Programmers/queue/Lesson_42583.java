package Programmers.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Lesson_42583 {

    /*
        result -> 모든 트럭이 다리를 지나려면 몇 초가 걸리는지 알고싶다.

        parameter
        bridge_length : 다리가 버틸 수 있는 최대 개수? 다리를 다 지나가는데 걸리는 시간
        weight : 다리가 버틸 수 있는 최대 무게
        truck_weights : 트럭

        ** 다리에 완전히 오르지 않은 트럭의 무게는 무시한다.

        질문
         - 트럭은 순서대로 접근해야만 하는가? o
         -
     */
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 선입선출 : 다리에 접근한 트럭 순서대로 다리에서 나올 수 있다.
        Queue<Truck> bridge = new LinkedList<>();

        int index = 0;
        int second = 0;
        int currentWeight = 0;
        while(index < truck_weights.length) {
            // > 더 이상 트럭이 올라갈 수 없는 상황
            //      - 현재 다리 위의 트럭 무게 합이 트럭이 버틸 수 있는 무게와 같거나 큰 경우
            //      - 다음 트럭의 무게가 올라갈 수 없는 경우
            if(currentWeight >= weight || weight < currentWeight+truck_weights[index]) {
                // 가장 앞에 있는 트럭을 빼서 해당 트럭이 나올 시간으로 시간 이동
                Truck truck = bridge.poll();
                second = truck.onBridgeTime + bridge_length;
                currentWeight -= truck.weight;

                if(weight >= currentWeight+truck_weights[index]) {
                    Truck newTruck = new Truck(truck_weights[index++], second);
                    bridge.offer(newTruck);
                    currentWeight += newTruck.weight;
                }
            }
            // 다음 트럭이 올라갈 수 있는 경우
            else {
                second++;

                if(!bridge.isEmpty() && bridge.peek().onBridgeTime+bridge_length == second) {
                    Truck truck = bridge.poll();
                    currentWeight -= truck.weight;
                }

                // 트럭을 만들어서 다리 위에 추가
                Truck newTruck = new Truck(truck_weights[index++], second);
                bridge.offer(newTruck);
                currentWeight += newTruck.weight;
            }
        }

        while (!bridge.isEmpty()) {
            second = bridge.poll().onBridgeTime + bridge_length;
        }

        return second;
    }


    /*
    2	10	[7,4,5,6]	8
    100	100	[10]	101
    100	100	[10,10,10,10,10,10,10,10,10,10]	110
    10, 12, [4,4,4,2,2,1,1,1,1]
     */
    public static void main(String[] args) {
        Lesson_42583 lesson = new Lesson_42583();

//        int bridgeLength = 2;
//        int weight = 10;
//        int[] trucks = {7,4,5,6};

//        int bridgeLength = 100;
//        int weight = 100;
//        int[] trucks = {10};
//        int[] trucks = {10,10,10,10,10,10,10,10,10,10};

        int bridgeLength = 10;
        int weight = 12;
        int[] trucks = {4,4,4,2,2,1,1,1,1};

        int result = lesson.solution(bridgeLength, weight, trucks);
        System.out.println(result);
    }

}

class Truck {
    int weight;
    int onBridgeTime;

    public Truck(int weight, int onBridgeTime) {
        this.weight = weight;
        this.onBridgeTime = onBridgeTime;
    }
}


/*
import java.util.*;

class Solution {
   public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<TruckStatus> queue = getTruckStatusQueueFromList(truck_weights);
        Queue<TruckStatus> onBridgeTruckQueue = new LinkedList<>();
        boolean isEnd = false;
        int time = 0;
        int currentWeight = 0;


        TruckStatus nextTruck = null;
        while(!isEnd) {
            ++time;

            if(!queue.isEmpty() && nextTruck == null) {
                    nextTruck = queue.poll();
            }

            if(nextTruck != null) {
                if (weight - (currentWeight + nextTruck.getWeight()) >= 0) {
                    onBridgeTruckQueue.add(nextTruck);
                    currentWeight = currentWeight + nextTruck.getWeight();
                    nextTruck = null;
                }
            }

            if(!onBridgeTruckQueue.isEmpty()){
                int arriveTruckCount = increaseStatusTimeAndGetArriveTruckCount(onBridgeTruckQueue, bridge_length);
                int arriveWeight = getMinusWeight(arriveTruckCount, onBridgeTruckQueue);

                currentWeight = currentWeight - arriveWeight;
            } else if(queue.isEmpty() && nextTruck==null){
                isEnd = true;
            }
        }

        return time;
    }

    private Queue<TruckStatus> getTruckStatusQueueFromList(int[] truckWeightList) {
        Queue<TruckStatus> queue = new LinkedList<>();

        for(int truckWeight : truckWeightList) {
            queue.add(new TruckStatus(truckWeight));
        }

        return queue;
    }

    private int increaseStatusTimeAndGetArriveTruckCount(Queue<TruckStatus> onBridgeTruckQueue, int bridgeLength) {
        int finishCount = 0;

        for(TruckStatus truckStatus : onBridgeTruckQueue) {
            truckStatus.increaseOnBridgeTime();
            if(truckStatus.getOnBridgeTime() == bridgeLength) {
                ++finishCount;
            }
        }

        return finishCount;
    }

    private int getMinusWeight(int arriveCount, Queue<TruckStatus> onBridgeTruckQueue) {
        int arriveWeight = 0;

        for(int i=0; i<arriveCount; i++) {
            TruckStatus finishTruckStatus = onBridgeTruckQueue.poll();
            arriveWeight = arriveWeight + finishTruckStatus.getWeight();
        }

        return arriveWeight;
    }


    class TruckStatus {
        private int weight;
        private int onBridgeTime;

        public TruckStatus(int weight) {
            this.weight = weight;
            this.onBridgeTime = 0;
        }

        public void setOnBridgeTime(int time) {
            this.onBridgeTime = time;
        }

        public int getWeight(){
            return weight;
        }

        public int getOnBridgeTime() {
            return onBridgeTime;
        }

        public void increaseOnBridgeTime() {
            onBridgeTime  = onBridgeTime + 1;
        }
    }
}
 */