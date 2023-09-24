import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * <풀이>
     * 뒤에서부터 생각해본다.
     * 현재 값이 최대값보다 크다면? 최대값을 변경한다. answer는 그대로
     * 현재 값이 최대값과 동일하다면? 최대값에서 현재값을 뺀 값만큼 answer에 +
     * 현재 값이 최대값과 작다면? 최대값에서 현재값을 뺀 값만큼 answer에 +
     **/

    private static void solution(BufferedReader br) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            for (int j=0; j<n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = arr[n-1];
            long answer = 0;

            for (int j=n-2; j>=0; j--) {
                if (arr[j] <= max) answer += max - arr[j];
                else max = arr[j];
            }
            System.out.println(answer);
        }
    }
}