package v1.baekjoon.recursion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The Big Dance : https://www.acmicpc.net/problem/6012
public class No_6012 {

  static int[] arr;
  static int sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];

    for (int i=0; i<arr.length; i++) {
      arr[i] = i+1;
    }

    method(0, n);
    System.out.println(sum);

  }

  public static void method(int sIdx, int size) {
    if (size == 1) {
      return;
    }
    if (size == 2) {
      sum += arr[sIdx] * arr[sIdx+1];
      return;
    }

    int newSize = (int) Math.ceil((double) (size)/2);

    method(sIdx, newSize);
    method(sIdx+newSize, size-newSize);

  }

}
