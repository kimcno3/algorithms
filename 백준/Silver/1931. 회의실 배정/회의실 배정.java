import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * <풀이>
     * 끝나는 시간 기준으로 오름차순 정렬
     * 끝나는 시간보다 시작하는 시간이 길다면 카운트 + 1, 최대 끝나는 시간 업데이트
     * 회의 시작 시간과 끝나는 시간이 같다면 중복 처리가 되지 않도록 최대 끝나는 시간에 + 1을 더 해준다.
        * 4 4 다음 4 4 가 또 나오면 해당 회의는 잡을 수 없어야 하므로 4 5와 같게 본다는 것입니다.
     * <문제점>
     * 풀이 3번이 제대로 동작하지 않는다.
     * 종료 시간이 같다면 시작시간을 기준으로 정렬해주면 된다.
     **/

    static int answer = 0;
    static int max = 0;

    private static void solution(BufferedReader br) throws IOException {

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++) {
            String[] line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.stream(arr)
                // 끝나는 시간을 기준으로 오름차순 정렬하며 시작시간이 같다면 시작시간을 기준으로 오름차순 정렬을 합니다.
                .sorted((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1])
                // 하나씩 비교해가며 끝나는 시간의 최대값보다 시작시간이 같거나 크다면 answer++, 최대값 업데이트
                .forEach(c -> {
                    if (c[0] >= max) {
                        answer++;
                        // 회의 시작시간과 끝나는 시간이 같다면 같은 경우가 두번 이상 나오면 안되므로 +1을 더 해준다.
                        max = c[1];
                    }
                });
        // 결과 리턴
        System.out.println(answer);
    }
}