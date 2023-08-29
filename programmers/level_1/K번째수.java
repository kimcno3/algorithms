package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K번째수 {
    public Integer[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        for (int[] command : commands) {
            int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(arr);
            list.add(arr[command[2] - 1]);
        }
        return list.toArray(new Integer[0]);
    }
}
