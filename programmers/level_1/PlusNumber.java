package programmers.level_1;

import java.util.*;

// 업는 숫자 더하기 : https://programmers.co.kr/learn/courses/30/lessons/86051
public class PlusNumber {
  public static void main(String[] args) {
    int[] numbers = {1,2,3,4,6,7,8,0};
    System.out.println("" + solution(numbers));

    int[] numbers2 = {5,8,4,0,6,7,9};
    System.out.println("" + solution(numbers2));
  }
  // solution
  public static int solution(int[] numbers) {
    int answer = 0;
    StringBuilder sb = new StringBuilder();

    // int 배열 값을 StringBuilder 로 치환
    for (int number : numbers) {
      sb.append(number);
    }

    // 0 ~ 9까지의 숫자 중 포함이 안된 숫자만 더한다.
    for (int i=0; i<=9; i++) {
      if (!sb.toString().contains(String.valueOf(i))) {
        answer += i;
      }
    }

    return answer;
  }
}
