package programmers.level_2;

import java.math.BigDecimal;
import java.util.*;


// 뉴스 클러스터링 : https://school.programmers.co.kr/learn/courses/30/lessons/17677
class NewsClustering {

  Map<String, Integer> map1;
  Map<String, Integer> map2;

  public int solution(String str1, String str2) {

    map1 = stringToMap(str1);
    map2 = stringToMap(str2);

    // 중복값이 존재할 경우, 교집합은 최소값 개수만큼, 합집합은 최대값 개수만큼 추가해줍니다.

    return j(map1.keySet(), map2.keySet());

  }

  // map에 들어갈 값을 계산하는 로직
  public Map<String, Integer> stringToMap(String str) {

    Map<String, Integer> map = new HashMap<>();

    String[] arr = str.toLowerCase(Locale.ROOT)
        .split("");

    for (int i = 0; i < arr.length-1; i++) {

      String key = arr[i] + arr[i+1];
      key = key.replaceAll("[^a-z]", "");

      if (key.length() < 2) {
        continue;
      }

      if (map.containsKey(key)) {
        map.put(key, map.get(key) + 1);
      }

      else {
        map.put(key, 1);
      }

    }

    return map;
  }

  // 자카드 유사도 메소드
  public int j(Set<String> set1, Set<String> set2) {

    // 교집합
    List<String> interaction = new ArrayList<>();
    // 합집합
    List<String> union = new ArrayList<>();

    // 같은 값이 존재할 경우를 비교
    for (String str : set1) {

      if (set2.contains(str)) {
        int min = Math.min(map1.get(str), map2.get(str));
        int max = Math.max(map1.get(str), map2.get(str));

        // 최소값만큼 교집합에 추가
        for(int i=0; i<min; i++) {
          interaction.add(str);
        }

        // 최대값만큼 합집합에 추가
        for(int i=0; i<max; i++) {
          union.add(str);
        }

        continue;

      }

      // 겹치지 않는 값은 합집합에 추가
      for (int i=0; i<map1.get(str); i++) {
        union.add(str);
      }

    }

    // set2에서 아직 추가되지 않고 겹치지 않는 값들을 합집합에 추가
    for (String str : set2) {

      if (!union.contains(str)) {
        for (int i=0; i<map2.get(str); i++) {
          union.add(str);
        }
      }

    }

    // 자카드 유사도 계산
    double num1 = interaction.size();
    double num2 = union.size();

    // 두 집합이 모두 공집합이면 1로 보고 계산
    if (num1 == 0 && num2 == 0) {
      return 1 * 65536;
    }

    return BigDecimal.valueOf((num1 / num2) * 65536).intValue();
  }
}

