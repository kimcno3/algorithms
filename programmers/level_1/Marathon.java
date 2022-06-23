package programmers.level_1;

import java.util.ArrayList;
import java.util.List;

// 완주하지 못한 선수 : https://programmers.co.kr/learn/courses/30/lessons/42576
public class Marathon {

  public static void main(String[] args) {
    String[] participant = {"leo", "kiki", "eden"};
    String[] completion = {"eden", "kiki"};
    System.out.println(solution(participant, completion));
  }
  public static String solution(String[] participant, String[] completion) {
    String answer = "";

    List<String> comList = new ArrayList();

    for (String str : completion) {
      comList.add(str);
    }

    for (String part : participant) {
      if(comList.contains(part)) {
        comList.remove(part);
      } else {
        answer = part;
        break;
      }
    }

    return answer;
  }
}
