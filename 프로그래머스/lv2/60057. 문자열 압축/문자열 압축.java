class Solution {
  public int solution(String s) {
    int answer = s.length();

    // 나눌 문자 개수
    for (int i=1; i<=s.length()/2; i++) {
      int count = 1;
      String currentStr = "";
      StringBuilder sb = new StringBuilder();
      // String 인덱스
      for (int j=0; j<Math.ceil((double) s.length()/i); j++) {
        String tempStr;
        // 마지막 나머지 문자열
        if (j*i+i > s.length()) {
          tempStr = s.substring(j*i);
        } else {
          // 개수에 맞게 나눈 문자
          tempStr = s.substring(j*i, j*i+i);
        }

        if (j == 0) {
          currentStr = tempStr;
          continue;
        }

        if (currentStr.equals(tempStr)) {
          count++;
        } else {
          if (count != 1) {
            sb.append(count);
          }
          sb.append(currentStr);
          currentStr = tempStr;
          count = 1;
        }
      }

      if (count != 1) {
        sb.append(count);
      }
      sb.append(currentStr);
      
      if (sb.length() < answer) {
        answer = sb.length();
      }

    }

    return answer;
  }
}