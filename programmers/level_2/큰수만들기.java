package programmers.level_2;

import java.util.*;

public class 큰수만들기 {
    public String solution(String number, int k) {
        // Stack 생성
        LinkedList<Character> stack = new LinkedList<>();
        // 문자열을 char[]로 변환
        char[] nums = number.toCharArray();
        // 초기 값 세팅
        stack.addFirst(nums[0]);
        // 루프 진행
        for (int i=1; i<nums.length; i++) {
            // 들어올 숫자가 있는 숫자보다 작거나 같은 경우
            if (stack.getLast() >= nums[i]) {
                stack.addLast(nums[i]);
            }
            // 들어올 숫자가 있는 숫자보다 큰 경우
            else {
                // 비어있지 않거나
                while(!stack.isEmpty() && k != 0 && stack.getLast() < nums[i]) {
                    stack.removeLast();
                    k--;
                }
                stack.addLast(nums[i]);
            }
        }
        // k가 0이 되기 이전에 루프가 종료되면 남은 개수만큼 뒤에서 숫자를 빼준다.
        while(k-- > 0) {
            stack.removeLast();
        }
        // String으로 변환
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 리턴
        return sb.toString();
    }
}
