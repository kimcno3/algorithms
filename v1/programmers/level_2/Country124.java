package v1.programmers.level_2;

// 124 나라의 숫자 : https://programmers.co.kr/learn/courses/30/lessons/12899#
public class Country124 {

  public static void main(String[] args) {
    System.out.println(solution(1));
    System.out.println(solution(2));
    System.out.println(solution(3));
    System.out.println(solution(9));
    System.out.println(solution(15));
    System.out.println(solution(23));
  }

  public static String solution(int n) {
    String answer = "";
    StringBuilder sb = new StringBuilder();

    while(n>3) {
      if (n%3 == 0) {
        sb.append(4);
        n = (n/3) - 1;
      }else if (n%3 == 1 || n%3 == 2) {
        sb.append(n%3);
        n /= 3;
      }
    }

    if (n==1 || n==2) {
      sb.append(n);
    } else if (n==3) {
      sb.append(4);
    }

    sb.reverse();

    answer = sb.toString();

    return answer;
  }

}
