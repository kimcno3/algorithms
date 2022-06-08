package programmers.level_1;

import java.util.HashMap;
import java.util.Map;

// 신고 결과 받기 : https://programmers.co.kr/learn/courses/30/lessons/92334
public class ReportId {

  public static void main(String[] args) {
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    int k = 2;

    System.out.println(solution(id_list, report, k));
  }

  public static int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = {};

    // 0. 유저 아이디별 신고한 유저 아이디와 신고당한 횟수를 저장하기 위한 map 구조 생성
    Map<Integer, StringBuilder> map = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    // null값이 없도록 초기값 세팅
    for (int i=0; i<id_list.length; i++) {
      map.put(i, new StringBuilder(""));
      map2.put(i, 0);
    }

    // 1. 신고 내역을 하나씩 조회
    for (String tempReport : report) {
      String[] splitReport = tempReport.split(" ");
      // 신고한 유저
      String fromId = splitReport[0];
      // 신고당한 유저
      String toId = splitReport[1];

      // 2. 유저 아이디(key) 별 신고한 아이디(value)를 저장
      for (int i=0; i<id_list.length; i++) {
        if (fromId.equals(id_list[i])) {
          map.put(i, map.get(i).append(toId).append(" "));
        }
      }
    }
    // 3. 유저 아이디(key) 별 신고당한 횟수(value) 저장
    for (int i=0; i<id_list.length; i++) {
      String id = id_list[i];
      for (int j=0; j<map.size(); j++) {
        if (map.get(j).toString().contains(id)) {
          map2.put(i, map2.get(i)+1);
        }
      }
    }

    return answer;

  }
}
