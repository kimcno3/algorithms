class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int number : numbers) {
          sb.append(number);
        }

        for (int i=0; i<=9; i++) {
          if (!sb.toString().contains(String.valueOf(i))) {
            answer += i;
          }
        }

        return answer;
        
    }
}