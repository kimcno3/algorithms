package v1.programmers.level_2;

import java.util.*;

// 소수 찾기 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
public class FindPrimeNumber {

  Set<Integer> set = new HashSet<>();
  boolean[] visits;
  String[] arr;

  public int solution(String numbers) {

    arr = numbers.split("");
    visits = new boolean[numbers.length()];

    for (int i=1; i<=arr.length; i++) {
      findPrimeNumberCount(i, "");
    }

    System.out.println(set);

    return set.size();

  }

  public void findPrimeNumberCount(int size, String num) {

    if (num.length() == size) {

      int n = Integer.parseInt(num);

      if (isPrime(n)) {
        set.add(n);
      }

      return;

    }

    for (int i=0; i<arr.length; i++) {

      if (visits[i]) {
        continue;
      }

      visits[i] = true;
      findPrimeNumberCount(size, num + arr[i]);
      visits[i] = false;

    }

  }

/*
 * 소수점 판별 시 중요한 점
   1. 소수점 판별시 0~2는 따로 조건문을 구현하고
   2. 이후, 2 ~ n의 제곱근까지의 값만 나머지를 구해보면 된다!!
 */

  public boolean isPrime(int n) {

    // 0, 1 은 소수로 안본다.
    if (n <= 1) {
      return false;
    }

    // 2는 소수로 본다.
    if (n == 2) {
      return true;
    }

    // 제곱근까지 포함!!한 반복문을 돈다.(일부 테스트 케이스가 통과하지 못한 이유 -> 2,10,11)
    for (int i = 2; i <= Math.sqrt(n); i++) {

      // 하나라도 나눠지는 값이 있다면 소수가 아니다.
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }
}

