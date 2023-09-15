package v1.programmers.level_1;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */

public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        // 1. 최소, 최대 xy값을 초기 세팅한다.
        int minx = 51;
        int miny = 51;
        int maxx = 0;
        int maxy = 0;
        // 2. 세팅된 값을 순서에 맞게 answer에 초기값으로 설정한다.
        int[] answer = {minx, miny, maxx, maxy};
        // 3. y 루프
        for (int y=0; y<wallpaper.length; y++) {
            // 4. 행별 문자열을 char 배열로 변환
            char[] chars = wallpaper[y].toCharArray();
            // 5. x 루프
            for (int x=0; x<chars.length; x++) {
                // 6. # 인 경우만 체크
                if (chars[x] == '#') {
                    // 7. min의 경우, #이 포함되기 이전 인덱스이여야 하므로 인덱스 그대로 사용한다.
                    answer[0] = Math.min(y, answer[0]);
                    answer[1] = Math.min(x, answer[1]);
                    // 8. max의 경우, #이 포함되는 범위까지 가야하므로 인덱스 + 1을 사용한다.
                    answer[2] = Math.max(y+1, answer[2]);
                    answer[3] = Math.max(x+1, answer[3]);
                }
            }
        }
        return answer;
    }
}
