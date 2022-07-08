package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    method2(0, 0, n);

    System.out.println(zero);
    System.out.println(one);
  }

  // 1차 작성 코드 -> 1시간 초과
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

    // 4분할로 재귀 함수를 실행하는 로직 구현 실패
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

  // 2차 작성 코드 -> 20분 소요
  public static void method2(int x, int y, int size) {
    // 시작 지점의 숫자값 저장
    int num = arr[x][y];

    // 범위 안의 숫자가 모두 같은지 여부를 판단
    boolean flag = checkSameColor(x, y, size, num);

    // 범위 안의 숫자가 모두 같은 경우
    if (flag) {
      if (num == 0) zero++;
      else one++;
    }

    // 볌위 안의 숫자가 하나라도 다른 경우 -> 4분할한 뒤 다시 비교
    else {
      int newSize = size/2;

      method2(x, y, newSize); // 1사분면
      method2(x+newSize, y, newSize); // 2사분면
      method2(x, y+newSize, newSize); // 3사분면
      method2(x+newSize, y+newSize, newSize); //4사분면

    }

  }

  // 범위 안의 숫자가 모두 동일한지 여부를 판단하는 메소드
  public static boolean checkSameColor(int x, int y, int size, int num) {
    for (int i=x; i<x+size; i++) {
      for (int j=y;j<y+size; j++) {
        // 하나라도 다른 숫자가 존재하면 false
        if (arr[i][j] != num) {
          return false;
        }
      }
    }
    return true;
  }

}
