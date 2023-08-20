package programmers.level_2;

import java.util.*;
public class 삼각달팽이 {

    /**
     * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68645
     */

    public int[] solution(int n) {
        // 0. 이동할 총 거리를 구한다.
        int max = 0;
        for (int i=1; i<=n; i++) {
            max += i;
        }
        // 1. 채워넣을 배열을 생성한다.
        int[][] arr = new int[n][n];

        // 2. 세가지 방향을 정한다.(순서대로 아래, 오른쪽, 왼쪽 위 대각선) -> dx, dy로 설정해도 좋다.
        // 첫 시작은 아래쪽부터 시작
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, -1}};
        int currentDirection = 0;

        // 3. 정한 방향대로 이동하면서 값을 채워넣는다.
        // 3-1. 시작점 세팅
        int[] currentPoint = new int[]{0, 0};
        int num = 1;
        arr[0][0] = num;

        // 4. max 까지 순차적으로 데이터를 2차 배열에 넣는다.
        while(num++ < max) {
            // 4-1. 최초 예상되는 다음 이동 위치
            int[] expectNextPoint = new int[]{currentPoint[0] + directions[currentDirection][0], currentPoint[1] + directions[currentDirection][1]};

            // 4-2. 다음 위치가 이동이 불가해 방향을 바꿔야 하는 경우 체크
            // 1) x, y 값이 배열을 넘어가는 경우
            // 2) 다음에 이동할 위치가 이미 지나온 자리인 경우
            if (expectNextPoint[0] >= n || expectNextPoint[1] >= n || arr[expectNextPoint[0]][expectNextPoint[1]] != 0) {
                // if (currentDirection == 2) currentDirection = 0;
                // else currentDirection += 1;
                currentDirection = (currentDirection + 1) % 3;
            }

            // 4-3. 변경된 방향에 맞게 다음 이동 위치 새로 지정
            int[] realNexPoint = new int[]{currentPoint[0] + directions[currentDirection % 3][0], currentPoint[1] + directions[currentDirection][1]};

            // 4-4. 다음 위치 변경 및 데이터 추가
            currentPoint = realNexPoint;
            arr[currentPoint[0]][currentPoint[1]] = num;

        }

        // 5. 2차 배열을 순차적으로 조회하면서 1차 배열에 순서대로 데이터를 저장
        int[] answer = new int[max];
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<i+1; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        // 6. 결과값 리턴
        return answer;
    }

}
