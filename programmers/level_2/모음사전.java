package programmers.level_2;

import java.util.*;

public class 모음사전 {

    public int solutionV2(String s) {
        // 초기값 세팅
        List<String> words = new ArrayList<>();
        char[] chars = "AEIOU".toCharArray();
        // 재귀함수
        recursionV2("", words, chars);
        // 정답 리턴 -> words에서 s의 인덱스를 리턴
        return words.indexOf(s);
    }

    private void recursionV2(String word, List<String> words, char[] chars) {
        // 리스트에 새로운 단어 추가
        words.add(word);
        // 5 이상이면 재귀 종류
        if (word.length() == 5) return;
        // 반복적으로 추가
        for (char ch : chars) {
            recursionV2(word + ch, words, chars);
        }
    }

    private static String[] arr;
    private static String str;
    private static int answer;
    private boolean isOver;

    public int solution(String s) {
        // 초기값 세팅
        str = s;
        arr = new String[]{"A", "E", "I", "O", "U"};
        answer = 0;
        // 재귀함수
        recursion(0, new StringBuilder());
        // 정답 리턴
        return answer;
    }

    private void recursion(int depth, StringBuilder sb) {
        // 정답과 일치하면 종료
        if (sb.toString().equals(str)) {
            isOver = true;
            return;
        }
        // 최대 길이인 경우 + 정답은 아니라면 종료
        if (depth == 5) {
            return;
        }
        // 아직 길이가 남았고 정답이 아니라면 재귀함수 호출
        for (String s : arr) {
            if (isOver) return;
            // 카운트 추가
            answer++;
            // 재귀호출
            recursion(depth+1, sb.append(s));
            // 해당 함수 실행 후 sb에서 마지막 값은 삭제
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
