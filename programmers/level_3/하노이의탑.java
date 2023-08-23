package programmers.level_3;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {

    List<int[]> list;

    public int[][] solution(int n) {
        list = new ArrayList<>();
        recursion(n, 1, 3);
        return list.toArray(new int[list.size()][]);
    }

    private void recursion(int n, int from, int to) {
        // n이 1인 경우에만 해당 경우를 리스트에 추가
        if (n == 1) {
            list.add(new int[]{from, to});
            return;
        }
        // 비어있는 기둥을 찾는 점화식
        int empty = 6 - from - to;
        // n-1만큼의 원판을 empty로 이동
        recursion(n-1, from, empty);
        // 남아있는 하나의 원판을 to로 이동
        recursion(1, from, to);
        // n-1만큼의 원판을 to로 이동
        recursion(n-1, empty, to);
    }
}
