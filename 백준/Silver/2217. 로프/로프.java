import java.util.*;
import java.io.*;

/** 풀이 과정
     * 최대 중량 = 가장 작은 중량 * 루프의 수
     * 가장 작은 중량보다 큰 중량을 들게 되면 결국 해당 루프는 끊어질 수 밖에 없기에 가장 작은 중량이 기준이 됩니다.
     * 그 중량을 루프의 개수만큼 나눠든다면 그 값이 최대 중량이 됩니다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int min = 100000;
        int answer = 0;
        // 루프 하나씩 조회
        for (int i=n-1; i>=0; i--) {
            min = Math.min(arr[i], min); // 루프들 중 최소 중량
            answer = Math.max(min * (n-i), answer); // 최소 중량을 루프 수로 곱한 값과 이전 최대 중량을 비교
        }
        // 결과 출력
        System.out.println(answer);
    }
}