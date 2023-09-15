import java.util.*;

class Solution {

  public int solution(int n, int a, int b) {

    int answer = 0;
    int round = 0;

    while (round < Math.getExponent(n)) {

      round++;

      if (a % 2 == 0) {
        a = a / 2;
      } else {
        a = a / 2 + 1;
      }

      if (b % 2 == 0) {
        b = b / 2;
      } else {
        b = b / 2 + 1;
      }

      // 같은 라운드에 묶였을 때
      if (a == b) {
        answer = round;
        break;
      }

    }

    return answer;

  }

}