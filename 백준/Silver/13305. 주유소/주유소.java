import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * 풀이 1
       * 도시 1에서 4까지 갈 수 있는 최대 비용을 충전
       * 도시 1~2까지 비용 + 2~4까지 갈 수 있는 최대 비용
       * 도시 1~2 / 2~3까지의 비용 + 3~4까지 가는 최대 비용
     * 문제점
       * 만약 다음 도시에서 주유비가 싸다면 최소값이 나올 수 없다.
     */

    private static void solutionFail(BufferedReader br) throws IOException {
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

    /**
     * 풀이 2
        * 현재 도시 주유비 > 다음 도시 주유비 -> 다음 도시까지만 주유
        * 현재 도시 주유비 <= 다음 도시 주유비 -> 주유비가 높은 도시까지 계속 이동할 수 있도록 주유
     */

    private static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] roads = new int[n-1];
        for (int i=0; i<roads.length; i++) {
            int distance = Integer.parseInt(st.nextToken());
            roads[i] = distance;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] cities = new int[n];
        for (int i=0; i<cities.length; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int minOil = 1000000000;
        for (int i=0; i<n-1; i++) {
            int currentOil = cities[i];
            // 최소 기름값보다 싸다면 해당 기름값을 minOil로 변경
            minOil = Math.min(minOil, currentOil);
            // 최소 기름값으로 이동
            answer += minOil * roads[i];
        }
        System.out.println(answer);
    }
}