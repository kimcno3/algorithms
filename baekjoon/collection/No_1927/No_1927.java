package baekjoon.collection.No_1927;

import java.util.*;

public class No_1927 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    // 최고값이 우선순위인 PriorityQueue 생성
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    // 반복문 횟수와 현재 숫자를 담을 변수 선언
    int length = sc.nextInt();
    Integer num;
    // 반복문 실행
    for (int i=0; i<length; i++) {
      // 현재 숫자
      num = sc.nextInt();
      // 0이 아닐 경우 -> heap에 값 추가
      if (num != 0) {
        heap.offer(num);
      }
      // 0일 경우 -> 최소값 출력 및 제거
      else {
        // heap이 비어있는 경우 -> 0 출력
        if (heap.size() == 0) {
          System.out.println(0);
        }
        // 값이 존재하는 경우 -> 최소값 출력 및 제거
        else {
          System.out.println(heap.poll());
        }
      }
    }
  }
}