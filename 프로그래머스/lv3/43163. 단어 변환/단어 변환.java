import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {

        // 변환할 수 없는 경우에는 0 리턴
        if (!checkExist(words, target)) return 0;

        int answer = -1;
        boolean[] visits = new boolean[words.length];
        // 큐에 들어갈 자료구조 : 현재 변환된 단어의 인덱스, 변환 횟수
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{-1, 0});
        // 큐가 빌 때까지 루프를 돈다.
        while(!queue.isEmpty()) {
            // 현재 큐 가져온다.
            int[] current = queue.pop();
            // 현재 단어와 변환 횟수를 변수로 만든다.
            String word = getWord(begin, words, current);
            int count = current[1];
            // 만약 현재 단어가 타겟일 경우 종료한다.
            if (word.equals(target)) return count;
            // 타겟이 아니라면 루프를 돌면서 전체 단어와 비교한다.
            for (int i=0; i<words.length; i++) {
                // 이미 변경된 단어라면 제외
                if (visits[i]) continue;
                // 변환이 가능한지 검증
                if (!checkChange(word, words[i])) continue;
                // 변환이 가능하다면 방문 처리
                visits[i] = true;
                // 큐에 추가
                queue.add(new int[]{i, count+1});
            }

        }

        return answer;
    }

    private boolean checkExist(String[] words, String target) {
        for (String word : words) {
            if (target.equals(word)) return true;
        }
        return false;
    }

    private String getWord(String begin, String[] words, int[] current) {
        if (current[0] == -1) return begin;
        else return words[current[0]];
    }

    private boolean checkChange(String word, String testWord) {

        int limit = 0;

        for (int i=0; i<word.length(); i++) {
            // 한개 이상 틀리다면 변경이 불가능하다고 판단
            if (word.charAt(i) != testWord.charAt(i)) limit++;
        }

        return limit <= 1;

    }

}