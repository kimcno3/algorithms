import java.util.*;

class Solution {

  public int[] solutionV2(String s) {
    // 반복 회수
    int cycleCount = 0;
    // 전체 0 개수
    int totalZeroCount = 0;
    // 1만 남을때 까지
    while(!s.equals("1")) {
      // 루프 별 0의 개수
      int zeroCount = 0;
      // 0의 개수 체크
      for (char ch : s.toCharArray()) {
        if (ch == '0') zeroCount++;
      }
      // SB를 사용하지 않는다면? 이전 s의 길이에서 0의 개수를 빼주면 된다.
      s = Integer.toBinaryString(s.length() - zeroCount);
      // 전체 0 개수 추가
      totalZeroCount += zeroCount;
      // 반복 횟수 추가
      cycleCount++;

    }

    return new int[]{cycleCount, totalZeroCount};
  }

  public int[] solution(String s) {

    int cntBinary = 0;
    int cntZero = 0;
    StringBuilder c;

    while (true) {

      c = new StringBuilder();

      // 0을 제거한 c를 생성
      for (String str : s.split("")) {

        if (str.equals("0")) {
          cntZero++; // 0 개수 count
        } else {
          c.append("1"); // 1만 추가
        }

      }

      // c의 길이를 이진법으로 치환한 값을 s에 새로 저장
      s = Integer.toBinaryString(c.length());
      cntBinary++; // 이진법 치환 횟수 count

      // 만약에 치환된 s가 1이면 loop 종료
      if (s.equals("1")) {
        break;
      }

    }

    return new int[]{cntBinary, cntZero};

  }
}