import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        ArrayList<String> englishList = new ArrayList<>();

        englishList.add(0,"zero");
        englishList.add(1, "one");
        englishList.add(2, "two");
        englishList.add(3, "three");
        englishList.add(4, "four");
        englishList.add(5, "five");
        englishList.add(6, "six");
        englishList.add(7, "seven");
        englishList.add(8, "eight");
        englishList.add(9, "nine");

        String[] arrStr = s.split("");
        StringBuilder tempStr = new StringBuilder();
        StringBuilder result = new StringBuilder();
        // s를 하나씩 받아 온다.
        for (int i=0; i< arrStr.length; i++) {
          // 숫자가 바로 나온 경우 -> 그대로 result 에 추가
          if (arrStr[i].matches("[0-9]")) {
            result.append(arrStr[i]);
          }
          // 문자열일 경우 -> 숫자로 치환하는 과정이 필요
          else {
            // 임시 문자열에 추가
            tempStr.append(arrStr[i]);
            // 현재시점까지 모인 임시 문자열과 숫자 영단어를 비교
            for (int j=0; j<englishList.size(); j++) {
              // 현재까지 모아온 문자열이 숫자 영단어 중 하나와와 일치하면 해당 인덱스를 result에 추가
              if (tempStr.toString().equals(englishList.get(j))) {
                result.append(j);
                // 임시 문자열은 비워준다.
                tempStr.delete(0,tempStr.length());
              }
            }
          }
        }
        // 문자열로 저장된 result를 숫자 타입의 answer로 치환
        int answer = Integer.valueOf(result.toString());
        return answer;
  }
}