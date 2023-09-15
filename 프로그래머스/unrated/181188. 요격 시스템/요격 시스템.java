import java.util.*;

/* 
 * 혼자 풀이 실패
 * 정렬, 탐욕법 문제로 요격 범위의 가장 끝점을 기준으로 탐색을 진행하는 것이였다. (유사 문제 : 감시 카메라)
 * 요격 범위는 포함하지 않기 때문에 이를 포함해 요격 범위에서 제외시켜줘야 한다.
 */

class Solution {
    public int solution(int[][] targets) {
        
        int answer = 0;
        int yk = -1;
        
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        for (int[] target : targets) {
            // 타겟 별 마지막 지점을 기준으로 판단
            if (yk == -1) {
                yk = target[1];
                answer++;
                continue;
            }
            
            if (target[0] < yk && yk <= target[1]) continue;
            
            yk = target[1];
            answer++;   
        }


        return answer;
    }
}