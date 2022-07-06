package Programmers.Array;

import java.sql.SQLException;
import java.util.*;

public class lesson_42746 {

    Map<Integer, List<String>> numberMap = new HashMap<>();

    public static void main(String[] args) {
        int[] test = {3, 30, 34, 5, 9, 959, 998, 345, 342,200, 202, 500, 434};
        int[] test2 = {3, 30, 34, 5, 9, 0, 0};

        int[] test3 = {0, 0, 0};

        lesson_42746 le = new lesson_42746();
        String result = le.solution(test2);
        System.out.println(result);


//        System.out.println("Result=" +  result + "    " + result.length() + "    " + result.charAt(result.length()-1));
    }

//    public String solution(int[] numbers) {
//        combinationList = new ArrayList<>();
//        int[] result = new int[numbers.length];
//        reculsion(numbers,0, numbers.length);
//
//        for(String s : combinationList) {
//            System.out.println(s);
//        }
//        Collections.sort(combinationList, Collections.reverseOrder());
//
//        return combinationList.get(0);
//    }
//
//    public void reculsion(int[] arr, int depth, int last) {
//        if(depth == last) {
//            System.out.println("result: " + Arrays.toString(arr));
//            String resultString = getStringAllArrayValue(arr);
//            combinationList.add(resultString);
//            return;
//        }
//
//        for(int i = depth; i < arr.length; i++) {
//            swap(arr, depth, i);
//            reculsion(arr, depth + 1, last);
//            swap(arr, depth, i);
//        }
//
//    }
//
//    private void swap(int[] arr, int depth, int i){
//        int temp = arr[depth];
//        arr[depth] = arr[i];
//        arr[i] = temp;
//    }
//
//    public String getStringAllArrayValue(int[] arr) {
//        String result = "";
//
//        for(int i=0; i<arr.length; i++){
//            result += arr[i];
//        }
//
//        return result;
//    }



//    public int[] getArrayWithoutIndex(int[] arr, int index) {
//        System.out.println("Before: " + Arrays.toString(arr));
//
//        int[] newArr = new int[arr.length-1];
//        int newIndex = 0;
//
//        for(int i = 0; i < arr.length-1; i++) {
//            if(i < index){
//                newArr[newIndex] = arr[i];
//            } else {
//                newArr[newIndex] = arr[i+1];
//            }
//            ++newIndex;
//        }
//
//        System.out.println("After: " + Arrays.toString(newArr));
//
//        return newArr;
//    }

    public String solution(int[] numbers) {
        if(numbers[0] == 0 && isZeroArray(numbers)){
            return "0";
        }

        setNumberMap(numbers);
        return mergeResult();
    }

    private void setNumberMap(int[] numbers) {
        for(int number : numbers) {
            String numberString = String.valueOf(number);
            int startNumber = Integer.parseInt(numberString.substring(0,1));

            List<String> numberList = numberMap.getOrDefault(startNumber, new ArrayList<>());

            if (numberList.size() == 0) {
                numberList.add(numberString);
                numberMap.put(startNumber, numberList);
            } else {
                insertAndSortNumberList(numberList, startNumber, numberString);
            }
        }
    }

    private void insertAndSortNumberList(List<String> numberList, int startNumber, String number){
        for(int i=0; i< numberList.size(); i++) {
            if(!isBiggerThanNewNumber(numberList.get(i), number)){
                numberList.add(i, number);
                numberMap.put(startNumber, numberList);
                return;
            }
        }

        numberList.add(number);
        numberMap.put(startNumber, numberList);
    }

    


    private String mergeResult(){
        String result = "";

        for(int i=9; i>=0; i--) {
            if(numberMap.containsKey(i)){
               String numberListString = numberMap.get(i).toString();
                result += numberListString.replaceAll("[^0-9]","");
            }

        }

        return result;
    }

    private boolean isZeroArray(int[] numbers) {
        long sum = Arrays.stream(numbers).sum();

        return sum == 0;
    }

    private boolean isBiggerThanNewNumber(String number, String newNumber) {
        String mergeNumber1 = number + newNumber;
        String mergeNumber2 = newNumber + number;

        return mergeNumber1.compareTo(mergeNumber2) > 0;
    }

//    private String getBiggestNumber(int[] numbers) {
////        String[] stringArray = intArrayToStringArray(numbers);
//        List<String> stringList = new ArrayList<>();
//
//        for(int i=0; i<numbers.length; i++){
//            sortAndInsertNumber(stringList, String.valueOf(numbers[i]));
//        }
//
//        String result = "";
//        for(String number : stringList){
//            String addNumber = number + " ";
//            result += addNumber;
//        }
//
//        return result;
//    }
//
////    private String[] intArrayToStringArray(int[] intArray) {
////        String[] stringArray = new String[intArray.length];
////
////        for(int i=0; i<intArray.length; i++){
////            stringArray[i] = String.valueOf(intArray[i]);
////        }
////
////        return stringArray;
////    }
//
//    private void sortAndInsertNumber(List<String> numberList, String newNumber) {
//        int insertIndex = numberList.size();
//
//        for (int i =0; i < numberList.size(); i++) {
//            if(!isBiggerThanNewNumber(numberList.get(i), newNumber)) {
//                insertIndex = i;
//                break;
//            }
//        }
//
//        if(insertIndex == numberList.size()) {
//            numberList.add(newNumber);
//        } else {
//            numberList.add(insertIndex, newNumber);
//        }
//    }
//
//    private boolean isBiggerThanNewNumber(String number, String newNumber) {
//       String number1 = number + newNumber;
//       String number2 = newNumber + number;
//
//        return number1.compareTo(number2) > 0 ? true : false;
//    }


//    private String quickSort(int[] numbers) {
//        String  result = "";
//
//        int left = 0;
//        int right;
//        int last = numbers.length-1;
//
//        int leftNum;
//
//        while(left < numbers.length-1){
//            leftNum = numbers[left];
//            right = last;
//
//            while(right > left) {
//                int rightNum = numbers[right];
//
//                if (isBiggerThanNewNumber(rightNum, leftNum)) {
//                    System.out.println("change right="+ rightNum +"  left=" + leftNum);
//                    numbers[right] = leftNum;
//                    numbers[left] = rightNum;
//
//                    leftNum = rightNum;
//                }
//
//                right--;
//            }
//
//
//            if(leftNum != 0){
//                System.out.println("Add for result. number="+ leftNum  + "  result=" + result);
//                result += leftNum;
//            }
//
//            left++;
//        }
//
//        result += numbers[numbers.length-1];
//
//        return result;
//    }

//    public String getStringAllArrayValue(int[] arr) {
//        String result = "";
//
//        for(int i=0; i<arr.length; i++){
//            result += arr[i];
//        }
//
//        return result;
//    }

}