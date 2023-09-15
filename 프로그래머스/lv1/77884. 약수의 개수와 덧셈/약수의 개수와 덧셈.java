import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left; i<=right; i++) {
            double sqrt = Math.sqrt((double) i);
            if (sqrt == Math.floor(sqrt)) {
              answer -= i;
            } else {
              answer += i;
            }
        }
        return answer;
      }
}