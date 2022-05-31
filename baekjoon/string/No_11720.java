package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자의 합(https://www.acmicpc.net/problem/11720)
public class No_11720 {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int result = 0;

    int length = Integer.valueOf(bf.readLine());
    String[] arr = bf.readLine().split("");

    for (int i=0; i<length; i++) {
      result += Integer.valueOf(arr[i]);
    }

    System.out.println(result);

  }
}
