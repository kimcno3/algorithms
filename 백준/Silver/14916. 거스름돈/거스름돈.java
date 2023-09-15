import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        int maxFiveWon = n / 5;

        // 5원을 최대로 사용할 수 있는 경우부터 탐색
        for (int fiveWon = maxFiveWon; fiveWon >= 0; fiveWon--) {
            // 5원으로 계산 후 남은 금액
            int remain = n - (fiveWon * 5);
            // 맞아 떨어진다면, 5원 개수 + 2원 개수로 리턴
            if (remain % 2 == 0) {
                answer = fiveWon + (remain / 2);
                break;
            }
        }
        System.out.println(answer);
    }
}