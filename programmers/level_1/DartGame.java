package programmers.level_1;

import java.util.*;

// 다트게임 : https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class DartGame {

  public static void main(String[] args) {
    DartGame dartGame = new DartGame();
    System.out.println(dartGame.solution("1D2S#10S"));

  }
  /*
  1차 작성 코드

  부족했던 점
    -
  */
  public int solution(String dartResult) {
    int answer = 0;
    String[] split = dartResult.split("[SDT*#]");

    List<Integer> list = new ArrayList<>();

    for (String str : split) {
      if (str.matches("[0-9]") || str.equals("10")) {
        list.add(Integer.parseInt(str));
      }
    }

    int idx = 0;
    for (String str : dartResult.split("")) {
      switch (str) {
        case "S" : list.set(idx, list.get(idx));
        case "D" : list.set(idx, list.get(idx) * list.get(idx));
        case "T" : list.set(idx, list.get(idx) * list.get(idx) * list.get(idx));
        case "*" : list.set(idx, list.get(idx) * 2);
        case "#" : list.set(idx, list.get(idx) * (-1));
      }
    }

    return answer;
  }

  // 답안코드 https://yeoeun-ji.tistory.com/110
}
