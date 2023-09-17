import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이 1
     * 근손실 최값과 최소값의 합계들 중 최대값이 M으로 봅니다.
     * 만약 n이 홀수라면 가장 마지막 값은 제외하고 최소 + 최대값을 구한다.
     **/

    private static void solution(BufferedReader br) throws IOException {
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long[] arr = new Long[n];
        for (int i=0; i<n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        // 정렬
        long[] sortedArr = Arrays.stream(arr)
                .sorted(Comparator.reverseOrder())
                .mapToLong(Long::longValue)
                .toArray();

        long max = 0;

        // 홀수인 경우
        if (n%2 == 1) {
            max = sortedArr[0];
            for (int i=1; i<=n/2; i++) {
                long sum = sortedArr[i] + sortedArr[n - i];
                max = Math.max(sum, max);
            }
        }
        // 짝수인 경우
        else {
            for (int i=0; i<=n/2; i++) {
                long sum = sortedArr[i] + sortedArr[n - 1 - i];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}