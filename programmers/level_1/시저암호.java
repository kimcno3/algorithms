package programmers.level_1;

// 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class 시저암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
            }
            else if (Character.isUpperCase(c)) {
                sb.append((char) ((c - 'A' + n) % 26 + 'A'));
            }
            else if (Character.isLowerCase(c)) {
                sb.append((char) ((c - 'a' + n) % 26 + 'a'));
            }

        }
        return sb.toString();
    }
}
