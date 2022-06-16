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
      // 제곱수일 경우가 약수가 홀수인 경우 이므로
      if (sqrt == Math.floor(sqrt)) {
        answer -= i;
      } else {
        answer += i;
      }
    }
    return answer;
  }
}
