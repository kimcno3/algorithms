package programmers.level_1;

public class InnerPlus {

  public static void main(String[] args) {
    int[] a = {1,2,3,4};
    int[] b = {-3,-1,0,2};
    System.out.println(solution(a, b));

    int[] a2 = {-1,0,1};
    int[] b2 = {1,0,-1};
    System.out.println(solution(a2, b2));

  }
  public static int solution(int[] a, int[] b) {
    int answer = 0;
    int length = a.length;

    for (int i=0;i<length; i++) {
      answer += a[i] * b[i];
    }

    return answer;
  }
}
