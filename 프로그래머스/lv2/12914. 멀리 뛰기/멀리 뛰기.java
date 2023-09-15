class Solution {
    
    /* 풀이 방법 1 : DP
       * i ~ N까지 반복문을 실행한다.
       * i/2 만큼 answer에 + 해준다.
     
     * 문제점
       * 숫자별 answer 수를 잘못 샜다....
     */

    public long solutionFail(int n) {
        long answer = 0;
        for (int i=1; i<=n; i++) {
            if (i == 1) answer++;
            else answer += i/2;
        }
        return answer;
    }

    /* 풀이 방법 2
       * 피보나치 수열로 접근
     */

    public long solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<=n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
        }
        return arr[n];
    }
}