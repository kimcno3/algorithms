package v1.programmers.level_2;

import java.util.Arrays;
import java.util.Comparator;

// 구명보트 : https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class LifeBoat {

  /* 성공 코드
   *
   * 가장 많은 몸무게의 사람과 가장 가벼운 사람을 함께 태워 구조하면 된다.
   * max -> <- min 으로 동작하도록
   * max + min1 + ... 이 limit를 넘을 때까지!!
   * 구출할 수 있다면 answer만 +하고 다음 인덱스로 넘어가기만 하면 된다.
   * 오름차순으로 정렬할 필요 없이 뒤에서 부터 조회하면 그게 오름차순!
   * 보트는 한번에 두명씩 밖에 못탄다!!!(문제 제대로 읽자...)
   */

  public int solution(int[] people, int limit) {
    int answer = 0;
    int minIdx = 0;
    Arrays.sort(people);

    for (int maxIdx = people.length - 1; maxIdx>=0; maxIdx--) {

      // 인덱스가 서로 지나친 경우 -> 모든 사람을 구출한 경우이므로 루프를 종료한다.
      if (minIdx > maxIdx) {
        break;
      }

      // 두 인덱스가 같은 경우 -> 한명만 남은 경우이므로 구출하고 루프를 종료한다.
      if (maxIdx == minIdx) {
        answer++;
        break;
      }

      // 같이 태울 수 있을 때 -> 다음 최소값 인덱스로 옮긴다.
      if (people[maxIdx] + people[minIdx] <= limit) {
        minIdx += 1;
      }

      // 구출 횟수 추가
      answer++;

    }


    return answer;
  }

  /*
   * 실패 코드
   *
   * 몸무게가 무거운 순서대로 정렬
   * 사람 한명의 몸무게가 가장 최대 몸무게 1/2 이상일 경우 가벼운 사람의 몸무게 합이 limit 와 같다면(?) 같이 태워서 구조한다.
   * -> 여러모로 에러가 많은 생각
   * visits[]로 중복 조회를 방지한다
   * 오름차순 정렬을 위해 굳이 Integer[]로 다시 선언한다.
   */

  public int solutionFail(int[] people, int limit) {
    int answer = 0;
    int sum = limit;

    Integer[] arr = new Integer[people.length];
    boolean[] visits = new boolean[arr.length];

    for (int i=0; i< arr.length; i++) {
      arr[i] = people[i];
    }

    // 오름차순 정렬
    Arrays.sort(arr, Comparator.reverseOrder());

    for (int i=0; i<arr.length; i++) {

      // 아직 구조되지 않은 사람인 경우
      if (!visits[i]) {

        visits[i] = true; // 보트에 태운다.
        sum -= arr[i]; // 남은 무게 수를 체크한다.

        // 만약 남은 무게가 보트의 반 이하일 경우
        if (sum <= limit / 2) {

          // 가벼운 사람부터 체크한다.
          for (int j=arr.length-1; j>=0; j--) {

            if (!visits[j] && (sum - arr[j]) >= 0) { // 아직 구조되지 않았고, 남은 무게수와 딱 맞는 사람일 경우
              visits[j] = true; // 보트에 태운다.
              sum = limit; // 무게는 초기화한다.
              break;
            }

          }

        }
        sum = limit;
        answer++;
      }

    }
    return answer;
  }


}
