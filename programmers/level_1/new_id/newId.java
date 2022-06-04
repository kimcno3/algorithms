package programmers.level_1.new_id;

import java.util.Locale;

// 신규 아이디 추천 : https://programmers.co.kr/learn/courses/30/lessons/72410?language=java
public class newId {

  public static void main(String[] args) {
    System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
    System.out.println(solution("z-+.^."));
    System.out.println(solution("=.="));
    System.out.println(solution("123_.def"));
    System.out.println(solution("abcdefghijklmn.p"));
  }

  public static String solution(String new_id) {
    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    String answer = new_id.toLowerCase();

    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    answer = answer.replaceAll("[^a-z 0-9-_.]", "");

    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    answer = answer.replaceAll("[.]{2,1000}", ".");

    // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    StringBuilder sb = new StringBuilder(answer);

    int firstIdx = sb.indexOf(".");
    if (firstIdx == 0) {
      sb.delete(firstIdx, firstIdx + 1);
    }

    int lastIdx = sb.lastIndexOf(".");
    if (lastIdx != -1 && lastIdx == sb.length()-1) {
      sb.delete(lastIdx, sb.length());
    }

    // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    if (sb.length() == 0) {
      sb.append('a');
    }

    // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    if (sb.length() >= 16) {
      sb.delete(15, sb.length());
    }

    // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    if (sb.lastIndexOf(".") == sb.length()-1) {
      sb.delete(sb.lastIndexOf("."), sb.length());
    }

    // sb.toString().replaceAll("^[.] | [.]$", "");

    // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    if (sb.length() <= 2) {
      String lastStr = sb.toString().split("")[sb.length() - 1];
      while(sb.length() < 3) {
        sb.append(lastStr);
      }
    }

    answer = sb.toString();
    return answer;
  }
}
