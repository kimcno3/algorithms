package v1.programmers.level_2;

import java.util.*;

// 짝지어 제거하기 : https://programmers.co.kr/learn/courses/30/lessons/12973
public class RemoveCouple {

  public static void main(String[] args) {
    // System.out.println(solution("baabaa"));
    // System.out.println(solution("sdsd"));

    System.out.println(solution2("baabaa"));
    System.out.println(solution2("sdsd"));
  }
  // 1차 시도
  public static int solution(String s) {
    int answer = -1;
    boolean flag = true;
    String[] arr;
    int length;

    while(flag) {
      arr = s.split("");
      length = s.length();

      for (int i=0; i<length-1; i++) {
        // 붙어있는 같은 문자열이 있는 경우
        if (arr[i].equals(arr[i+1])) {
          // 두 문자열을 제외한 나머지 문자열을 모두 추가하고 종료
          s = s.replace(arr[i] + arr[i+1], "");
          break;
        }
      }

      // 붙어있는 문자열이 없어 루프 전의 문자열과 같은 경우
      if (length == s.length()) {
        answer = 0;
        flag = false;
      }

      // 문자열이 모두 지워져 0이 된 경우
      else if (s.length() == 0) {
        answer = 1;
        flag = false;
      }
    }
    return answer;
  }
  // 2차 시도
  public static int solution2(String s){
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char ch : arr) {
      // stack 에 담긴 값이 없다면 push
      if (stack.size() == 0) {
        stack.push(ch);
        continue;
      }
      // 같은 값이 들어올 경우 pop, 그 외의 경우는 push
      if(stack.peek() == ch)  {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    // stack의 길이가 0이면 모든 문자열을 제거했다는 뜻 , 그 외의 경우는 실패
    if (stack.size() == 0) {
      return 1;
    } else {
      return 0;
    }

  }

}
