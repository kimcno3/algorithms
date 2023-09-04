package programmers.level_2;

// 타겟 넘버 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class TargetNumber {

  private int answerV2;

  public int solutionV2(int[] numbers, int target) {
    recursion(numbers, target, 0, 0);
    return answerV2;
  }

  private void recursion(int[] numbers, int target, int index, int sum) {
    if (index == numbers.length) {
      if (sum == target) answerV2++;
      return;
    }
    recursion(numbers, target, index + 1, sum + numbers[index]);
    recursion(numbers, target, index + 1, sum - numbers[index]);
  }

  int[] arr;
  int answer = 0;
  int n, t;

  public int solution(int[] numbers, int target) {

    arr = numbers;
    n = numbers.length;
    t = target;

    method(0, 0);

    return answer;
  }

  public void method(int depth, int sum) {

    // 깊이가 최대로 갔다면 재귀 종료
    if (depth == n) {
      // 종료 전에 전체값을 더하거나 뺀 경우가 target과 일치하는지 판단
      if (sum == t) {
        answer++;
      }
      return;
    }

    // 해당 깊이에서의 값을 +로 했을 경우
    sum += arr[depth];
    method(depth+1, sum);

    // sum 값 초기화, sum의 초기화 과정을 눈으로 확인하기 위해 같은 로직을 반복 작성
    sum -= arr[depth];

    // 해당 깊이에서의 값을 -로 했을 경우
    sum -= arr[depth];
    method(depth+1, sum);

  }

}
