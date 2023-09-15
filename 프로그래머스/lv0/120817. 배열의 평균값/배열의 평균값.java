import java.math.BigDecimal;

class Solution {
  public double solution(int[] numbers) {
    BigDecimal sum = BigDecimal.ZERO;
    double answer = 0;

    for (int number : numbers) {
      sum = sum.add(BigDecimal.valueOf(number));
    }
    
    answer = sum.divide(BigDecimal.valueOf(numbers.length)).doubleValue();
    return answer;
  }
}