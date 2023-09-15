package v1.baekjoon.implementationAndSimulation.No14501;

import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/14501
 * 참고자료 : https://dinist.tistory.com/30
 * 설명 :
    * 브루트 포트 or DP 적용 가능 문제
    * Top-Down으로 접근해야 풀이가 가능했던 문제
    * 참고자료 답안을 참고해 풀이 완성
 * 느낀 점 : Collection이 답이 아니다.
 **/

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
            // 남은 일수보다 상담 가능 일수가 더 크다면 적용 불가. 이전 값을 그대로 사용
            if (listT[i] > totalDate - i) {
                dp[i] = dp[i + 1];
            } else{
                // 해당 일자를 포함해서 얻을 수 있는 최고 기대 수익 = 해당 일자 수익 + 해당 일자 다음으로 이동했을 때 얻을 수 있는 최고 수익
                int expectPay = listP[i] + dp[i + listT[i]];
                // 기존 수익과 비교해 해당 일자를 포함할 때 더 큰 이득을 얻을 수 있다면 해당 일자 수익을 dp에 저장
                dp[i] = Math.max(dp[i + 1], expectPay);
            }
        }
        System.out.println(dp[0]);
    }
}