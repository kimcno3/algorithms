package v1.baekjoon.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No_17413 {
  static StringBuilder result = new StringBuilder();
  static Stack<Character> stack = new Stack<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    boolean flag = false;

    for (int i=0; i<str.length(); i++) {
      // '<' 가 나온 경우
      if (str.charAt(i) == '<') {
        //  이전에 stack에 담긴 내용을 그대로 추가
        while (!stack.isEmpty()) {
          result.append(stack.pop());
        }
        // '<' 추가
        result.append(str.charAt(i));
        // 꺽쇠가 시작했다는 의미
        flag = true;
        continue;
      }
      // '>' 가 나온 경우
      else if (str.charAt(i) == '>') {
        // '>' 만 추가
        result.append(str.charAt(i));
        // 꺽쇠가 끝났다는 의미
        flag = false;
        continue;
      }
      // 꺽쇠에 들어가는 내용인 경우
      if (flag == true) {
        // 그대로 추가
        result.append(str.charAt(i));
      }
      // 꺽쇠에 들어가는 내용이 아닌 경우
      else {
        // 띄어쓰기가 나온 경우
        if (str.charAt(i) == ' ') {
          // 현재까지 나온 문자열을 뒤집어서 추가
          while (!stack.isEmpty()) {
            result.append(stack.pop());
          }
          // 띄어쓰기 추가
          result.append(" ");
          continue;
        }
        // 위 조건이 아닌 경우, stack에 문자열을 추가 -> 뒤집을 문자열 수집
        stack.push(str.charAt(i));
        // 마지막 문자열까지 검사한 경우 -> 남아있는 문자열을 뒤집어서 추가
        if (i == str.length() - 1) {
          while (!stack.isEmpty()) {
            result.append(stack.pop());
          }
        }

      }
    }
    // 결과 출력
    System.out.println(result);
  }
}
