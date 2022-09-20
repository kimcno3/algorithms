package programmers.level_2;

// 이진변환 반복하기 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class BinaryRepeat {

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
