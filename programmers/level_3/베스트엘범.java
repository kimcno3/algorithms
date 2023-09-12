package programmers.level_3;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/42579

 * 느낀 점 : 
    * 거의 2시간 넘게 걸린 풀이...
    * 최대한 Stream을 통해 간결한 코드를 작성하는 것을 목표로 구현한 문제

 * 풀이 :
     * 1. {장르별 : {노래 인덱스 : 플레이 수}} 의 형태로 자료구조 구성
     * 2. 노래 인덱스는 작은 순으로 기본 조회가 되도록 TreeMap을 활용
     * 3. 장르별 플레이수를 기준으로 오름차순 정렬
     * 4. 정렬된 장르별로 들어가 각각의 노래들의 플레이 수를 기준으로 오름차순 정렬
     * 5. 정렬된 키값만을 가지고 collect를 리스트 형태로 생성
     * 6. 생성된 collect의 길이에 따라 최대 앞에서 2개까지 순서대로 추가
 */

public class 베스트엘범 {

    public int[] solution(String[] genres, int[] plays) {
        // 자료구조 생성
        Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // 초기값 구성
        for (int i=0; i<genres.length; i++) {
            map.putIfAbsent(genres[i], new TreeMap<>()); // 장르별로 TreeMap을 저장
            map.get(genres[i]).putIfAbsent(i, plays[i]); // 저장된 TreeMap에 노래별로 플레이수를 저장
        }
        // 베스트 엘범 구성 로직
        map.entrySet().stream()
                .sorted((e1, e2) -> reverseOrder(e1, e2)) // 장르를 플레이수 기준으로 오름차순 정렬
                .forEach(e -> makeBestAlbum(e, list)); // 가장 플레이수가 많은 장르부터 순차적으로 베스트 엘범에 들어간 노래를 선정
        // list -> 배열로 전환해 리턴
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int reverseOrder(Map.Entry<String, TreeMap<Integer, Integer>> e1, Map.Entry<String, TreeMap<Integer, Integer>> e2) {
        // 각 장르에 있는 TreeMap에 있는 value들의 총합 -> 오름차순 정렬
        return e2.getValue().values().stream().mapToInt(Integer::intValue).sum()
                - e1.getValue().values().stream().mapToInt(Integer::intValue).sum();
    }

    private static void makeBestAlbum(Map.Entry<String, TreeMap<Integer, Integer>> e, List<Integer> list) {
        List<Integer> collect = e.getValue().entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue()) // 플레이 수를 기준으로 노래들을 오름차순 정렬
                .map(Map.Entry::getKey) // 키값으로만 변경
                .collect(Collectors.toList()); // 리스트로 재생성

        if (collect.size() >= 2) list.addAll(collect.subList(0, 2)); // 만약 2개 이상의 노래가 존재한다면 최대 2개까지만 리스트에 추가
        else list.addAll(collect); // 그 외는 모두 추가
    }

}
