package programmers.devMatching;

import java.util.*;

public class Solution3 {

  /* DP 미활용 코드
   *
   * Set 자료구조를 캐시 저장소로 활용해봤다면 시간 초과까지 해결해 볼 수 있지 않았을까..
   *
   */


  int m, n;
  long answer;
  int[] arr;
  Set<String> set;

  public long solution(int k) {
    answer = 0;

    // 인덱스 순으로 0~9까지 필요한 성냥개비 개수를 배열에 저장
    arr = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    // 만약 요구하는 k값이 8인 경우처럼, 1자리수로는 표현할 수 없는 성냥개비 수를 제외하기 위한 로직
    if (k%7 == 0) m = k/7;
    else m = k/7 + 1;

    n = k; // DFS 메소드에서 사용하기 위해 맴버변수로 다시 선언

    while(true) {
      set = new HashSet<>(); // DP 를 위한 별도의 저장소

      dfs(0, 0, "");

      // dfs를 돌았는데 추가된 값이 없다 -> 더 이상 자리수를 늘려도 나올 수 있는 경우의 수가 없다고 판단.
      if (set.isEmpty()) {
        break;
      }

      answer += set.size(); // 해당 자리수 값에서 추가된 Set의 길이를 answer에 추가

      m++; // 자리 수 증가

    }

    return answer;
  }

  // DFS 메소드
  void dfs(int depth, int sum, String str) {

    if (depth == m) {

      // 0으로 시작하면 제외(하지만 0은 포함)
      if (str.indexOf("0") == 0 && !str.equals("0")) {
        return;
      }

      // set에 이미 저장된 값은 미리 제외
      if (set.contains(str)) {
        return;
      }

      // 더한 값이 n과 같다면 set에 추가(Set은 중복값을 포함하지 않는다.)
      if (sum == n) {
        set.add(str);
      }
      return;
    }

    for (int i=0; i<arr.length; i++) {

      if (sum + arr[i] <= n) {
        dfs(depth + 1, sum + arr[i], str + String.valueOf(i));
      }

    }

  }

}

