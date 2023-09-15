package v1.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen : https://www.acmicpc.net/problem/9663
public class No_9663 {

  static int n, result;

  //static boolean[][] arr;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    result = 0;

    // arr = new boolean[n][n];
    arr = new int[n];

    method(0);

    System.out.println(result);
  }

  /*
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
  */

  // 답안 코드 : https://st-lab.tistory.com/118
  // 힌트1 : 2차 배열이 아닌 1차 배열로 행과 열을 표현해보기 -> 같은 행에 위치한 녀셕들은 비교대상에서 제외할 수 있을 듯
  // 힌트2 : 대각선은 열간의 차와 행간의 차가 같다면 대각선에 위치해 있다고 볼 수 있다.

  // 2차 문제 풀이 -> 거의 비슷한 로직을 구현했지만 답안 코드를 참고하고 이해하는 방향으로 작성했습니다.
  public static void method(int depth) {

    if (depth == n) {
      result++;
      return;
    }

    for (int i=0; i<n; i++) {
      arr[depth] = i;

      // 놓일 수 있는 위치일 경우에만!! 재귀함수 호출 -> 다음 열로 넘어간다는 의미
      if (check(depth)) {
        method(depth+1);
      }
      // 그 외 경우는 반복문이 끝나기 때문에 아무런 동작도 하지 않는다.
    }

  }

  public static boolean check(int depth) {
    for (int preDepth=0; preDepth<depth; preDepth++) {
      // 두 행의 차이와 열의 차이가 같은경우 or 값이 같은 경우 -> 놓일 수 없는 위치
      if (Math.abs(preDepth-depth) == Math.abs(arr[preDepth]-arr[depth]) || arr[preDepth] == arr[depth]) {
        return false;
      }
    }
    // 이를 통과 했다면 놓일 수 있는 위치
    return true;

  }
}
