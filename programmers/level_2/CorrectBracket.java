package programmers.level_2;

import java.util.Stack;

/* 올바른 괄호 : https://school.programmers.co.kr/learn/courses/30/lessons/12909
 *
 * 몇가지 아쉬운 부분
   * split()을 활용해 문자열을 배열로 만들지 말고 charAt()을 활용해야 한다.
     * 효율성 테스트 실패의 원인!!
     * charAt() 내부 구현 코드를 보면 String 객체에 저장된 byte[] 배열을 활용해 그대로 값을 리턴
     * split()은 복잡한 로직 과정을 거친다.(결국 새로운 배열을 만드내는 과정)

   * Stack 문제는 LinkedList 가 아니라 Stack 자료구조를 사용하는 것을 추천한다.
   * LinkedList 계열 자료구조는 empty()가 있다.
 */

public class CorrectBracket {

  boolean solution(String s) {

    Stack<Character> stack = new Stack<>();

    for (int i=0; i<s.length(); i++) {

      // 열림 괄호가 들어온 경우
      if (s.charAt(i) == '(') {
        stack.push(s.charAt(i));
      }

      // 닫음 괄호가 들어온 경우
      else {
        // stack에 저장된 열림 괄호가 없는데 닫힘 괄호가 들어온 경우니 false 리턴
        if (stack.isEmpty()) {
          return false;
        }
        // stack에 저장된 열림 괄호가 있다면 pop
        else {
          stack.pop();
        }
      }

    }
    // 루프가 끝난 후 stack에 남은 열림 괄호가 있디면 false 리턴
    if (stack.isEmpty()) {
      return true;
    }

    return false;
  }

}
