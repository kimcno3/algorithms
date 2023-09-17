import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이 1
        * 인출시간이 가장 오래 걸리는 사람이 먼저 진행하게 되면 남은 사람만큼 대기 시간도 길어집니다.
        * 그래서 가장 인출시간이 빠른 사람부터 진행하는 것이 최소 대기 시간입니다.
     **/

    private static void solution(BufferedReader br) throws IOException {
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer[] arr = new Integer[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += arr[i];
            answer += sum;
        }

        System.out.println(answer);
    }
}