package programmers.level_2;
import java.util.*;
import java.util.Map.Entry;

// 메뉴 리뉴얼 : https://school.programmers.co.kr/learn/courses/30/lessons/72411
// 1 ~5번 런타임 에러 발생

class MenuRenewal {

  List<String> list;
  HashMap<String, Integer> map;
  boolean[] visits;
  String[] order;

  public String[] solution(String[] orders, int[] course) {
    list = new ArrayList<>();
    visits = new boolean[orders.length];

    for (int size : course) {
      map = new HashMap<>();

      for (String str : orders) {
        // 개인 별 주문목록
        order = str.split("");

        // 주문 목록 정렬
        Arrays.sort(order);

        // 모든 경우의 수를 뽑아내는 메소드 구현(재귀)
        checkCourseMenu(0, 0, size, "");
      }

//-------------------------------------------------------------------------------------------------

      // map에 저장된 값들 중 최대값을 찾아 키값을 따로 저장하는 로직 구현 실패했고 답안 코드를 참고했습니다.
      // https://fbtmdwhd33.tistory.com/249

      // 최대값 조회
      int max = 0;
      for (Entry<String, Integer> entry : map.entrySet()) {
        max = Math.max(max, entry.getValue());
      }

      // 최대값에 해당하는 키 조회 및 list에 추가
      for (Entry<String, Integer> entry : map.entrySet()) {
        if (max >= 2 && entry.getValue() == max)
          list.add(entry.getKey());
      }
    }

    // list 정렬
    Collections.sort(list);

    // 리턴 타입 변경 (list -> String[])
    String[] answer = new String[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

  public void checkCourseMenu(int sp, int depth, int size, String menu) {

    if (depth == size) {

      // * getOrDefault() 메소드 활용법 *
      // map.put(menu, map.getOrDefault(menu, 1) + 1);

      if (map.get(menu) != null && map.get(menu) >= 1) {
        map.put(menu, map.get(menu) + 1);
      } else {
        map.put(menu, 1);
      }

      return;
    }

    for (int i = 0; i < order.length; i++) {

      if (!visits[i]) {
        visits[i] = true;
        checkCourseMenu(sp, depth + 1, size, menu.concat(order[i]));
        visits[i] = false;
      }
      sp++;
    }
  }
}