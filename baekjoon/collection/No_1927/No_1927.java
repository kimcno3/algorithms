package baekjoon.collection.No_1927;

import java.util.*;

public class No_1927 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();

    List<Integer> heap = new ArrayList<>();

    for (int loop=0; loop<length; loop++) {
      // 현재 숫자
      Integer num = sc.nextInt();

      // 1. 힙이 비어있을 경우
      if (heap.size() == 1) {
        if (num == 0) {
          System.out.println(0);
        } else {
          heap.add(num);
        }
        continue;
      }

      // 2. 힙에 숫자를 추가하는 경우
      if (num != 0) {
        // 마지막열에 추가
        heap.add(num);
        // 최소값 정렬 -> 비교는 부모노드만 -> 부모노드보다 작은 값이면 교환
        while (num < heap.get(heap.lastIndexOf(num) / 2)) {
          Integer parentNode = heap.get(heap.lastIndexOf(num) / 2);
          heap.set(heap.lastIndexOf(num) / 2, num);
          heap.set(heap.get(heap.lastIndexOf(num)), parentNode);
        }
      }

      // 3. 최소값을 출력해야 하는 경우
      if (num == 0) {
          // 최소값 제거 및 출력 -> 인덱스 0번 값을 출력
          System.out.println(heap.get(0));
          // 가장 마지막에 있는 값(최대값)을 0번으로
          heap.set(1, heap.get(heap.size()-1));
          heap.remove(heap.size()-1);
          // 최소값 정렬 진행
          Integer maxNum = heap.get(0);
          while (heap.indexOf(maxNum)*2-1 < heap.size() && maxNum > heap.get(heap.indexOf(maxNum)*2-1)) {
              Integer childNode = heap.get(heap.indexOf(maxNum)*2-1);
              heap.set(heap.indexOf(maxNum)*2-1, maxNum);
              heap.set(heap.get(heap.indexOf(maxNum)), childNode);
          }
      }

      // 테스트 코드 -> 힙을 순서대로 출력
      for (int i=0; i<heap.size(); i++) {
        System.out.print(heap.get(i) + " ");
      }
      System.out.println(heap.size());
    }
  }
}