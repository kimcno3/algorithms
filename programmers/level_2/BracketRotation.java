package programmers.level_2;

import java.util.*;

// 괄호 회전하기 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class BracketRotation {

  // q : s를 문자열로 담아두고 회전시키기 위한 큐
  LinkedList<Character> q = new LinkedList();

  public int solution(String s) {

    int answer = 0;

    // 1. s를 q에 담는다.
    for (int i=0; i<s.length(); i++) {
      q.add(s.charAt(i));
    }

    // st : 회전된 q마다 괄호를 담아 올바른 괄호인지 검증하기 위한 스택
    Stack<Character> st;

    // 2. 1칸씩 회전 -> 회전 횟수는 0 ~ length-1까지
    for (int i=0; i<s.length(); i++) {

      // 3. 회전시마다 st는 초기화
      st = new Stack<>();

      // 4. 큐에 담긴 값을 차례로 루프
      for (char str : q) {

        // 5. 스택이 비어 있을 경우, push
        if (st.isEmpty()) {
          st.push(str);
        }

        // 6. 종류 별 닫는 괄호일 경우, 스택에 가장 먼저 들어간 괄호가 짝이 맞는 괄호라면 pop

        // 6-1. ()의 경우
        else if (str == ')') {
          if (st.peek() == '(') {
            st.pop();
          }
        }

        // 6-2. {}의 경우
        else if (str == '}') {
          if (st.peek() == '{') {
            st.pop();
          }
        }

        // 6-3. []의 경우
        else if (str == ']'){
          if (st.peek() == '[') {
            st.pop();
          }
        }

        // 6-4. 그 외 경우는 push [ex) 스택에 괄호가 존재하는데 다른 여는 괄호일 경우..]
        else {
          st.push(str);
        }

      }

      // 7. 해당 회전 회차에서 큐에 대한 루프를 다 돈 이후, 스택이 비어있다면 올바른 괄호 모음인 경우로 판단
      if (st.isEmpty()) {
        answer++;
      }

      // 8. 탐색을 마친 이후, 맨 앞 괄호를 맨 뒤로 이동 (큐를 회전시키기 위한 로직)
      q.add(q.removeFirst());

    }

    return answer;
  }


}
