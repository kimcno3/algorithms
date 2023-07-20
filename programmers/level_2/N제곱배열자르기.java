package programmers.level_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N제곱배열자르기 {
    public static void main(String[] args) {
        N제곱배열자르기 n = new N제곱배열자르기();
        n.solution(3,2,5);
        n.solution(4,7,14);
    }

    /**
     * 배열의 크기가 기하급수적으로 커질 경우, 메모리 이슈가 발생하므로 left ~ right 범위 내에서만 처리하는 방법을 생각해봐야 한다.
     */
    public int[] solution2(int n, long left, long right) {
        return new int[0];
    }

    /** 풀이 방법 -> 시간, 메모리 초과
     * 0. 큐에 차례대로 숫자를 추가하기로 결정
     * 1. 첫 번째 줄은 1을 1번 추가 그 뒤로 +1씩 추가
     * 2. 두 번째 줄은 2를 2번 추가하고 그 뒤로 +1씩 추가
     * 3. 위 방식을 n 번째 줄까지 반복
     * 4. left 만큼 앞에서부터 pop
     * 5. right - left + 1 만큼 리스트에 차례대로 add
     * 6. list를 array로 변환해 리턴
     */
    public Integer[] solution(int n, long left, long right) {
        // 큐 추가
        LinkedList<Integer> queue = new LinkedList<>();
        // sp = 몇 번째 줄을 의미
        int sp = 0;
        while(sp < n) {
            // 해당 줄의 숫자를 해당 줄의 숫자만큼 추가
            for (int i=0; i<=sp; i++) {
                queue.addLast(sp+1);
            }
            // 그 뒤로는 +1 씩 추가
            for(int i=sp+1; i<n; i++) {
                queue.addLast(i+1);
            }
            // 줄 변경
            sp++;
        }
        System.out.println(queue);
        // left만큼 앞단에서 제거
        for (int i=0; i<left; i++) {
            queue.pop();
        }
        // list에 정답 숫자들을 add
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<right-left+1; i++) {
            list.add(queue.pop());
        }
        System.out.println(list);

        System.out.println();
        // list로 변환해 처리
        return list.toArray(new Integer[0]);
    }
}
