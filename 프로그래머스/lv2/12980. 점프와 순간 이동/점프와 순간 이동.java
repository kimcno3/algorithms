import java.util.*;

/* 문제 해석
 * 1. 첫 시작을 위해 jump + 1은 필수
 * 2. n 이 짝수일 경우 -> n/2 만큼의 거리만 오면 순간이동으로 바로 도착 가능
 * 3. n 이 홀수일 경우 -> n-1만큼 이동 후 jump 1회 필요
 */

/* 풀이 방법
 * 1. n을 2로 나눈다.
 * 2. 나머지가 있다면(n이 홀수라면) -> 나머지 1만큼 한칸 Jump를 해야 하는 상황이므로 answer++
 * 3. 나머지가 없다면(n이 짝수라면) -> n이 홀수가 될 때까지 반복
 * 4. 마지막에 n이 1인 경우는 자동으로 answer++ 되며 마무리
 */

/* 소감
 * BFS 나 DFS 문제가 아닌 단순 계산 문제였고 Top-Down 방식으로 해결해야 하는 문제였다.
 */

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int currentNumber = n;
        while (currentNumber > 0) {
            if (currentNumber % 2 != 0) answer++;
            currentNumber /= 2;
        }
        return answer;
    }
}