import java.io.*;
import java.util.*;

public class Main {

    static int totalDate;
    static int[] listT = new int[20];
    static int[] listP = new int[20];
    static int[] dp = new int[20];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        totalDate = sc.nextInt();

        int idx = 0;
        while (sc.hasNext()) {
            listT[idx] = sc.nextInt();
            listP[idx] = sc.nextInt();
            idx++;
        }

        for (int i=totalDate-1; i>=0; i--) {
            // 남은 일수보다 상담 가능 일수가 더 작아야 한다.
            if (listT[i] > totalDate - i) {
                dp[i] = dp[i + 1];
            } else{
                // 해당 일자를 포함해서 얻을 수 있는 최고 기대 수익
                int expectPay = listP[i] + dp[i + listT[i]];
                // 기존 수익과 비교해 해당 일자를 포함할 때 더 큰 이득을 얻을 수 있다면 포함한다.
                dp[i] = Math.max(dp[i + 1], expectPay);
            }
        }
        System.out.println(dp[0]);
    }
}