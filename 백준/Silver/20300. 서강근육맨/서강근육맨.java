import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이
        * 내림차순 정렬한 상태에서 맨 앞, 맨 뒤를 더한 값이 가장 작은 값이며, 이 합계들 중 가장 큰 값이 최소 범위입니다.
     * 구현 순서
        * 내림차순 정렬
        * n이 짝수라면
           * i번 째와 n-i번 째 값의 합계들 중 가장 큰 값을 찾는다.
        * n이 홀수라면
           * 첫번 째(가장 큰 값)을 초기 max값으로 지정
           * i번째 와 n-i번 째 값의 합계들 중 가장 큰 값을 찾는다.
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