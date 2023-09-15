package v1.programmers.level_3;

// 등굣길 : https://school.programmers.co.kr/learn/courses/30/lessons/42898

/*
 * 효율성 검사에서 실패
 */
public class GoToSchool {

  public int solution(int m, int n, int[][] puddles) {

    int answer = 0;

    // dp 배열을 생성
    int[][] dp = new int[n][m];

    // 잠긴 지역 루프를 돌면서 체크 -> -1로 체크하겠습니다.
    for (int[] puddle : puddles) {
      dp[puddle[1] - 1][puddle[0] - 1] = -1;
    }

    dp[0][0] = 1;

    for (int i=0; i<n; i++) {

      for (int j=0; j<m; j++) {

        if (dp[i][j] == -1) {
          continue;
        }

        if (i - 1 >= 0 && dp[i-1][j] != -1) {
          dp[i][j] += dp[i - 1][j]; // 위 칸
        }

        if (j - 1 >= 0 && dp[i][j-1] != -1) {
          dp[i][j] += dp[i][j-1]; // 왼 칸
        }
      }

    }

    return dp[n-1][m-1] % 1000000007;

  }

}
