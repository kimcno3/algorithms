public class Solution {
 
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