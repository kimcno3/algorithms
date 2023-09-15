package v1.baekjoon.implementationAndSimulation.No14889;

import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/14889
 * 참고 자료 : https://st-lab.tistory.com/122
 * 풀이 방식 : DFS, 재귀 함수
 * 느낀점
 * visits를 사용해야 한다는 것과 이미 선택된 선수는 선택되지 못해야 한다는 것까지는 고려했지만 구현에 실패
 * 두 팀의 합계를 구하는 방식을 구현 실패
 */

public class Main {

    static int m;
    static int[][] arr;
    static boolean[] visits;
    static int answer = Integer.MAX_VALUE;;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 총 인원 수
        m = sc.nextInt();
        // 인원 별 선택 여부 판별을 위한 배열
        visits = new boolean[m];
        // 선수 조합 별 능력치 2차 배열
        arr = new int[m][m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // 합계 비교(DFS, 재귀함수)
        checksum(0, 0);
        // 최종 결과값 리턴
        System.out.println(answer);
    }

    static void checksum(int depth, int sp) {
        // 정확히 반만큼의 인원이 선정되었을 때
        if (depth == m/2) {
            // 두 팀의 합계를 비교해 가장 작은 격차를 업데이트
            setMinsum();
            return;
        }
        // 재귀적 동작 : 이미 방문한 인덱스일 경우는 제외
        for (int i=sp; i<m; i++) {
            if (!visits[i]) {
                visits[i] = true;
                checksum(depth+1, i+1); // 이미 선택된 선수는 선택할 수 없게 +1을 시켜준다.
                visits[i] = false;
            }
        }
    }

    static void setMinsum() {
        int teamA = 0;
        int teamB = 0;
        // 팀 별 능력치 합계 계산
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                // i 선수와 j 선수가 모두 선택된 선수인 경우
                if(visits[i] && visits[j]) teamA += arr[i][j];
                    // i 선수와 j 선수가 모두 선택되지 않은 선수인 경우
                else if (!visits[i] && !visits[j]) teamB += arr[i][j];
                //  그 외 경우는 같은 팀이 아니기 때문에 제외
            }
        }
        // 두 팀의 격차의 절대값과 answer 중 최소값을 갱신
        answer = Math.min(answer, Math.abs(teamA - teamB));
    }
}