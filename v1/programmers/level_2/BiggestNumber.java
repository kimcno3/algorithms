package v1.programmers.level_2;


import java.util.*;

//  가장 큰 수 : https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class BiggestNumber {

  public static void main(String[] args) {
    BiggestNumber biggestNumber = new BiggestNumber();
    System.out.println(biggestNumber.solution(new int[]{3, 30, 34, 5, 9}));
  }

  /*
   * 1차 풀이 코드 : 미완성
   * 3 과 30 처럼 위치가 바뀌어야 하는 경우를 구분하는 조건을 구현하지 못했다.

  public String solution(int[] numbers) {
    String answer = "";
    PriorityQueue<String> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int num : numbers) {
      priorityQueue.add(String.valueOf(num));
    }

    while (!priorityQueue.isEmpty()) {
      answer += priorityQueue.poll();
    }

    return answer;
  }
  */

  // 2차 풀이 코드 : 답안 코드 참고
  public String solution(int[] numbers) {

    String[] arr = new String[numbers.length];

    for (int i=0; i<arr.length; i++) {
      arr[i] = String.valueOf(numbers[i]);
    }

    // Comparator를 활용해본다.
    // 비교하는 두 값을 합쳐보고 더 큰 쪽으로 정렬되도록!
    Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));

    // 0이 중복으로 나오는 경우 -> {0,0,0} 처럼 답인 경우는 0이 나오도록 조건문 추가
    // {0,1} 처럼 배열이 정렬될 일은 없다. 즉, 0이 첫번째 값으로 나왔다면 그 뒤로 모두 0이라는 의미!
    if (arr[0].equals("0")) {
      return "0";
    }

    String answer = "";
    for (String str : arr) {
      answer += str;
    }

    return answer;

  }

}