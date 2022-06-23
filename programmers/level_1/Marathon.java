package programmers.level_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 완주하지 못한 선수 : https://programmers.co.kr/learn/courses/30/lessons/42576
public class Marathon {

  public static void main(String[] args) {
    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    System.out.println(solution(participant, completion));
  }

  // 1차 코드
  public static String solution(String[] participant, String[] completion) {
    String answer = "";

    List<String> comList = new ArrayList();

    for (String str : completion) {
      comList.add(str);
    }

    // List의 경우 contains와 remove의 시간 복잡도가 O(n)을 가진다.
    // 이는 매우 비효율적인 반복문을 사용하고 있다는 의미를 가진다.
    for (String part : participant) {
      if(comList.contains(part)) {
        comList.remove(part);
      } else {
        answer = part;
        break;
      }
    }

    return answer;
  }

  // 2차 코드(답안 코드 참고, 컬렉션 별 시간 복잡도에 대한 고민을 해본 이후)
  public static String solution2(String[] participant, String[] completion) {
    String answer = "";

    HashMap<String, Integer> map = new HashMap<>();

    for (String str : participant) {
      map.put(str, map.getOrDefault(str, 0) + 1);
    }

    for (String str : completion) {
      map.put(str, map.get(str) - 1);
    }

    for (String str : map.keySet()) {
      // HashSet.get()은 O(1)의 시간 복잡도를 가진다.
      if (map.get(str) > 0) {
        answer = str;
        break;
      }
    }
    return answer;
  }
}
