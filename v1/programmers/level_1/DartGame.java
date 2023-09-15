package v1.programmers.level_1;

import java.util.*;

// 다트게임 : https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class DartGame {

  public static void main(String[] args) {
    DartGame dartGame = new DartGame();
//    System.out.println(dartGame.solution("1D2S#10S"));
    System.out.println(dartGame.solution2("1D2S0T"));

  }


  // 1차 작성 코드
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

  // 2차 작성 코드
  public int solution2(String dartResult) {
    int answer = 0;
    String[] split = dartResult.split("");

    String numStr = "";
    int n;

    // 라운드별 점수의 변경을 반영하고 마지막에 총합하기 위해 배열로 라운드별 점수를 저장해둔다.(중첩 결과를 반영하기 위해!!)
    int[] round = new int[3];
    int idx = 0;

    for (String str : split) {
      // 숫자인 경우
      if (str.matches("[0-9]")) {
        numStr += str;
      }

      // S, D, T 인 경우
      else if (str.matches("[SDT]")) {
        n = Integer.parseInt(numStr);
        switch (str) {
          case "S" :
            round[idx++] = (int) Math.pow(n, 1);
            break;
          case "D" :
            round[idx++] = (int) Math.pow(n, 2);
            break;
          case "T" :
            round[idx++] = (int) Math.pow(n, 3);
            break;
        }
        // 문자열만 초기화
        numStr = "";
      }
      // 아차상, 스타상이 경우
      else {
        switch (str) {
          case "*" :
            round[idx-1] *= 2;
            // 이전 라운드 결과에도 영향을 준다.
            if(idx-2>=0) round[idx-2] *= 2;
            break;
          case "#" :
            round[idx-1] *= (-1);
            break;
        }
      }
    }
    return answer;
  }
}
