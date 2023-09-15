import java.util.*;

class Solution {
  
  //1차 풀이 코드 : 테스트 코드 2,6,8,9,11,13,16 실패
  public int solutionFail(int[] priorities, int location) {
    int answer = 0;

    Map<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> queue = new LinkedList<>();

    for (int i=0; i< priorities.length; i++) {
      map.put(i, priorities[i]);
      queue.add(i);
    }

    while(!queue.isEmpty()) {

      int currentLocation = queue.peek();
      boolean isPriority = true;

      // 우선순위가 더 높은 숫자가 있는 경우
      for (int i=0; i<map.size(); i++) {
        if (currentLocation == i) {
          continue;
        }

        if (map.get(i) == null) {
          continue;
        }

        if (map.get(currentLocation) < map.get(i)) {
          isPriority = false;
          int num = queue.pop();
          queue.add(num);
          break;
        }
      }

      // 우선순위가 더 높은 숫자가 없는 경우
      if (isPriority) {
        int i = queue.pop();
        map.remove(i);
        answer++;
        // 우선순위를 찾는 녀석인 경우 로직 종료
        if (i == location) {
          return answer;
        }

      }
    }
    return answer;
  }

  // 2차 풀이 코드
  // PriorityQueue 활용
  public int solution(int[] priorities, int location) {
    int answer = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    for (int num : priorities) {
      queue.add(num);
    }

    while(!queue.isEmpty()) {

      for (int i=0; i<priorities.length; i++) {

        if (priorities[i] == queue.peek()) {
          if (i == location) {
            answer++;
            return answer;
          }
          answer++;
          queue.poll();
        }
      }
    }
    return answer;
  }
}