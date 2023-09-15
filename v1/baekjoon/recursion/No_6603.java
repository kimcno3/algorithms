package v1.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로또 : https://www.acmicpc.net/problem/6603
public class No_6603 {

  static int n;
  static boolean[] visits;
  static String[] split;
  static String[] arr = new String[6];
  static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nums = "";

    while(!nums.equals("0")) {
      nums = br.readLine();

      split = nums.split(" ");
      visits = new boolean[n];
      n = Integer.parseInt(split[0]);

      method(1, 0);
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void method(int sp, int depth) {

    if (depth == 6) {
      for (String val : arr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=sp; i<split.length; i++) {
      if (!visits[i-1]) {
        visits[i-1] = true;
        arr[depth] = String.valueOf(split[i]);
        method(i, depth+1);
        visits[i-1] = false;
      }
    }
  }
}
