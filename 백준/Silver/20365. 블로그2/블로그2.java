
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * <풀이>
     * 가장 적은 수요로 계산하는 방법 -> 전체 색을 한번 칠한 후, 연속된 색깔의 단락 수 중에 더 적은 값을 더한다. (minCount + 1)
     * 한번의 루프로 B의 개수와 R의 개수를 샌다.
     * 주의할 점은 연속으로 나올 경우는 하나로 치기 때문에 카운트에서 제외한다.
     * 즉, 앞의 색과 달라지는 경우 해당 색깔에 +1
     * 개수를 샌 다음, 더 적은 수에 + 1을 한다.
     * <문제점>
     *
     **/

    private static void solution(BufferedReader br) throws IOException {

        int n = Integer.parseInt(br.readLine());

        char[] arr = new char[n];
        char[] chars = br.readLine().toCharArray();
        for (int i=0; i<n; i++) {
            arr[i] = chars[i];
        }
        // B, R의 개수 초기화
        int countB = 0;
        int countR = 0;
        // 첫번 째 값은 미리 넣어준다.
        if (arr[0] == 'B') countB++;
        else countR++;
        // 두번 째 값부터 비교 후 카운트
        for (int i=1; i<n; i++) {
            // 앞에 색깔과 다른 경우 -> 해당 색깔에 카운트
            if (arr[i-1] != arr[i]) {
                if (arr[i] == 'B') countB++;
                else countR++;
            }
        }
        // 더 적은 값의 색깔 색에 + 1
        int answer = Math.min(countR, countB) + 1;
        // 결과 리턴
        System.out.println(answer);
    }
}