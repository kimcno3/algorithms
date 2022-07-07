package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.DoubleStream;

// 색종이 만들기 : https://www.acmicpc.net/problem/2630
public class No_2630 {
  static int n, one, zero;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];

    for (int i=0; i<n; i++) {
      String str = br.readLine();
      for (int j=0; j<n; j++) {
        String[] split = str.split(" ");
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }
    method(0, 0, n);
    System.out.println(zero);
    System.out.println(one);
  }

  // 1차 작성 코드
  public static void method(int x, int y, int length) {
    int num = arr[x][y];
    boolean flag = true;

    if (length == 1) {
      if (num == 0) zero++;
      else one++;
      return;
    }

    for (int i=x; i<x+length; i++) {
      for (int j=y; j<y+length; j++) {
        if (arr[i][j] != num) {
          flag = false;
          break;
        }
      }
      if (!flag) {
        break;
      }
    }

    if (!flag) {
      for (int i=x; i<length; i += length) {
        for (int j=y; j<length; j += length) {
          method(i, j, length/2);
        }
      }
    } else {
      if (num == 0) zero++;
      else one++;
    }

  }

  // 답안코드 : https://st-lab.tistory.com/227

  // 2차 작성 코드
  public static void method2(int x, int y, int length) {

  }
}
