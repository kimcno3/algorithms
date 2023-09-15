import java.util.*;

class Solution {
  int[] answer;

  public int[] solution(int n, String[] words) {

    answer = new int[2];
    HashMap<String, Integer> map = new HashMap<>();

    // 첫번째 단어는 미리 추가
    map.put(words[0], 0);

    // 2번째 단어부터 시작
    for (int i=1; i< words.length; i++) {

      String preWord = words[i - 1];
      String word = words[i];

      // 1번 검증
      if (preWord.charAt(preWord.length() - 1) != word.charAt(0)) {

        makeAnswer(i, n);

        break;

      }

      if (map.containsKey(word)) {

        makeAnswer(i, n);

        break;

      } else {

        map.put(word, 0);

      }
    }

    return answer;

  }

  void makeAnswer(int i, int n) {
    if ((i + 1) % n == 0) {
      answer[0] = n;
      answer[1] = (i + 1) / n;
    } else {
      answer[0] = (i + 1) % n;
      answer[1] = ((i + 1) / n) +1;
    }
  }
}