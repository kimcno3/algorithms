package v1.programmers.level_2;

// 문자열 압축 : https://programmers.co.kr/learn/courses/30/lessons/60057
public class ReductionString {

  public static void main(String[] args) {
    System.out.println(solution("aabbaccc"));
  }

  public static int solution(String s) {
    // 처음 문자열 길이로 설정
    int answer = s.length();

    // 나눌 문자 개수(1개부터 - n/2개까지)
    for (int i=1; i<=s.length()/2; i++) {
      // 연속된 문자의 개수를 저장할 변수
      int count = 1;
      // 현재 연속되고 있는 문자열을 저장할 변수
      String currentStr = "";
      // 축소시킨 문자열을 저장할 변수
      StringBuilder sb = new StringBuilder();

      // 개수 별로 나눈 문자열에 대한 반복문
      for (int j=0; j<Math.ceil((double) s.length()/i); j++) {
        String tempStr;
        // 마지막 나머지 문자열일 경우
        if (j*i+i > s.length()) {
          // 남은 문자열 전부 저장
          tempStr = s.substring(j*i);
        }

        // 마지막 이전 문자열
        else {
          // 개수에 맞게 나눈 문자를 저장
          tempStr = s.substring(j*i, j*i+i);
        }

        // 첫 문자인 경우, 조건없이 현재 문자열로 지정
        if (j == 0) {
          currentStr = tempStr;
          continue;
        }

        // 연속된 문자열일 경우, 문자개수 추가
        if (currentStr.equals(tempStr)) {
          count++;
        }
        // 연속된 문자열이 아닐 경우
        else {
          // 문자 개수가 1 이상이면 숫자를 먼저 추가
          if (count != 1) {
            sb.append(count);
          }
          // 이후 해당 문자열 추가
          sb.append(currentStr);

          // 현재 문자열 변경
          currentStr = tempStr;
          // 문자 개수 초기화
          count = 1;
        }
      }

      //  마지막으로 계산된 문자열도 추가(중복)
      if (count != 1) {
        sb.append(count);
      }
      sb.append(currentStr);

      // 길이가 짧아졌다면 answer 값 변경
      if (sb.length() < answer) {
        answer = sb.length();
      }

    }
    return answer;
  }
}
