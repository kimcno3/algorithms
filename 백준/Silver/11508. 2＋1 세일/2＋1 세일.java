import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이 1
     * 무조건 큰 가격이 할인되는 것이 이득이므로 가능하다면 무조건 3개씩 묶음으로 사야한다.
     * 내림차순으로 정렬해서 가장 가격이 높은 순으로 재배치한다.
     * 3의 배수 위치에 있는 값은 제외하고 더한다.(자연스럽게 제외 상품 지정)
     **/

    private static void solution(BufferedReader br) throws IOException {
        int answer = 0;

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] costs = Arrays.stream(arr)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i=1; i<=n; i++) {
            if (i%3 == 0) continue;
            answer += costs[i-1];
        }

        System.out.println(answer);
    }
}