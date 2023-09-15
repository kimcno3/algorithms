import java.util.*;

/*
 * HashMap 을 활용해서 {종류 : 개수}의 형태로 매개변수 값을 정리하는 것 까지 완료
 * 하지만 그 이후에 총 경우의 수를 계산하는 부분은 막혔다.(재귀함수로 어떻게든 해보려 했지만 결국 실패 덩어리 코드..)
 * 경우의 수 계산법
   *
   * 쉽게 생각해 각 종류 별로 옷 개수 + 안입은 경우까지 생각하는 것이 해결법이다.
   * 즉, 모자의 개수가 3일 경우, 3 + 1 = 4개로 보고 각 종류별 개수를 곱해준다.
   * 그 다음 모든 종류의 옷을 안입었을 경우 1경우만 총 결과값에서 빼주면 된다.
   *
   * 예를 들어, 종류가 세가지인 경우 각 모자의 종류가 다음과 같다면
   * [모자1, 모자2, 모자3, 안입음]
   * [상의1, 상의2, 안입음]
   * [하의1, 하의2, 안입음]
   *
   * 경우의 수 예시 : {모자1, 상의1, 하의1}, {모자1, 상의1, 하의2}, {모자1, 상의1, 인입음} ... {안입음, 안입음, 안입음} 까지
   * 총 경우의 수 : 4 * 3 * 3 = 36 이지만 {안입음, 안입음, 안입음}이 나오는 경우의 수는 제외해야 하니까 35개가 정답
 */

class Solution {

  public int solution(String[][] clothes) {

    int answer = 1;

    // {의상 종류 : 개수}
    Map<String, Integer> map = new HashMap<>();

    for (String[] clothe : clothes) {

      String key = clothe[1];

      map.put(key, map.getOrDefault(key, 0) + 1);

    }

    for (Integer val : map.values()) {
      answer *= (val + 1);

    }

    return answer - 1;

  }

}