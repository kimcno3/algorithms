import java.util.*;

class Solution {
    public String solution(String number, int k) {
          
        LinkedList<Character> stack = new LinkedList<>();
        
        char[] nums = number.toCharArray();
        
        stack.addFirst(nums[0]);
        
        for (int i=1; i<nums.length; i++) {
            // 들어올 숫자가 있는 숫자보다 작거나 같은 경우
            if (stack.getLast() >= nums[i]) {
                stack.addLast(nums[i]);
            }
            else {
                while(!stack.isEmpty() && k != 0 && stack.getLast() < nums[i]) {
                    stack.removeLast();
                    k--;
                }
                stack.addLast(nums[i]);
            }
        }
        
        while(k-- > 0) {
            stack.removeLast();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
                
        return sb.toString();
    }
}