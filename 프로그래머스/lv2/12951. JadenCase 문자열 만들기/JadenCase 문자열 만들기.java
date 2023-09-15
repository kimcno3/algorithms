import java.util.*;

public class Solution {

  public String solution(String s) {

    String answer = "";
    // 문자열 전체를 소문자로 변경하고 split
    String[] arr = s.toLowerCase(Locale.ROOT).split(" ");

    for (String str : arr) {
      // 첫번째 문장을 변수에 저장
      String firstStr = str.split("")[0];
      // 첫번째 문장이 나오는 가장 첫번째 인덱스의 문자열만 대문자로 변경
      str = str.replaceFirst(firstStr, firstStr.toUpperCase(Locale.ROOT));
      // 빈칸과 함께 answer에 추가
      answer += str + " ";

    }
    // answer의 문자열 길이가 s보다 길다면 이전 빈칸 문자가 하나 추가되었다는 의미
    if (answer.length() > s.length()) {
      // 해당 조건에서만 trim()으로 앞뒤 빈킨 문자를 제거
      answer = answer.trim();
    }

    return answer;

  }

}