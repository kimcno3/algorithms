package v1.programmers.level_1;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12930
 *
 * 빈칸을 기준으로 인덱스를 초기화하는 방식에서 토글형식을 생각하지 못함
 * boolean을 활용해 구분하는 것이 데이터 양이 많아졌을 때 유리할 것으로 보인다.
 */

public class 이상한문자만들기 {
    public String solutionWithBoolean(String s) {
        StringBuilder sb = new StringBuilder();

        boolean isUpper = true; // 토글 형식으로 구현한 경우
        for (char ch : s.toCharArray()) {
            if (!Character.isAlphabetic(ch)) {
                sb.append(ch);
                isUpper = true;
            }
            else {
                if (isUpper) sb.append(Character.toUpperCase(ch));
                else sb.append(Character.toLowerCase(ch));
                isUpper = !isUpper;
            }
        }

        return sb.toString();
    }

    public String solutionWithIndex(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = 0; // 토글 형식으로 변환해보자!
        for (char ch : s.toCharArray()) {
            if (!Character.isAlphabetic(ch)) {
                sb.append(ch);
                 idx = 0;
            }
            else {
                 if (idx % 2 == 0) sb.append(Character.toUpperCase(ch));
                else sb.append(Character.toLowerCase(ch));
                 idx++;
            }
        }

        return sb.toString();
    }

}
