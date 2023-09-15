import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int idx = 0; // 토글 형식으로 변환해보자!
        boolean isUpper = true;
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
}