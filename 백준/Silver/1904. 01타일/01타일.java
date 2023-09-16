import java.io.*;

/*
 * dp 문제인지도 몰랐다...
 * 유형별 문제를 풀어야 할 듯 하다. 감이 잡힐 때까지
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        
        System.out.println(dp[n]);
    }
}