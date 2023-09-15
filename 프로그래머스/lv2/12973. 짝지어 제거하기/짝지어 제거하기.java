import java.util.*;

class Solution{
    public int solution(String s){
        int answer = -1;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : arr) {
          if (stack.size() == 0) {
            stack.push(ch);
            continue;
          }
          if(stack.get(stack.size()-1) == ch)  {
            stack.pop();
          } else {
            stack.push(ch);
          }
        }
        if (stack.size() == 0) {
          answer = 1;
        } else {
          answer = 0;
        }
        return answer;
    }
}