package v1.programmers.level_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기 {

    /** 문제 풀이 : 자료구조 활용
     * 1. map으로 귤 종류 별 개수를 계산
     * 2. 귤 종류 별 개수를 기준으로 귤 종류를 내림차순 정렬
     * 3. 정렬된 귤의 개수를 차례대로 계산해서 최소 종류 수를 리턴(귤이 많은 순서대로 카운트)
     */

    public int solution(int k, int[] tangerine) {
        // 귤 크기 별로 개수를 계산
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // 귤 개수를 기준으로 귤 크기 종류를 정렬(내림차순)
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((k1, k2) -> map.get(k1).compareTo(map.get(k2))); // 오름차순
        list.sort((k1, k2) -> map.get(k2).compareTo(map.get(k1))); // 내림차순

        // 정렬한 귤 크기 순서대로 귤 개수를 세고 k개 만큼 차면 break;
        int answer = 0;
        int sum = 0;
        for (int i : list) {
            if (sum >= k) break;
            sum += map.get(i);
            answer++;
        }

        // 최종 귤 종류 개수를 리턴
        return answer;
    }
}
