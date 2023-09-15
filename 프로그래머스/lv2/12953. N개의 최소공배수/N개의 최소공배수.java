import java.util.*;

    /* 최대공약수, 유클리드 호제법 사용 시
    
     * 풀이 방법
       * A,B의 최소 공배수를 구하고 싶을 때 (A * B / gcd(A, B))로 구한다.
       * gcd(최소공약수)를 구할 때 유클리드 호제법을 사용한다.
       
     * 참고자료 : https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-N%EA%B0%9C%EC%9D%98-%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98-Java
     */

class Solution {
    public int solution(int[] arr) {
        // 1 ~ 100 중에서 소수 값만 모아보기 -> 숫자의 범위는 정해져 있어서 가능
        Set<Integer> set = getPrimeSet();
        // arr에 담겨있는 숫자를 소수로 나누는 작업
        Map<Integer, Integer> map = getLcmMap(arr, set);
        // 구한 총 소수의 종류와 개수를 모두 곱한다.
        return getLcm(map);
    }

    private Set<Integer> getPrimeSet() {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        for (int i=3; i<=100; i++) {
            boolean isPrime = true;
            for (int j=2; j<i; j++) {
                if (i%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) set.add(i);
        }
        return set;
    }

    private Map<Integer, Integer> getLcmMap(int[] arr, Set<Integer> set) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            Map<Integer, Integer> map2 = new HashMap<>();
            // 숫자별 소수가 몇개씩 들어가는 지 체크
            while(n > 1) {
                for (int s : set) {
                    if (n % s == 0) {
                        n = n/s;
                        map2.put(s, map2.getOrDefault(s, 0) + 1);
                        break;
                    }
                }
            }
            // 체크한 소수의 개수를 기존 소수 개수와 비교해 업데이트
            for (int key : map2.keySet()) {
                if (map.getOrDefault(key, 0) < map2.get(key)) {
                    map.put(key, map2.get(key));
                }
            }
        }
        return map;
    }

    private int getLcm(Map<Integer, Integer> map) {
        int answer = 1;
        for (int key : map.keySet()) {
            answer *= Math.pow(key, map.get(key));
        }
        return answer;
    }
}