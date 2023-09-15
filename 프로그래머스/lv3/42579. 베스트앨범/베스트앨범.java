import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            map.putIfAbsent(genre, new TreeMap<>());
            map.get(genre).putIfAbsent(i, play);
        }

        map.entrySet().stream()
                .sorted((e1, e2) ->
                        e2.getValue().values().stream().mapToInt(Integer::intValue).sum()
                                - e1.getValue().values().stream().mapToInt(Integer::intValue).sum())
                .forEach(e -> {
                    List<Integer> collect = e.getValue().entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList());

                    if (collect.size() >= 2) list.addAll(collect.subList(0, 2));
                    else list.addAll(collect);
                });

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}