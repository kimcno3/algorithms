package v1.programmers.level_3;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 *
 * 풀이 방식
   * 온전히 문제를 풀지 못했다. 교제 참고해서 힌트를 얻어 구현한 코드
   * 연결된 노드의 방문 체크를 통해 연결된 네트워크 수를 체크하는 방식을 생각해 내지 못했다.
 */
public class 네트워크 {

    private boolean[] visits;
    private int answer;

    public int solution(int n, int[][] computers) {

        visits = new boolean[computers.length];

        // 컴퓨터 별로 루프
        for (int node=0; node<computers.length; node++) {
            // 이미 체크한 컴퓨터라면 제외
            if (visits[node]) continue;
            // 재귀 함수 호출 -> 각각의 컴퓨터 별로 네트워크 연결된 컴퓨터를 내부에서 방문 처리
            recursion(n, computers, computers[node]);
            // 더 이상 연결된 컴퓨터가 없어서 재귀를 빠져나오면 answer + 1
            answer++;
            // 다음 컴퓨터 체크 시, 이미 방문된 컴퓨터는 제외된다...!
        }

        return answer;
    }

    private void recursion(int n, int[][] computers, int[] computer) {

        for (int i=0; i<computer.length; i++) {
            // 이미 체크한 컴퓨터이거나 네트워크 연결이 되지 않은 경우는 제외
            if (visits[i] || computer[i] == 0) continue;
            // 연결된 상태라면 방문 체크
            visits[i] = true;
            // 해당 컴퓨터로 재귀 호출
            recursion(n, computers, computers[i]);
        }

    }
}
