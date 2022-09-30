package programmers.level_3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 단어 변환 : https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class WordChange {

  /*
   * BFS 활용 메소드
   *
   * 부족했던 점
   * DFS로 푸는 것이 더 낫다...?
   * 테스트 케이스 1번 실패
   *
   */

  public int solutionBfs(String begin, String target, String[] words) {

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
