package v1.programmers.level_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 단어 변환 : https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class WordChange {

  /** 풀이 V2
   * 조금 더 추상화해 구현했습니다.
   */

  public int solutionV2(String begin, String target, String[] words) {

    // 변환할 수 없는 경우에는 0 리턴
    if (!checkExist(words, target)) return 0;

    int answer = -1;
    boolean[] visits = new boolean[words.length];
    // 큐에 들어갈 자료구조 : 현재 변환된 단어의 인덱스, 변환 횟수
    LinkedList<int[]> queue = new LinkedList<>();
    queue.add(new int[]{-1, 0});
    // 큐가 빌 때까지 루프를 돈다.
    while(!queue.isEmpty()) {
      // 현재 큐 가져온다.
      int[] current = queue.pop();
      // 현재 단어와 변환 횟수를 변수로 만든다.
      String word = getWord(begin, words, current);
      int count = current[1];
      // 만약 현재 단어가 타겟일 경우 종료한다.
      if (word.equals(target)) return count;
      // 타겟이 아니라면 루프를 돌면서 전체 단어와 비교한다.
      for (int i=0; i<words.length; i++) {
        // 이미 변경된 단어라면 제외
        if (visits[i]) continue;
        // 변환이 가능한지 검증
        if (!checkChange(word, words[i])) continue;
        // 변환이 가능하다면 방문 처리
        visits[i] = true;
        // 큐에 추가
        queue.add(new int[]{i, count+1});
      }
    }
    return answer;
  }

  private boolean checkExist(String[] words, String target) {
    for (String word : words) {
      if (target.equals(word)) return true;
    }
    return false;
  }

  private String getWord(String begin, String[] words, int[] current) {
    if (current[0] == -1) return begin;
    else return words[current[0]];
  }

  private boolean checkChange(String word, String testWord) {
    int limit = 0;
    for (int i=0; i<word.length(); i++) {
      // 한개 이상 틀리다면 변경이 불가능하다고 판단
      if (word.charAt(i) != testWord.charAt(i)) limit++;
    }
    return limit <= 1;
  }

  /** 이전 풀이
   * 동일하게 BFS를 사용했지만 답안 코드를 참고했습니다.
   **/

  public int solution(String begin, String target, String[] words) {

    int answer = 0;
    int length = words.length;
    boolean[] visits = new boolean[length];
    Queue<int[]> q = new LinkedList<>();

    boolean flag = false;
    for (String word : words) {
      if (target.equals(word)) {
        flag = true;
        break;
      }
    }

    if (!flag) {
      return 0;
    }

    q.add(new int[]{-1, 0}); // 시작 단어는 -1로 인덱스를 지정

    // bfs
    while(!q.isEmpty()) {

      int[] arr = q.poll();

      int wordIdx = arr[0];
      int count = arr[1];

      String word;

      // 시작 단어일 경우에는 word = begin 으로 할당
      if (wordIdx == -1) {
        word = begin;
      } else {
        word = words[wordIdx];
      }

      // 타겟 단어까지 변경한 경우
      if (word.equals(target)) {
        answer = count;
        break;
      }

      int max = 0;
      Map<Integer, Integer> map = new HashMap<>();

      // 같은 알파벳 개수 체크
      for (int i=0; i< length; i++) {
        int cnt = 0;

        // 이미 큐에 들어갔던 단어일 경우는 제외
        if (!visits[i]) {
          // 단어 별 같은 단어 개수 체크
          for (int j=0; j<word.length(); j++) {

            if (word.charAt(j) == words[i].charAt(j)) {
              cnt++;
            }

          }

          // 단어별 같은 단어 개수 저장
          map.put(i, cnt);

          // 가장 많은 같은 수 저장
          if (max < cnt) {
            max = cnt;
          }

        }

      }

      // 저장된 같은 단어 개수 map 중 최대 개수와 같은 인덱스 값만 큐에 추가
      for (int key : map.keySet()) {

        if (map.get(key) == max) {
          visits[key] = true;
          q.add(new int[]{key, count + 1});
        }

      }

    }

    return answer;

  }
}
