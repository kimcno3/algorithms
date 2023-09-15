package v1.baekjoon.recursion;

import java.util.Scanner;

// 피보나치 수 : https://www.acmicpc.net/problem/10870
public class No_10870 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.println(recursion(sc.nextInt()));
  }

  public static int recursion(int n) {
    if (n >= 2) {
      return recursion(n-1) + recursion(n-2);
    } else if (n == 1) {
      return 1;
    } else {
      return 0;
    }
  }
}
