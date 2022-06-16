package programmers;


public class Solution {

  public static void main(String[] args) {
    System.out.println(solution("aabbaccc"));
  }
  public static int solution(String s) {
    int answer = 0;

    // 나눌 문자 개수
    for (int i=1; i<=s.length()/2; i++) {
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
      }
    }

    return answer;
  }
}
