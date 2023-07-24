package programmers.level_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class 연속부분수열합의개수 {

    /** 출처
     * https://school.programmers.co.kr/learn/courses/30/lessons/131701
     */

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

    public int solution(int[] elements) {
        // 원소값을 큐에 추가
        LinkedList<Integer> queue = new LinkedList<>();
        for (int element : elements) {
            queue.add(element);
        }
        // 중복을 허용하지 않는 합계를 저장하기 위한 Set 추가
        Set<Integer> set = new HashSet<>();
        for (int n=0; n<elements.length; n++) {
            int sum = 0;
            for (int i=0; i<elements.length; i++) {
                // 누적되어 더해지는 합계를 Set에 저장
                sum += queue.get(i);
                set.add(sum);
            }
            // 시작점 변경
            queue.add(queue.pop());
        }
        // 중복이 저장된 합계 개수를 리턴
        return set.size();
    }
}
