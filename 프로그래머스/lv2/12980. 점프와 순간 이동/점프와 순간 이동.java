import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int currentNumber = n;
        while (currentNumber > 0) {
            if (currentNumber % 2 != 0) answer++;
            currentNumber /= 2;
        }
        return answer;
    }
}