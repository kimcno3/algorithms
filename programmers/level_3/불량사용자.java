package programmers.level_3;

import java.util.*;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/64064
 */

public class 불량사용자 {

    private static Set<String> SET;
    private static List<String> USER_ID;
    private static List<String> BANNED_ID;
    private static boolean[] VISITS_USER;
    private static boolean[] VISITS_BANNED;


    public int solution(String[] user_id, String[] banned_id) {
        SET = new HashSet<>();
        USER_ID = new ArrayList<>(Arrays.asList(user_id));
        BANNED_ID = new ArrayList<>(Arrays.asList(banned_id));
        VISITS_USER = new boolean[USER_ID.size()];
        VISITS_BANNED = new boolean[BANNED_ID.size()];

        recursion(0, 0, 0);

        return SET.size();
    }

    private void recursion(int userDepth, int bannedDepth, int count) {

        if (userDepth == USER_ID.size() || bannedDepth == BANNED_ID.size()) {
            if (count == BANNED_ID.size()) {
                addSet();
            }
            return;
        }

        for (int i=0; i<USER_ID.size(); i++) {
            // 이미 방문한 경우
            if (VISITS_USER[i]) continue;

            VISITS_USER[i] = true;
            // 비교할 두 값이 같은 경우 -> user_id, banned_id 모두 다음으로
            if (checkSameId(i, bannedDepth)) {
                VISITS_BANNED[bannedDepth] = true;
                recursion(userDepth+1, bannedDepth+1, count+1);
                VISITS_BANNED[bannedDepth] = false;
            }
            // 그렇지 않다면 user_id만 다음으로
            else {
                recursion(userDepth+1, bannedDepth+1, count);
            }
            VISITS_USER[i] = false;
        }

    }

    private void addSet() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<USER_ID.size(); i++) {
            if (VISITS_USER[i]) {
                sb.append(i);
            }
        }
        SET.add(sb.toString());
    }

    private boolean checkSameId(int userDepth, int bannedDepth) {
        char[] userChars = USER_ID.get(userDepth).toCharArray();
        char[] bannedChars = BANNED_ID.get(bannedDepth).toCharArray();

        for (int i=0; i<bannedChars.length; i++) {
            // 두 아이디 길이가 다르면 false
            if (userChars.length != bannedChars.length) return false;
            // *은 우선 넘긴다
            if (bannedChars[i] == '*') continue;
            // 문자열 하나라도 다르면 false
            if (userChars[i] != bannedChars[i]) return false;
        }
        // 통과한 경우 true
        return true;
    }
}
