package programmers.level_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 실패율 : https://programmers.co.kr/learn/courses/30/lessons/42889
public class FailureRate {

  public static void main(String[] args) {
    int[] nums = {2, 1, 2, 6, 2, 4, 3, 3};
    solution(5, nums);
  }

  public static int[] solution(int N, int[] stages) {
    int[] answer = new int[N];

    // 스테이지별 실패율을 저장할 자료구조로 Map을 선택 -> 스테이지별 실패율을 구분해 저장해야 할 필요가 있기 때문에
    Map<Integer, Double> map = new HashMap<>();

    // 스테이지별 조회
    for (int i=1; i<N+1; i++) {

      double currentStage = 0.0;
      double notClearStage = 0.0;

      for (int stage : stages) {
        // 플레이어의 현재 스테이지가 해당 스테이지와 동일하다면 -> 해당 스테이지를 클리어하지 못하고 있는 경우
        if (i == stage) {
          notClearStage++;
        }
        // 플레이어의 현재 스테이지가 해당 스테이지보다 이상이라면 -> 해당 스태이지에 도달한 경우
        if (i <= stage) {
          currentStage++;
        }
      }
      // 실패율 계산 및 저장
      map.put(i-1, notClearStage/currentStage);

    }

    // 실패율에 따른 내림차순 정렬
    List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
    list.sort((v1, v2) -> v2.getValue().compareTo(v1.getValue()));

    // 정렬된 순서대로 스테이지 번호를 answer에 입력
    for (int i=0; i<list.size(); i++) {
      answer[i] = list.get(i).getKey()+1;
    }

    return answer;

  }

}
