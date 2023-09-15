import java.util.*;

class Solution {
  public int[] solution(String[] id_list, String[] report, int k) {
    // 유저 아이디별 신고한 유저 아이디와 신고당한 횟수를 저장하기 위한 map 구조 생성
    Map<String, Integer> userIdIdx = new HashMap<>();
    Map<String, Set<String>> reportString = new HashMap<>();

    // 초기값 세팅
    int[] answer = new int[id_list.length];
    for (int i=0; i<id_list.length; i++) {
      userIdIdx.put(id_list[i], i);
      reportString.put(id_list[i], new HashSet<>());
    }

    // 신고 내역을 하나씩 조회
    for (String tempReport : report) {
      String[] splitReport = tempReport.split(" ");

      // 신고한 아이디
      String fromId = splitReport[0];
      // 신고당한 아이디
      String toId = splitReport[1];

      // 신고한 아이디 별로 아이디 누적 저장
      reportString.get(toId).add(fromId);

    }

    // 정지 아이디로 신고한 아이디를 조회
    for (int i=0; i<id_list.length; i++){
      Set<String> send = reportString.get(id_list[i]);
      if (send.size() >= k) {
        for (String name : send) {
          answer[userIdIdx.get(name)]++;
        }
      }
    }

    return answer;

  }
}