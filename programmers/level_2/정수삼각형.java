package programmers.level_2;

import java.util.Arrays;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */

public class 정수삼각형 {

    private static int[][] dp;

    public int solution(int[][] triangle) {
        int answer = 0;
        // dp 생성
        dp = new int[triangle.length][triangle[triangle.length - 1].length];
        // 초기값 지정
        for (int[] arr :dp) {
            // 꼭대기 층은 삼각형의 값으로 지정
            if (arr.length == 1) dp[0][0] = triangle[0][0];
            // 그 외 값은 아직 계산하지 않았으므로 -1로 지정
            Arrays.fill(arr, -1);
        }
        // 순차적으로 최대값을 저장
        for (int y=1; y<triangle.length; y++) {
            for (int x=0; x<triangle[y].length; x++) {
                // 경우 1 : 왼쪽 자식 노드의 경우
                if (dp[y - 1][x] != -1) dp[y][x] = Math.max(dp[y][x], triangle[y][x] + dp[y - 1][x]);
                // 오른쪽 노드가 없는 x==0인 경우는 여기서 건너뛴다.
                if (x < 1) continue;
                // 경우 2 : 오른쪽 자식 노드의 경우
                if (dp[y - 1][x - 1] != -1) dp[y][x] = Math.max(dp[y][x], triangle[y][x] + dp[y - 1][x - 1]);
            }
        }
        // 가장 하단에 저장된 값들 중 최대 값을 선정
        for (int num : dp[dp.length-1]) {
            answer = Math.max(num, answer);
        }
        // 결과 리턴
        return answer;
    }
}
