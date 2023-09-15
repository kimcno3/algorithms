package v1.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N과 M(1) : https://www.acmicpc.net/problem/15649
public class No_15649 {

  static int n, m;
  static int[] arr;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");

    n = Integer.parseInt(str[0]);
    m = Integer.parseInt(str[1]);

    arr = new int[m];
    visit = new boolean[n];

    method(0, 0);
  }


  public static void method(int at, int depth) {

    if (depth == m) {
      for (int val : arr) {
        System.out.print(val + " ");
      }
      System.out.println();
      return;
    }

    for (int i=at; i<n; i++) {
      if (!visit[i]) {
        visit[i] = true;
        arr[depth] = i+1;
        method(at, depth+1);
        visit[i] = false;
      }
    }
  }
}
