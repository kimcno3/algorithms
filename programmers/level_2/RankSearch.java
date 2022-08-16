package programmers.level_2;

import java.util.*;

/**
 * 멘토님과 코딩 테스트 풀이 문제

 * 중요한 점
   1. 문제 풀이를 위한 설계 단계에서 적절한 풀이법을 최대한 고민해야 한다.
     - 두 배열을 전체 탐색하는 경우 시간 복잡도가 매우 비효율적인 구조
     - 이런 경우, 생성될 수 있는 모든 경우에 수에 대해서 해시 키로 등록을 하는 방법을 선택
     - 이후 각 키에 저장될 숫자에 대한 값을 List에 저장
     - 모든 저장이 완료된 이후, List에 저장된 값을 일괄적으로 정렬해준다.
     - 정렬된 이후, 각 List를 탐색하는 과정에서 일정 값 이상의 경우에 대한 개수만 알면 되닌 이진 탐색으로 효율성을 높힌다.
   2. 풀이 과정 속에서 시간 복잡도에 대한 고민을 해봐야 한다.
   3. 내가 막힌 부분이나 고민이 되는 부분은 말로 해보던지 적어보면서 정리해보는 시간을 가져보면서 진행해본다.
   4. 반복되는 코드나 코드 흐름상 분리해줘야 할 필요가 있다면 함수로 분리해주는 필요가 있다.
 */

// 순위 검색 : https://school.programmers.co.kr/learn/courses/30/lessons/72412
public class RankSearch {

  Map<String, List<Integer>> map = new HashMap<>(); // 해쉬 탐색 구조로 구현

  public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];

    for(String str : info) {
      String[] arr = str.split(" ");
      int score = Integer.parseInt(arr[arr.length-1]);

      makeKey(arr, 0, "", score);
    }

    for (List<Integer> list : map.values()) {
      Collections.sort(list); // List 정렬 방법
    }

    for (int i=0; i< query.length; i++) {
      String[] arr = query[i].split(" ");
      int score = Integer.parseInt(arr[arr.length-1]);

      String key = findKey(arr);

      List<Integer> list = map.getOrDefault(key, new ArrayList<>());

      int idx = binarySearch(list, score); // 이진 탐색 메소드 구현

      // Collections.binarySearch(list, score); -> Collections 클래스에서 제공해주는 이진 탐색 메소

      if (idx == -1) {
        idx = list.size();
      }

      answer[i] = list.size() - idx;

    }

    return answer;
  }

  public void makeKey(String[] arr, int depth, String key, int score) {

    if (depth == arr.length-1) {

      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      map.get(key).add(score);

      return;

    }
    makeKey(arr, depth+1, key + arr[depth], score);
    makeKey(arr, depth+1, key + "-", score);
  }

  public String findKey(String[] arr) {

    String key = "";
    for (int i=0; i<arr.length; i+=2) {
      key += arr[i];
    }

    return key;
  }

  public int binarySearch(List<Integer> list, int score) {
    int low = 0;
    int high = list.size()-1;
    int result = -1;

    while(low <= high) {

      int mid = (high + low) / 2;
      int midScore = list.get(mid);

      if (midScore < score) {
        low = mid + 1;
      } else {
        result = mid; // !!
        high = mid - 1;
      }
    }
    return result;
  }

}
