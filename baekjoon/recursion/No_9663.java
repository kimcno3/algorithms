package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// N-Queen : https://www.acmicpc.net/problem/9663
public class No_9663 {

  static int n, result;
  static boolean[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    result = 0;
    arr = new boolean[n][n];

    method(0,0, 1);

    System.out.println(result);
  }


  // 1차 문제 풀이
  public static void method(int x, int y, int depth) {

    if (depth == n) {
      result++;
      return;
    }

    // 상하좌우 비교 로직
    boolean flag = check1(x, y);

    // 문제1: 대각선 비교 로직을 구현하지 못함.

    if (flag) {
      arr[x][y] = true;
    }

    // 문제2 : 재귀함수를 호출하기 위한 조건을 만들어내지 못함.

    arr[x][y] = false;

  }
  public static boolean check1(int x, int y) {

    // 상
    for (int i=x; i>=0; i--) {
      if (arr[i][y]) {
        return false;
      }
    }

    // 하
    for (int i=x; i<n; i++) {
      if (arr[i][y]) {
        return false;
      }
    }

    // 좌
    for (int i=y; i>=0; i--) {
      if (arr[x][i]) {
        return false;
      }
    }

    // 우
    for (int i=y; i<n; i++) {
      if (arr[x][i]) {
        return false;
      }
    }

    return true;
  }

  // 답안 코드 : https://st-lab.tistory.com/118
  // 힌트1 : 2차 배열이 아닌 1차 배열로 행과 열을 표현해보기 -> 같은 행에 위치한 녀셕들은 비교대상에서 제외할 수 있을 듯
  // 힌트2 : 대각선은 열간의 차와 행간의 차가 같다면 대각선에 위치해 있다고 볼 수 있다.

}
