package programmers.level_1;

// 약수의 개수와 덧셈 : https://programmers.co.kr/learn/courses/30/lessons/77884
public class CalcDivisor {

  public static void main(String[] args) {
    System.out.println(solution(13, 17));
  }

  public static int solution(int left, int right) {
    int answer = 0;

    for (int i=left; i<=right; i++) {
      double sqrt = Math.sqrt((double) i);
      // 약수가 홀수인 경우 -> 제곱수일 경우이므로 소숫점을 제거한 값과 동일하다 제곱수로 판단한다.
      if (sqrt == Math.floor(sqrt)) {
        answer -= i;
      }
      // 그 외 경우는 모두 약수가 짝수인 경우로 판단한다.
      else {
        answer += i;
      }
    }
    return answer;
  }
}
