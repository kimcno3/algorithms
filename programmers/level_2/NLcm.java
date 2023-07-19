package programmers.level_2;

import java.util.*;

/** 문제 출처
 * https://school.programmers.co.kr/learn/courses/30/lessons/12953
 */

public class NLcm {

    public static void main(String[] args) {
        NLcm n = new NLcm();
        System.out.println(n.solution(new int[]{2,6,8,14}));
        System.out.println(n.solution(new int[]{1,2,3}));
        System.out.println(n.solution(new int[]{7,9,11}));
    }

    /** 최대공약수, 유클리드 호제법 사용 시
     * 출처 : https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-N%EA%B0%9C%EC%9D%98-%EC%B5%9C%EC%86%8C%EA%B3%B5%EB%B0%B0%EC%88%98-Java
     * 풀이 방법
       * A,B의 최소 공배수를 구하고 싶을 때 (A * B / gcd(A, B))로 구한다.
       * gcd(최소공약수)를 구할 때 유클리드 호제법을 사용한다.
     */
    public int solution2(int[] arr) {
        int answer = 0;

        if(arr.length == 1) return arr[0]; //원소가 한 개인 경우 바로 출력

        int g = gcd(arr[0], arr[1]); //처음 두 원소의 최대공약수
        answer = (arr[0] * arr[1]) / g; //처음 두 원소의 최소공배수

        /*
        원소의 개수가 3개 이상인 경우
        앞의 두 원소의 최소 공배수와 다음 원소의 최소 공배수를 구하며
        배열의 끝까지 반복
        */

        if(arr.length > 2) {
            for(int i = 2; i < arr.length; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }

        return answer;
    }

    //최대 공약수
    private static int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }

    /** 내가 푼 문제 풀이 방식
     * 1. 최소공배수를 구하기 위해선 각각의 숫자를 모두 소수로 나눈다.
     * 2. 각각의 소수가 몇개씩 필요한 지 계산한다.
     * 3. 다른 숫자에서 같은 소수가 나올 경우, 개수가 더 많은 쪽으로 결정한다.

     * 예시)
     - 2 = 2 / 6 = 2 * 3 / 8 = 2 * 2 * 2 / 14 = 2 * 7
     - 8에서 2가 3번 나왔으니 2는 3번 곱한다.
     - 그래서 2 * 2 * 2 * 3 * 7 가 최소공배수가 된다.
     */

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
