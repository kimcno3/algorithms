package v1.programmers.level_2;

import java.util.Arrays;

/* 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
 *
 * 혼자 풀이 실패
 * 정렬, 탐욕법 문제로 요격 범위의 가장 끝점을 기준으로 탐색을 진행하는 것이였다. (유사 문제 : 감시 카메라)
 * 요격 범위는 포함하지 않기 때문에 이를 포함해 요격 범위에서 제외시켜줘야 한다.(30번 라인)
 */

public class 요격시스템 {
    public int solution(int[][] targets) {

        int answer = 0;
        int yk = -1;

        // 끝점을 기준으로 오름차순 정렬
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        // 타겟 별 마지막 지점을 기준으로 판단
        for (int[] target : targets) {
            // 첫 타겟이라면 무조건 추가
            if (yk == -1) {
                yk = target[1]; // 타겟 마지막 점
                answer++; // 답 + 1
                continue;
            }
            // 해당 타겟이 요격 범위 내에 속한다면 continue
            if (target[0] < yk && yk <= target[1]) continue;
            // 아니라면 요격 범위를 최신화하고 answer + 1
            yk = target[1];
            answer++;
        }
        return answer;
    }
}
