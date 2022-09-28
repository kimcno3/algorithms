package programmers.level_2;

import java.util.Arrays;

// 게임 맵 최단거리 :
public class GameMinRoot {

  /* 성공 코드 https://velog.io/@taekkim/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B2%8C%EC%9E%84-%EB%A7%B5-%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC
   *
   * 힌트
     * 1. BFS로 문제 풀이
     * 2. 상하좌우 이동에 따른 인덱스 변경을 위해 배열을 선언해서 활용해보기
   *
   */

  public int solution(int[][] maps) {


    return 0;
  }


//--------------------------------------------------------------------------------------------------

  /* 실패 코드
   *
   * 1. 알고보니 BFS 문제였고 DFS로 풀다보니 효율성 테스트가 전부 실패(정확도 테스트는 통과)
   * 2. 상하좌우 이동에 따른 인덱스 위치 이동을 반복적인 코드로 작성해 비효율적으로 동작
   */

  int x,y;
  int[][] newMaps;
  boolean[][] visits;
  int[] endPoint;
  int answer;

  public int solutionFail(int[][] maps) {
    newMaps = maps;
    answer = Integer.MAX_VALUE;

    x = maps[0].length; // 가로
    y = maps.length; // 세로

    endPoint = new int[]{y-1, x-1}; // 도착지점
    visits = new boolean[y][x]; // 방문 여부 판단을 위한 boolean 2차 배열

    checkMinRoot(new int[]{0,0}, 1); // 위치는 항상 0,0 부터 칸은 시작지점까지 포함

    // 상대 진영까지 도착하지 못한 경우
    if (answer == Integer.MAX_VALUE) {
      return -1;
    }

    return answer;

  }

  public void checkMinRoot(int[] point, int step) {

    int pointX = point[1];
    int pointY = point[0];

    // 상대 진영에 도착한 경우
    if (Arrays.equals(point, endPoint)) {

      // 최소 거리일 경우
      if (answer > step) {
        // step 수를 answer에 추가
        answer = step;
      }

      return;

    }

    // 현재 위치가 0이라면 리턴해서 종료.
    if (newMaps[pointY][pointX] == 0) {
      return;
    }

    // 현재 위치가 아직 방문하지 않은 곳이라면 상하좌우 체크 시작
    if (!visits[pointY][pointX]) {

      visits[pointY][pointX] = true;

      // 위치 이동 시, 해당 경로에서 step 추가
      if (pointY > 0) {
        checkMinRoot(new int[]{pointY - 1, pointX}, step + 1); // 상
      }
      if (pointY < y-1) {
        checkMinRoot(new int[]{pointY + 1, pointX}, step + 1); // 하
      }
      if (pointX > 0) {
        checkMinRoot(new int[]{pointY, pointX - 1}, step + 1); // 좌
      }
      if (pointX < x-1) {
        checkMinRoot(new int[]{pointY, pointX + 1}, step + 1); // 우
      }

      visits[pointY][pointX] = false;

    }
  }

}
