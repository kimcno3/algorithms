package v1.programmers.level_1;

import java.util.Arrays;

// 예산 : https://programmers.co.kr/learn/courses/30/lessons/12982
public class Budget {

  public static void main(String[] args) {
    int[] d = {1,3,2,5,4};
    int budget = 9;
    System.out.println(solution(d, budget));
  }

  public static int solution(int[] d, int budget) {
    int answer = 0;
    int sum = 0;
    Arrays.sort(d);

    for (int num : d) {
      sum += num;
      if (sum > budget) break;
      answer++;
    }

    return answer;
  }
}
