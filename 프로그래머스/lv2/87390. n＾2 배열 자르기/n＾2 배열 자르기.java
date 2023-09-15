import java.util.*;

class Solution {
    
    /** 풀이 1
     * 0. 큐에 차례대로 숫자를 추가하기로 결정
     * 1. 첫 번째 줄은 1을 1번 추가 그 뒤로 +1씩 추가
     * 2. 두 번째 줄은 2를 2번 추가하고 그 뒤로 +1씩 추가
     * 3. 위 방식을 n 번째 줄까지 반복
     * 4. left 만큼 앞에서부터 pop
     * 5. right - left + 1 만큼 리스트에 차례대로 add
     * 6. list를 array로 변환해 리턴
     */
    public Integer[] solutionFail1(int n, long left, long right) {
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
        // left만큼 앞단에서 제거
        for (int i=0; i<left; i++) {
            queue.pop();
        }
        // list에 정답 숫자들을 add
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<right-left+1; i++) {
            list.add(queue.pop());
        }
        // list로 변환해 처리
        return list.toArray(new Integer[0]);
    }

    /** 문제점 1
     * 배열의 크기가 기하급수적으로 커질 경우, 메모리 이슈가 발생하므로 left ~ right 범위 내에서만 처리하는 방법을 생각해봐야 한다.
     */


    /** 풀이 2
     * 1. 시작 행, 열과 끝 행열을 미리 구하고 2중 루프로 진행한다.
     * 2. 시작 행,열부터 시작해서 i, j 중 더 큰값의 +1 만큼 answer에 차례대로 추가해준다.
     * 3. 끝 행, 열에 도착하면 루프 종료
     */
    public int[] solutionFail2(int n, long left, long right) {

        long si = left/n; // 시작 행
        long sj = left%n; // 시작 열
        long fi = right/n; // 끝 행
        long fj = right%n; // 끝 열

        int[] answer = new int[(int) (right - left + 1)]; // 정답의 길이는 right - left + 1
        int idx = 0; // answer에서 사용될 인덱스값
        boolean flag = false; // 반복문 종료를 의미

        for (long i=si; i<n; i++) {
            for (long j=0; j<n;j++) {
                // left 지점까지 가지 못했다면 시작하지 않는다.
                if (i == si && j < sj) continue;
                // i,j 중 더 큰 값의 +1만큼 데이터 추가
                if (i >= j) answer[idx++] = (int) i+1;
                else answer[idx++] = (int) j+1;
                // right 지점까지 도착했다면 flag를 true로 변경하고 루프 종료
                if (i == fi && j == fj) {
                    flag = true;
                    break;
                }
            }
            // 루프 종료
            if (flag) break;
        }

        return answer;
    }

    /** 문제점 2
     * 2중 루프가 발생하므로 좋은 코드가 아니다. 시간 복잡도가 N^2이기 때문!
     */

    /** 풀이 3 -> 링크 참고(https://taehoung0102.tistory.com/93)
     * 1. left ~ right+1 까지 가면서 몫과 나머지 중 더 큰 값 + 1을 리스트에 추가해준다.
     */
    public List<Long> solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }

        return list;
    }
}