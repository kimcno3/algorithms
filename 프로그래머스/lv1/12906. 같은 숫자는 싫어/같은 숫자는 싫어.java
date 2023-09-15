import java.util.*;

public class Solution {

  public int[] solution(int []arr) {

    /*
     * 스택을 이용
     * peek() == num X
     */

    LinkedList<Integer> list = new LinkedList<>();

    if (arr.length == 0) {
      return new int[0];
    }

    // 첫번째 값은 우선 stack에 저장
    list.add(arr[0]);

    for (int i=1; i<arr.length; i++) {

      if (list.getLast() != arr[i]) {
        list.add(arr[i]);
      }

    }

    int[] answer = new int[list.size()];
    
    for (int i=0; i<answer.length; i++) {
      answer[i] = list.removeFirst();
    }

    return answer;
  }
}