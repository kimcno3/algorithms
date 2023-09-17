import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이 1
     * 가장 많은 비용을 주려고 한 사람을 가장 먼저 입장해야 마이너스 되는 비용을 최소화할 수 있습니다.
     * 팁을 계산했을 때 0 이하면 0원으로 치환합니다.
     **/

    private static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        int[] array = Arrays.stream(arr)
                .sorted(Comparator.reverseOrder()) // sorted()를 역순으로 하기 위해선 기본 타입이 아닌 참조 타입이여야 한다.
                .mapToInt(Integer::intValue) // 정렬 후 int Type으로 변환
                .toArray(); // 배열로 변경

        for (int i=1; i<=array.length; i++) {
            int tip = array[i - 1] - (i - 1); // 현재 입장할 사람의 예상 팁
            answer += Math.max(tip, 0); // 0 이하는 0으로 동결
        }
        System.out.println(answer);
    }
}