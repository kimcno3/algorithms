package programmers.level_1;

// 음양 더하기 : https://programmers.co.kr/learn/courses/30/lessons/76501
public class PlusDarkBright {
  public static void main(String[] args) {

  }
  // solution
  public static int solution(int[] absolutes, boolean[] signs) {
    int answer = 0;
    int length = absolutes.length;

    for (int i=0; i<length; i++) {
      if (signs[i]) {
        answer += absolutes[i];
      } else {
        answer -= absolutes[i];
      }
    }
    return answer;
  }
}
