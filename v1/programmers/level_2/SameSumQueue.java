package v1.programmers.level_2;

import java.util.*;

// 두 큐 합 같게 만들기 : https://school.programmers.co.kr/learn/courses/30/lessons/118667
public class SameSumQueue {

  /*
   * 지문의 설명에선 다른 큐에 넘어갈 값을 한번에 넘긴다고 하지만 값을 하나씩 넘기고 카운트하는거랑 다를 것이 없다.
   *
   * 풀이 방법
     1. 대신 두 큐의 총합 중, 큰 합계의 큐에서 작은 합계의 큐로 값을 넘기고
     2. 두 합이 같아질 때 해당 카운트로 리턴
     3. 만약 두 합이 같아질 수 없는 기준 -> 두 큐의 길이 합 * 3 (이유는 아직 이해 불가..)
   */

  public int solution(int[] queue1, int[] queue2) {
    int answer = 0;

    long sum1 = 0;
    long sum2 = 0;

    LinkedList<Long> q1 = new LinkedList<>();
    LinkedList<Long> q2 = new LinkedList<>();

    // 큐에 값을 추가 및 두 큐 각 합을 계산
    for (int i=0; i<queue1.length; i++) {
      sum1 += queue1[i];
      sum2 += queue2[i];

      q1.add((long) queue1[i]);
      q2.add((long) queue2[i]);
    }

    // 루프 실행
    while(true) {

      // 두 큐의 합이 같아진 경우 루프 종료
      if (sum1 == sum2) {
        break;
      }

      // sum1이 sum2보다 큰 경우
      else if (sum1 > sum2) {
        // q1에서 값을 빼오고 sum1에서 감소
        long val = q1.removeFirst();
        sum1 -= val;

        // q2에 값을 추가하고 sum2에서 증가
        q2.add(val);
        sum2 += val;

        // answer 추가
        answer++;
      }

      // sum2이 sum1보다 큰 경우
      else {
        // q2에서 값을 빼오고 sum2에서 감소
        long val = q2.removeFirst();
        sum2 -= val;

        // q1에 값을 추가하고 sum1에서 증가
        q1.add(val);
        sum1 += val;

        // answer 추가
        answer++;
      }

      // answer 값이 두 큐의 길이의 합 * 3만큼 증가했을 경우 -> 두 큐의 값은 같아질 수 없다고 판단
      if (answer > (queue1.length + queue2.length) * 3) {
        answer = -1;
        break;
      }

    }

    return answer;
  }



}
