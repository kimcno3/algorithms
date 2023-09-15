import java.util.*;

class Solution {
  // 1차 작성 코드(정확성 테스트: 66점, 효율성 테스트: 0점)
  public boolean solutionFail(String[] phone_book) {
    boolean answer = true;

    Set<String> set = new HashSet<>();

    set.addAll(Arrays.asList(phone_book));

    for (String prefix : phone_book) {

      boolean bool = set.stream()
          .anyMatch((str) -> !str.equals(prefix) && str.contains(prefix));

      if (bool)
        answer = false;

    }
    return answer;
  }

  // 해설 블로그 : https://bada744.tistory.com/96
  // 내가 놓친 부분 : 접두어란 항상 맨 앞에 존재하는 문자라는 것!! 문자열들의 앞부분 중에 같은 문자열이 존재하는지만 판단하면 된다.

  // 2차 작성 코드(테스트 전부 통과)
  public boolean solution(String[] phone_book) {

    Set<String> set = new HashSet<>();
    set.addAll(Arrays.asList(phone_book));

    for (String number : phone_book) {

      // 특정 문자열 첫 문자열부터 순차적으로 늘려가면서 다른 문자열 중에 존재하는지 그 포함여부를 판단한다.(subString() 활용)
      for (int j = 0; j < number.length(); j++) {

        // 포함이 되었을 경우 그대로 false를 리턴하며 메소드 종료
        if (set.contains(number.substring(0, j))) {
          return false;
        }

      }

    }
    return true;
  }
}