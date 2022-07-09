package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿼드트리 : https://www.acmicpc.net/problem/1992
public class No_1992 {

  static int n;
  static int[][] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 초기 세팅
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];

    for (int i=0; i<n; i++) {
      String[] split = br.readLine().split("");
      for (int j=0; j<n; j++) {
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }

    // 재귀함수 실행
    method(0,0, n);

    // 정답 출력
    System.out.println(sb.toString());

  }

  // 재귀함수
  public static void method(int x, int y, int size) {
    // 시작 지점의 숫자를 저장
    int sp = arr[x][y];

    // 범위 안의 숫자가 모두 동일한지 여부를 판단
    boolean flag = checkNumber(x, y, size, sp);

    // 1. 모든 숫자가 같은 경우

    if (flag) {
      //시작점의 숫자를 sb에 추가
      if (sp == 0) sb.append(0);
      else sb.append(1);
      return;
    }

    // 2. 하나라도 다른 경우

    // 4등분을 위한 새로운 사이즈 계산
    int newSize = size/2;

    // 괄호 시작
    sb.append("(");

    method(x, y, newSize); // 1사분면
    method(x, y+newSize, newSize); // 2사분면
    method(x+newSize, y, newSize); // 3사분면
    method(x+newSize, y+newSize, newSize); // 4사분면

    // 괄호 끝
    sb.append(")");

  }

  // 범위 내 숫자들의 동일 여부 판단 메소드
  public static boolean checkNumber(int x, int y, int size, int sp) {

    // 시작 점부터 가로, 세로 범위 안의 숫자를 Loop
    for (int i=x; i<x+size; i++) {
      for (int j=y; j<y+size; j++) {
        // 하나라도 다르면 false
        if (arr[i][j] != sp) {
          return false;
        }
      }
    }
    // 그 외에는 true
    return true;
  }
}
