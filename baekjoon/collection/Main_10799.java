package baekjoon.collection;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_10799 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    String[] arr = sc.next().split("");
    LinkedList<String> list = new LinkedList<>();
    int result = 0;

    for (int i=0; i<arr.length; i++) {
      String currentStr = arr[i];
      if (list.size() == 0 || currentStr.equals("(")) {
        list.push(currentStr);
      }
      if (currentStr.equals(")")) {
        String lastStr = list.pop();
        if (lastStr.equals("(")) result += list.size();
        else result += 1;
      }
    }
    System.out.println(result);
  }
}
