package v1.baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 완전 이진 트리 : https://www.acmicpc.net/problem/9934
public class No_9934 {

  static int n;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  // 1. 노드 레벨별 노드 개수에 맞게 저장을 위한 2중 리스트 생성
  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    for (int i=0; i<n; i++) {
      list.add(i, new ArrayList<>());
    }

    String[] split = br.readLine().split(" ");
    arr = new int[split.length];

    for (int i=0; i<arr.length; i++) {
      arr[i] = Integer.parseInt(split[i]);
    }

    method(0, arr.length-1, 0);

    // 3. 가장 상위 노드부터 순서대로 sb에 저장 및 출력
    for (ArrayList<Integer> tempList : list) {
      for (Integer i : tempList) {
        sb.append(i).append(" ");
      }
      // 4. 레벨 하나가 끝나면 줄바꿈
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void method(int sIdx, int lIdx, int depth) {
    int cIdx = (sIdx+lIdx)/2;

    // 2. 노드 레벨별로 노드 값을 저장
    list.get(depth).add(arr[cIdx]);

    if (depth == n-1) {
      return;
    }

    method(sIdx, cIdx-1, depth+1);
    method(cIdx+1, lIdx, depth+1);
  }
}
