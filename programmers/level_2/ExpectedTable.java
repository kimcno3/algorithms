package programmers.level_2;

import java.util.*;

// 예상 대진표 : https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class ExpectedTable {

  /*
   * 정답 코드
   *
   * 구현 방법
     * 큐로 직접 조회해보지 않고 규칙을 찾아서 구현
     * 라운드 별 홀수, 짝수에 따른 다음 대진표를 계산하고  대진이 같은 경우 해당 라운드를 리턴
   */

  public int solution(int n, int a, int b) {

    int answer = 0;
    int round = 0;

    while (round < Math.getExponent(n)) {

      round++;

      if (a % 2 == 0) {
        a = a / 2;
      } else {
        a = a / 2 + 1;
      }

      if (b % 2 == 0) {
        b = b / 2;
      } else {
        b = b / 2 + 1;
      }

      // 같은 라운드에 묶였을 때
      if (a == b) {
        answer = round;
        break;
      }

    }

    return answer;

  }

  /*
   * 실패 코드(시간초과가 발생)
   *
   * 실패 원인
     * 큐의 크기가 커질 경우 O(n^2) 만큼 시간복잡도가 발생
     * 또한 큐가 비어 있을 경우에 대한 대책도 생각해야 하는 단점이 존재
   */

  public int solutionFail(int n, int a, int b) {

    Queue<Integer> q = new LinkedList<>();

    for (int  i=1; i<=n; i++) {
      q.add(i);
    }

    int round = 1;

    return method(q, n, a, b, round);

  }

  int method(Queue<Integer> q, int n, int a, int b, int round) {

    int game = n;

    while(true) {

      game = game / 2;

      for (int i=0; i<game; i++) {

        int p1 = q.poll();
        int p2 = q.poll();

        if (p1 == a && p2 == b) {
          return round;
        }

        else if (p1 == a || p1 == b) {
          q.add(p1);
        }

        else if (p2 == a || p2 == b) {
          q.add(p2);
        }

        else {
          q.add(p1);
        }

      }

      round++;

    }
  }


}
