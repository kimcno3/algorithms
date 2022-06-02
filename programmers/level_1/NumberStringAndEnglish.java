package programmers.level_1;

import java.util.ArrayList;

// 숫자 문자열과 영단어 : https://programmers.co.kr/learn/courses/30/lessons/81301
public class NumberStringAndEnglish {

  public static void main(String[] args) {
//    System.out.println("one4seveneight = " + solution("one4seveneight"));
//    System.out.println("23four5six7 = " + solution("23four5six7"));
//    System.out.println("2three45sixseven = " + solution("2three45sixseven"));
//    System.out.println("123 = " + solution("123"));
//    System.out.println("2fourfive09eight = " + solution("2fourfive09eight"));
//    System.out.println("2twotwotwo = " + solution2("2twotwotwo"));

    System.out.println("one4seveneight = " + solution2("one4seveneight"));
    System.out.println("23four5six7 = " + solution2("23four5six7"));
    System.out.println("2three45sixseven = " + solution2("2three45sixseven"));
    System.out.println("123 = " + solution2("123"));
    System.out.println("2fourfive09eight = " + solution2("2fourfive09eight"));
    System.out.println("2twotwotwo = " + solution2("2twotwotwo"));
  }
  // solution1
  public static int solution(String s) {
    // 숫자 영단어 모음
    ArrayList<String> englishNumberList = new ArrayList<>();
    englishNumberList.add("zero");
    englishNumberList.add("one");
    englishNumberList.add("two");
    englishNumberList.add("three");
    englishNumberList.add("four");
    englishNumberList.add("five");
    englishNumberList.add("six");
    englishNumberList.add("seven");
    englishNumberList.add("eight");
    englishNumberList.add("nine");

    // 임시 저장 문자열 & 정답을 추가할 문자열
    StringBuilder tempStr = new StringBuilder();
    StringBuilder result = new StringBuilder();

    // s에 담긴 문자열을 하나씩 loop
    String[] arrStr = s.split("");
    for (int i = 0; i < arrStr.length; i++) {

      String currentStr = arrStr[i];

      // 숫자가 바로 나온 경우 -> 그대로 result 에 추가
      if (currentStr.matches("[0-9]")) {
        result.append(currentStr);
      }

      // 문자열일 경우 -> 숫자로 치환하는 과정이 필요
      else {
        // 임시 문자열에 추가
        tempStr.append(currentStr);

        // 현재시점까지 모인 임시 문자열과 숫자 영단어를 비교
        for (int j = 0; j < englishNumberList.size(); j++) {

          // 현재까지 모아온 문자열이 숫자 영단어 중 하나와와 일치하는 경우
          if (tempStr.toString().equals(englishNumberList.get(j))) {
            // 해당 인덱스를 result 에 추가
            result.append(j);
            // 임시 문자열은 비워준다.
            tempStr.delete(0, tempStr.length());
          }

        }

      }

    }
    // 문자열로 저장된 result 를 숫자 타입의 answer 로 치환
    int answer = Integer.valueOf(result.toString());
    return answer;
  }

  // solution2 : replace()를 사용하면 간단하게 해결
  public static int solution2(String s) {
    String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    for (int i=0; i<10; i++) {
      s = s.replace(numStr[i], num[i]);
    }
    return Integer.valueOf(s);
  }
}
