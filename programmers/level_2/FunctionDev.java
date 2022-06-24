package programmers.level_2;

import java.util.HashMap;
import java.util.LinkedList;

// 기능 개발 : https://programmers.co.kr/learn/courses/30/lessons/42586
public class FunctionDev {

  public static int[] solution(int[] progresses, int[] speeds) {

    HashMap<Integer, Double> map = new HashMap<>();
    LinkedList<Integer> list = new LinkedList<>();

    for (int i=0; i<progresses.length; i++) {
      double days = Math.ceil((100.0-progresses[i])/speeds[i]);
      map.put(i, days);
    }

    int count = 1;
    double maxDays = map.get(0);

    for (int i=1; i<map.size(); i++) {
      if (map.get(i) <= maxDays) {
        count++;
      } else {
        list.add(count);
        maxDays = map.get(i);
        count = 1;
      }
    }
    list.add(count);

    int[] answer = new int[list.size()];

    for (int i=0; i<answer.length; i++) {
      answer[i] = list.removeFirst();
    }

    return answer;

  }

  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};

    int[] answer = solution(progresses, speeds);

    for (int i : answer) {
      System.out.println(i);
    }
  }
}
