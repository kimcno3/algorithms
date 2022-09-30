package programmers.level_2;

// k진수에서 소수 개수 구하기 : https://school.programmers.co.kr/learn/courses/30/lessons/92335
public class PrimeCountWithK {

/* 소수 판별 문제
 *
 * 미흡한 점
   1. num 변수의 타입을 int 가 아닌 long 으로 했어야 했다.
     * 최대 100만까지 가능한 n 을 k 진법으로 변경했을 때, int 의 범위를 벗어난 값이 생겨날 수도 있기 때문!
   2. 소수 판별 코드 작성시 0,1,2에 대해서만 별도의 조건식을 걸면 된다. (n <= 1 : false, n==2 : true)
 */

  public int solution(int n, int k) {

    int answer = 0;

    StringBuilder sb = new StringBuilder();

    while(n > 0) {
      sb.append((n % k));
      n = n / k;
    }

    String[] arr = sb.reverse().toString().split("0");


    for (String str : arr) {
      long num = 0;

      if (!str.equals("")) {
        num = Long.parseLong(str);
      }
      System.out.println(num);

      // 소수 판별
      if (isPrime(num)) {
        answer ++;
      }

    }

    return answer;
  }

  boolean isPrime(long num) {

    if (num <= 1) {
      return false;
    }

    if (num == 2) {
      return true;
    }

    for (int i=2; i<=Math.sqrt(num); i++) {

      if (num % i == 0) {
        return false;
      }

    }

    return true;
  }
}
