package v1.baekjoon.recursion;

import java.io.*;

// N과 M(3) : https://www.acmicpc.net/problem/15651
public class No_15651 {

  static int n,m;
  static int[] arr;
  // System.out.println()의 반복 출력을 하면 시간초과 발생 -> StringBuilder로 문자열을 생성하고 한번에 출력
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split(" ");

    n = Integer.parseInt(split[0]);
    m = Integer.parseInt(split[1]);

    arr = new int[m];

    method(1, 0);
    System.out.println(sb);

  }

  public static void method(int sp, int depth) {

    if (depth == m) {
      for(int val : arr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=sp; i<=n; i++) {
      arr[depth] = i;
      method(sp, depth+1);
    }

  }

}

