package programmers.level_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 신고 결과 받기 : https://programmers.co.kr/learn/courses/30/lessons/92334
public class ReportId {

  public static void main(String[] args) {
    // 테스트 1
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    int k = 2;

    int[] answer = solution(id_list, report, k);
    for (int i : answer) {
       System.out.println(i);
    }
    // 결과 : [2,1,1,0]

    System.out.println("--------------------");

    // 테스트 2
    String[] id_list2 = {"con", "ryan"};
    String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
    int k2 = 3;

    int[] answer2 = solution(id_list2, report2, k2);
    for (int i : answer2) {
      System.out.println(i);
    }
    // 결과 : [0,0]

  }

  public static int[] solution(String[] id_list, String[] report, int k) {
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
      // 핵심인 코드 -> 신고한 아이디를 키로 두는 것이 아니라 신고 받은 아이디를 키로 두고 신고한 아이디를 set에 저장
      reportString.get(toId).add(fromId);

    }
    // loop를 끝낸다.
    // 5 * 4 * 4 -> 5 + 4 * 4의 반복문을 수행하도록!!

    // 정지 아이디로 신고한 아이디를 조회
    for (String id : id_list){
      Set<String> send = reportString.get(id);
      if (send.size() >= k) {
        for (String name : send) {
          answer[userIdIdx.get(name)]++;
        }
      }
    }

    return answer;

  }
}
