package programmers.level_1;

import java.util.*;


// 같은 숫자는 싫어 : https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class HateSameNumber {

/*
 * 큐 활용 문제
 * 가장 마지막 숫자와 저장할 숫자가 같지 않은 경우에만 큐에 add
 * int 타입 배열에 큐의 앞에서 부터 removeFirst
 */

public int[] solution(int []arr) {

    LinkedList<Integer> queue = new LinkedList<>();

    if (arr.length == 0) {
      return new int[0];
    }

    // 첫번째 값은 우선 stack에 저장
    queue.add(arr[0]);

    for (int i=1; i<arr.length; i++) {

      // 큐의 마지막 숫자와 저장할 숫자가 같지 않은 경우에만 저장
      if (queue.getLast() != arr[i]) {
        queue.add(arr[i]);
      }

    }

    int[] answer = new int[queue.size()];

    for (int i=0; i<answer.length; i++) {

      answer[i] = queue.removeFirst();

    }

    return answer;
  }
}
