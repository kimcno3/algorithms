package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 트리 순회 : https://www.acmicpc.net/problem/1991
public class No_1991 {
  static int n;
  static HashMap<String, Boolean> visit = new HashMap<>();
  static HashMap<String, String[]> arr = new HashMap<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    for (int i=0; i<n; i++) {
      String[] split = br.readLine().split(" ");
      arr.put(split[0], new String[]{split[1], split[2]});
      visit.put(split[0], false);
    }

    // 전위 순회
    preorder("A");
    sb.append("\n");

    // 중위 순회
    inorder("A");
    sb.append("\n");

    // 후위 순회
    postorder("A");
    sb.append("\n");

    System.out.println(sb);
  }

   // 전위 순회 : (루트) (왼쪽 자식) (오른쪽 자식)
  public static void preorder(String node) {
    if (!visit.get(node)) {
      visit.put(node, true);
      sb.append(node);
    } else {
      return;
    }

    for (int i=0; i<2; i++) {
      String childNode = arr.get(node)[i];
      if (!childNode.equals(".")) {
        preorder(childNode);
      }
    }
    visit.put(node, false);
  }

  // 중위 순회 : (왼쪽 자식) (루트) (오른쪽 자식)
  public static void inorder(String node) {
    String left = arr.get(node)[0];
    String right = arr.get(node)[1];

    if (visit.get(node)) {
      return;
    }

    if (!left.equals(".")) {
      inorder(left);
    }

    visit.put(node, true);
    sb.append(node);

    if (!right.equals(".")) {
      inorder(right);
    }

    visit.put(node, false);

  }

  // 후위 순회 : (왼쪽 자식) (오른쪽 자식) (루트)
  public static void postorder(String node) {
    String left = arr.get(node)[0];
    String right = arr.get(node)[1];

    if (visit.get(node)) {
      return;
    }

    if (!left.equals(".")) {
      postorder(left);
    }

    if (!right.equals(".")) {
      postorder(right);
    }

    visit.put(node, true);
    sb.append(node);

    visit.put(node, false);

  }
}
