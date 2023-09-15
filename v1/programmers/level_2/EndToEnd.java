package v1.programmers.level_2;

import java.util.*;

/*
 * 영어 끝말잇기 : https://school.programmers.co.kr/learn/courses/30/lessons/12981

 * 통과가 안되는 경우
    1. 다른 알파벳으로 단어를 말한 경우
      -> idx-1 단어의 마지막 문자와 idx 단어의 첫 문자를 비교
    2. 이전에 나온 같은 단어가 나온 경우
      -> HashMap.containKey()를 활용해서 중복성을 체크하기

 * 틀린 단어를 말한 사람의 번호와 몇번째 차례였는지 알기 위한 로직 구현 설계
   ex) 3명이 게임을 했고, idx = 6에서 걸렸다.
     * 6 + 1 = 7번째 단어가 틀렸다는 의미 -> 1번 사람이 3번째 턴에서 걸렸다는 것!
     * 7 = 3 * 2 + 1 이므로 idx / n + 1 = 3(몇번째 차례) 이고 idx % n + 1 = 1(사람 번호) 인 것을 이용
     * 예외적으로 n의 배수인 경우 idx % n + 1 = 0 이면 n으로 치환하고 idx / n = 3(몇번째 차례) 로 구합니다.
 */

public class EndToEnd {

  int[] answer;

  public int[] solution(int n, String[] words) {

    answer = new int[2];
    HashMap<String, Integer> map = new HashMap<>();

    // 첫번째 단어는 미리 추가
    map.put(words[0], 0);

    // 2번째 단어부터 루프 시작
    for (int i=1; i< words.length; i++) {

      String preWord = words[i - 1];
      String word = words[i];

      // 1번 검증
      if (preWord.charAt(preWord.length() - 1) != word.charAt(0)) {
        makeAnswer(i, n);
        break;
      }

      // 2번 검증
      if (map.containsKey(word)) {
        makeAnswer(i, n);
        break;
      } else {
        map.put(word, 0);
      }
    }

    return answer;

  }

  // index 값을 가지고 사람 번호와 몇번째 차례인지를 계산하는 메소드
  void makeAnswer(int i, int n) {
    // n의 배수인 경우
    if ((i + 1) % n == 0) {
      answer[0] = n;
      answer[1] = (i + 1) / n;
    }
    // 그 외의 경우
    else {
      answer[0] = (i + 1) % n;
      answer[1] = ((i + 1) / n) +1;
    }
  }
}
