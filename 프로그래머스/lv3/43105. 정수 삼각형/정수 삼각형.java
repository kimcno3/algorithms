import java.util.*;

class Solution {

    private static int[][] dp;

    public int solution(int[][] triangle) {
        int answer = 0;
        // dp 생성
        dp = new int[triangle.length][triangle[triangle.length - 1].length];
        // 초기화
        for (int[] arr :dp) {
            Arrays.fill(arr, -1);
        }
        dp[0][0] = triangle[0][0];
        // 순차적으로 최대값을 저장
        for (int y=1; y<triangle.length; y++) {
            for (int x=0; x<triangle[y].length; x++) {
                if (dp[y - 1][x] != -1) {
                    dp[y][x] = Math.max(dp[y][x], triangle[y][x] + dp[y - 1][x]);
                }
                if (x < 1) continue;
                if (dp[y - 1][x - 1] != -1) {
                    dp[y][x] = Math.max(dp[y][x], triangle[y][x] + dp[y - 1][x - 1]);
                }
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