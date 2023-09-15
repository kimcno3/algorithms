import java.util.*;

class Solution {

  // q : s를 문자열로 담아두고 회전시키기 위한 큐
  LinkedList<Character> q = new LinkedList();

  public int solution(String s) {

    int answer = 0;

    // 1. s를 q에 담는다.
    for (int i=0; i<s.length(); i++) {
      q.add(s.charAt(i));
    }

    // q2 : 회전된 q마다 괄호를 담아 올바른 괄호인지 검증하기 위한 스택
    Stack<Character> st;

    // x칸씩 회전
    for (int i=0; i<s.length(); i++) {

      st = new Stack<>();

      for (char str : q) {

        if (st.isEmpty()) {
          st.push(str);
        }

        else if (str == ')') {
          if (st.peek() == '(') {
            st.pop();
          }
        }

        else if (str == '}') {
          if (st.peek() == '{') {
            st.pop();
          }
        }

        else if (str == ']'){
          if (st.peek() == '[') {
            st.pop();
          }
        }

        else {
          st.push(str);
        }

      }

      if (st.isEmpty()) {
        answer++;
      }

      q.add(q.removeFirst());

    }

    return answer;
  }

}