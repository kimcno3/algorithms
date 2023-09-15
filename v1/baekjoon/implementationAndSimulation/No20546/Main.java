package v1.baekjoon.implementationAndSimulation.No20546;

import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/20546
 */
public class Main {

    static int bnpCurrentMoney;
    static int timingCurrentMoney;
    static int bnpCount;
    static int timingCount;
    static int currentPrice;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 초기 자산 설정
        int initTotalPrice = sc.nextInt();
        bnpCurrentMoney = initTotalPrice;
        timingCurrentMoney = initTotalPrice;

        // 1일 ~ 14일에 대한 주식 가격을 list에 추가
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()) {
            list.add(sc.nextInt());
        }

        // 일자 별 진행
        for(int i=0; i<list.size(); i++) {
            currentPrice = list.get(i);
            // BNP :첫날부터 가능한 모든 주식을 산다. 이후 매도는 없다. 매수만 동작
            if (currentPrice <= bnpCurrentMoney) {
                bnpCount = bnpCurrentMoney/currentPrice;
                bnpCurrentMoney = bnpCurrentMoney%currentPrice;
            }

            // TIMING : 전일 기준 3일치의 주식이 모두 상승곡선이면 그날 살 수 있는 모든 주식을 매수, 전일 기준 3일치 주식이 모두 하락곡선이면 전부 매도
            if (i >= 3) {
                List<Integer> subList = list.subList(i-3, i);
                // 매도 : 이전 3일이 연속으로 상승인 경우, 현재 가지고 있는 주식 수는 0보다 커야 한다.
                if (subList.get(0) < subList.get(1) && subList.get(1) < subList.get(2) && timingCount > 0) {
                    timingCurrentMoney = timingCount*currentPrice;
                    timingCount = 0;
                }
                // 매수 : 이전 3일이 연속으로 하락인 경우, 현재 가지고 있는 현금이 주식 가격보다 이상이여야 한다.
                else if (subList.get(0) > subList.get(1) && subList.get(1) > subList.get(2) && currentPrice <= timingCurrentMoney) {
                    timingCount += timingCurrentMoney/currentPrice;
                    timingCurrentMoney = timingCurrentMoney%currentPrice;
                }
            }
        }

        // 최종 자산 계산
        int bnpTotalPrice = currentPrice * bnpCount + bnpCurrentMoney;
        int timingTotalPrice = currentPrice * timingCount + timingCurrentMoney;

        // 계산된 자산에 따른 결과갋 리턴
        if (bnpTotalPrice > timingTotalPrice) System.out.println("BNP");
        else if (bnpTotalPrice < timingTotalPrice) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}
