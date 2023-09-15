import java.util.*;

class Solution {

    private static int[][] arrs;
    private static int n;
    private static int[] answer;

    public int[] solution(int[][] arr) {

        // 초기값 세팅
        arrs = arr;
        n = arr.length;
        answer = new int[]{0, 0};
        // 재귀함수 진행
        recursion(n, 0, 0);
        // 결과 리턴
        return answer;
    }

    private void recursion(int n, int startX, int startY) {
        // n 이 1이거나 해당 배열의 모든 값이 동일한 경우
        if (n == 1 || checkALlSame(n, startX, startY)) {
            // 해당 배열의 시작점 값에 +1
            answer[arrs[startY][startX]] += 1;
            return;
        }

        // 위 조건에 맞지 않다면 다시 4등분
        int next = n/2;
        for (int y = startY; y < startY+n; y += next) {
            for (int x = startX; x < startX+n; x += next) {
                recursion(next, x, y);
            }
        }
    }

    // 해당 배열의 값들이 모두 동일한지 체크
    private boolean checkALlSame(int n, int startX, int startY) {
        for (int y = startY; y<startY+n; y++) {
            for (int x = startX; x<startX+n; x++) {
                if (arrs[y][x] != arrs[startY][startX]) {
                    return false;
                }
            }
        }
        return true;
    }
}