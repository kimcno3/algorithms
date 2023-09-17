import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이 1
     * 가장 많은 양의 에너지 드링크에 다른 나머지 모든 에너지 드링크를 붓는다.
     * 최대량의 에너지 드링크를 제외하고 모든 에너지 드링크는 1/2만큼 된다.
     * 점화식 : ((전체합 - 최대) / 2) + 최대
     **/

    private static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer[] arr = new Integer[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);
        // 전체 합계
        double sum = Arrays.stream(arr)
                    .mapToDouble(Integer::doubleValue)
                    .sum();
        // 최대량의 에너지 드링크
        double max = arr[n-1];
        // 점화식 계산
        double answer = ((sum - max) / 2) + max;
        // 결과 리턴
        System.out.println(answer);
    }
}