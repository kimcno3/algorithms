import java.io.*;
import java.util.*;

public class Main {

    static int bnpCurrentMoney;
    static int timingCurrentMoney;
    static int bnpCount;
    static int timingCount;
    static int currentPrice;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int total = sc.nextInt();
        bnpCurrentMoney = total;
        timingCurrentMoney = total;

        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()) {
            list.add(sc.nextInt());
        }

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
                // 매도
                if (subList.get(0) < subList.get(1) && subList.get(1) < subList.get(2) && timingCount > 0) {
                    timingCurrentMoney = timingCount*currentPrice;
                    timingCount = 0;
                }
                // 매수
                else if (subList.get(0) > subList.get(1) && subList.get(1) > subList.get(2) && currentPrice <= timingCurrentMoney) {
                    timingCount += timingCurrentMoney/currentPrice;
                    timingCurrentMoney = timingCurrentMoney%currentPrice;
                }
            }
        }

        int bnpTotalPrice = currentPrice * bnpCount + bnpCurrentMoney;
        int timingTotalPrice = currentPrice * timingCount + timingCurrentMoney;

        if (bnpTotalPrice > timingTotalPrice) System.out.println("BNP");
        else if (bnpTotalPrice < timingTotalPrice) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}