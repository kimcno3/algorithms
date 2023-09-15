package v1.programmers.level_2;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 *
 * 이미 방문한 던전이거나 더 이상 들어갈 수 없는 던전만 남았다면? 루프 종료 후 수행한 던전 수를 체크해야 한다.(44번 라인)
 * 이를 생각하지 못해서 실패 케이스가 많이 발생했다.
 */

public class 피로도 {

    private static boolean[] visits;
    private static int answer;

    public int solution(int k, int[][] dungeons) {
        // 던전 숫자 만큼 visit 배열 생성
        visits = new boolean[dungeons.length];
        // 재귀식
        recursion(dungeons, 0,  k);
        // answer 리턴
        return answer;
    }

    private void recursion(int[][] dungeons, int depth, int k) {
        // 던전 수를 넘어간 경우 : 해당 루프 종료
        if (depth > dungeons.length) return;
        // 처음부터 루프 진행
        for (int i=0; i<dungeons.length; i++) {
            // 탐험할 던전의 피로도 조건
            int minHp = dungeons[i][0];
            int minusHp = dungeons[i][1];
            // 이미 탐험한 던전과 최소 피로도보다 적은 피로도만 남았다면 continue
            if(visits[i] || k < minHp) continue;
            // 해당 던전 방문 처리
            visits[i] = true;
            // 재귀 : depth + 1, 피로도 - 소모 피로도
            recursion(dungeons, depth + 1, k - minusHp);
            // 재귀가 끝난 후 미방문 처리
            visits[i] = false;
        }
        // 이미 탐험했고 들어갈 수 없는 던전만 있다면 해당 depth가 최대 던전 수!
        answer = Math.max(answer, depth);
    }
}
