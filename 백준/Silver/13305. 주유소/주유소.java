import java.util.*;
import java.io.*;

/**
 * 도시 1에서 4까지 갈 수 있는 최대 비용을 충전
 * 도시 1~2까지 비용 + 2~4까지 갈 수 있는 최대 비용
 * 도시 1~2 / 2~3까지의 비용 + 3~4까지 가는 최대 비용
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] roads = new int[n-1];
        int maxDistance = 0;

        for (int i=0; i<roads.length; i++) {
            int distance = Integer.parseInt(st.nextToken());
            maxDistance += distance;
            roads[i] = distance;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] cities = new int[n];

        for (int i=0; i<cities.length; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int postCost = 0;
        for (int i=0; i<n-1; i++) {
            int oilCost = cities[i];
            // 총 이동비용
            answer = Math.min(postCost + (oilCost * maxDistance), answer);
            // 이전 이동 비용
            postCost += oilCost * roads[i];
            // 가야하는 거리에서 이동한 거리 빼주기
            maxDistance -= roads[i];
        }
        System.out.println(answer);
    }
}