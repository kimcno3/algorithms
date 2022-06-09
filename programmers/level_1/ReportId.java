package programmers.level_1;

import java.util.HashMap;
import java.util.Map;

// 신고 결과 받기 : https://programmers.co.kr/learn/courses/30/lessons/92334
public class ReportId {

  public static void main(String[] args) {
    String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    int k = 2;

    int[] answer = solution(id_list, report, k);
    for (int i : answer) {
       System.out.println(i);
    }

    System.out.println();

    String[] id_list2 = {"con", "ryan"};
    String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
    int k2 = 3;

    int[] answer2 = solution(id_list2, report2, k2);
    for (int i : answer2) {
      System.out.println(i);
    }

  }

  public static int[] solution(String[] id_list, String[] report, int k) {
    // 유저 아이디별 신고한 유저 아이디와 신고당한 횟수를 저장하기 위한 map 구조 생성
    Map<String, Integer> userIdIdx = new HashMap<>();
    Map<Integer, StringBuilder> reportString = new HashMap<>();
    Map<Integer, Integer> reportInt = new HashMap<>();

    // 초기값 세팅
    int[] answer = new int[id_list.length];
    for (int i=0; i<id_list.length; i++) {
      userIdIdx.put(id_list[i], i);
      reportString.put(i, new StringBuilder(""));
      reportInt.put(i, 0);
    }

    // 신고 내역을 하나씩 조회
    for (String tempReport : report) {
      String[] splitReport = tempReport.split(" ");

      // 신고한 아이디
      String fromId = splitReport[0];
      // 신고당한 아이디
      String toId = splitReport[1];

      // 신고한 아이디 인덱스 조회
      int fromIdIdx = userIdIdx.get(fromId);
      // 신고당한 아이디 인덱스 조회
      int toIdIdx = userIdIdx.get(toId);

      // 해당 아이디에 대한 신고 내역에 없는 경우
      if (!reportString.get(fromIdIdx).toString().contains(toId)) {
        // 신고한 아이디 별로 아이디 누적 저장
        reportString.put(fromIdIdx, reportString.get(fromIdIdx).append(toId).append(" "));

        // 신고당한 아이디는 신고 당한 횟수를 저장
        reportInt.put(toIdIdx, reportInt.get(toIdIdx) + 1);

        // 신고 횟수가 k회 이상일 경우 -> 정지
        if (reportInt.get(toIdIdx) == k) {
          // 정지 아이디를 신고한 아이디를 조회
          for (int i=0; i<reportString.size(); i++) {
            // 정지 아이디를 신고한 아이디에 이메일 전송
            if(reportString.get(i).toString().contains(toId)) {
              answer[i]++;
            }
          }
        }
      }

    }

    return answer;

  }
}
