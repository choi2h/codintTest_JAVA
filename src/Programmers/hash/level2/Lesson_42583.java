package Programmers.hash.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Lesson_42583 {

    static class Truck {
        int weight;
        int outTime;

        public Truck(int weight, int outTime) {
            this.weight = weight;
            this.outTime = outTime;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        int time = 1;
        int index = 0;
        int currentWeight = 0;

        while (index < truck_weights.length) {
            if(!bridge.isEmpty() && (bridge.size() >= bridge_length || currentWeight + truck_weights[index] > weight)) {
                Truck truck = bridge.remove();
                time = Math.max(truck.outTime, time);
                currentWeight -= truck.weight;
            } else {
                bridge.add(new Truck(truck_weights[index], time+bridge_length));
                currentWeight += truck_weights[index++];
                time++;
            }
        }

        while (!bridge.isEmpty()) {
            time = Math.max(bridge.poll().outTime, time);
        }

        return time;
    }

    public static void main(String[] args) {
        Lesson_42583 lesson = new Lesson_42583();
//        int result = lesson.solution(2, 10, new int[]{7,4,5,6});
        int result = lesson.solution(100, 100, new int[]{10});
        System.out.println(result);
    }
}



/*
import java.util.LinkedList;
import java.util.Queue;

class Solution {
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
                // 트럭을 만들어서 다리 위에 추가
                second++;

                if(!bridge.isEmpty() && bridge.peek().onBridgeTime+bridge_length == second) {
                    Truck truck = bridge.poll();
                    currentWeight -= truck.weight;
                }

                Truck truck = new Truck(truck_weights[index++], second);
                bridge.offer(truck);
                currentWeight += truck.weight;
            }
        }

        while (!bridge.isEmpty()) {
            second = bridge.poll().onBridgeTime + bridge_length;
        }

        return second;
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
 */