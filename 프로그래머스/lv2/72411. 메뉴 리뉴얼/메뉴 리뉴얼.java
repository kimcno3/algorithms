import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제점 : 굳이 재귀식에서 visits를 사용할 필요가 없었다. 이 부분에서 많은 실패가 발생 -> 이전 인덱스를 거치지 않는다면 visit를 사용할 필요가 없다.
 */

class Solution {
  private static Map<String, Integer> map;
  private static Set<String> set;

  public String[] solution(String[] orders, int[] course) {
    // 1. 손님 별 단품 메뉴를 오름차순으로 정렬
    for (int i=0; i<orders.length; i++) {
      StringBuilder sb = new StringBuilder();
      Arrays.stream(orders[i].split(""))
              .sorted()
              .forEach(sb::append);
      orders[i] = sb.toString();
    }
    // 2. 새로 추가할 코스 요리 메뉴 구성을 저장한 TreeSet 생성(오름차순)
    set = new TreeSet<>(Comparator.naturalOrder());
    // 3. 코스 개수별로 루프
    for (int menuCount : course) {
      // 4. 코스 개수 별 가능한 모든 메뉴 구성과 중복 횟수를 저장항 TreeMap 생성(key 기준 오름차순)
      map = new TreeMap<>(Comparator.naturalOrder());
      // 5. 손님 별 루프
      for (String order : orders) {
        // 6. 오더 주문 수 보다 코스 요리 수가 크다면 구할 수가 없으므로 제외
        if (order.length() < menuCount) continue;
        // 7. 가능한 코스 요리 구성을 구하는 재귀식 실행
        recursion(order.toCharArray(), menuCount, 0, 0, "");
      }
      // 8. 찾은 모든 코스 요리 구성 경우의 수 중 가장 많이 나온 횟수를 체크
      int max = map.values().stream()
              .max(Comparator.naturalOrder())
              .orElseGet(() -> 0);
      // 9. max가 2 이하면 제외
      if (max < 2) continue;
      // 10. 가장 많은 코스 요리 찾고 set에 저장
      map.entrySet().stream()
              .filter((e) -> e.getValue() == max)
              .forEach((e) -> set.add(e.getKey()));
    }
    // 11. String 배열로 치환 후 리턴
    return set.toArray(String[]::new);
  }

  // 재귀식
  private void recursion(char[] menus, int menuCount, int depth, int sp, String course) {
    // 요리 개수가 맞다면, 요리 구성을 key로 잡고 횟수에 +1 추가
    if (depth == menuCount) {
      map.put(course, map.getOrDefault(course, 0) + 1);
      return;
    }
    // 이미 나온 요리는 제외하고 조합을 찾기
    for (int i=sp; i<menus.length; i++) {
      recursion(menus, menuCount, depth + 1, i + 1, course + menus[i]);
    }

  }
}