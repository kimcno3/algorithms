import java.util.*;

    /** 풀이 방식
     * 1. 원소들의 합계를 순차대로 구한다.
     * 2. 위처럼 더한 값들을 Set에 추가(중복값 제거)
     * 3. 시작점을 한칸씩 변경한다.(이를 위해 큐를 활용)
     * [예시] [7,9,1,1,4] 인 경우
     *   1) 7, 7+9, 7+9+1, 7+9+1+1, 7+9+1+1+4
     *   2) 9, 9+1, 9+1+1, 9+1+1+4, 9+1+1+4+7
     *   3) 1, 1+1, 1+1+4, 1+1+4+7, 1+1+4+7+9
     *   4) 1, 1+4, 1+4+7, 1+4+7+9, 1+4+7+9+1
     *   5) 4, 4+7, 4+7+9, 4+7+1+1, 4+7+9+1+1
     */

class Solution {
    public int solution(int[] elements) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int element : elements) {
            queue.add(element);
        }

        Set<Integer> set = new HashSet<>();

        for (int n=0; n<elements.length; n++) {
            int sum = 0;
            for (int i=0; i<elements.length; i++) {
                sum += queue.get(i);
                set.add(sum);
            }
            queue.add(queue.pop());
        }

        return set.size();
    }
}