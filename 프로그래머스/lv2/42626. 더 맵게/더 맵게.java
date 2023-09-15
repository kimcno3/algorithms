import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : scoville) {
          queue.add(num);
        }

        while(queue.size() >= 2 && queue.peek() < k) {
          int num1 = queue.poll();
          int num2 = queue.poll();
          int newScoville = num1 + (num2 * 2);
          queue.add(newScoville);
          answer++;
        }

        if(queue.size() == 1 && queue.poll() < k) {
          answer = -1;
        }

        return answer;
    }
}