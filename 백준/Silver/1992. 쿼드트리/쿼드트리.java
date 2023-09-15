import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쿼드트리 : https://www.acmicpc.net/problem/1992
public class Main {

  static int n;
  static int[][] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n][n];

    for (int i=0; i<n; i++) {
      String[] split = br.readLine().split("");
      for (int j=0; j<n; j++) {
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }

    method(0,0, n);
    System.out.println(sb.toString());
      
  }

  public static void method(int x, int y, int size) {
    int sp = arr[x][y];
    boolean flag = checkNumber(x, y, size, sp);

    if (flag) {
      if (sp == 0) sb.append(0);
      else sb.append(1);
      return;
    }

    int newSize = size/2;

    sb.append("(");
    method(x, y, newSize);
    method(x, y+newSize, newSize);
    method(x+newSize, y, newSize);
    method(x+newSize, y+newSize, newSize);
    sb.append(")");

  }

  public static boolean checkNumber(int x, int y, int size, int sp) {
    for (int i=x; i<x+size; i++) {
      for (int j=y; j<y+size; j++) {
        if (arr[i][j] != sp) {
          return false;
        }
      }
    }
    return true;
  }
}