package programmers.level_2;

import java.util.Arrays;
import java.util.LinkedList;


/*
 * 힌트
 * 1. BFS로 문제 풀이
 * 2. 상하좌우 이동에 따른 인덱스 변경을 위해 배열을 선언해서 활용해보기
 *
 */

// 게임 맵 최단거리 : https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class GameMinRoot {

  /* <BFS 활용 코드>
   *
   * 상하좌우 위치를 탐색 방법
   * 2중 배열에 상,하,좌,우 이동시 변경되는 인덱스 차이를 따로 저장하고 루프를 통해 검증하도록 구현
   * 예외상황
   * 블럭값이 0인 경우, 큐 추가 제외
   * visits = true 인 경우 큐 추가 제외
   *
   * block count는 어떻게
   * 1. 큐에 값이 추가 될때만 +1씩 한다 (X) -> 결국 다른 루트의 큐도 count에 포함된다.
   * 2. 큐에 저장되는 int 배열에 count 값을 추가 (O)
   */

  // 상,좌,하,우 순으로
  int[][] moveIndexs = new int[][]{{-1,0}, {0,-1}, {1,0}, {0,1}};
  boolean[][] visits;
  int m,n,answer;

  public int solution(int[][] maps) {

    visits = new boolean[maps.length][maps[0].length];
    LinkedList<int[]> queue = new LinkedList<>(); // 큐 활용

    // 최대 인덱스값 생성
    m = maps.length-1;
    n = maps[m].length-1;

    answer = Integer.MAX_VALUE;

    // 0,0 부터 큐에 추가하고 시작한다.
    int[] startIndex = new int[]{0, 0, 1};
    queue.add(startIndex);

    // 큐가 비어있을 때 까지 루프
    while(!queue.isEmpty()) {

      // 현재 위치 정보 가져오기
      int[] currentIndex = queue.poll();

      // 현재 위치가 최종 도착 지점인 경우
      if (currentIndex[0] == m && currentIndex[1] == n) {
        // 블럭 수가 현재 answer 보다 작다면 변경 후 루프 종료 -> 가장 먼저 도착한 결과값
        if (answer > currentIndex[2]) {
          answer = currentIndex[2];
        }
        break;
      }

      // 현재 위치를 체크된 블럭으로 변경
      visits[currentIndex[0]][currentIndex[1]] = true;

      // 상,좌,하,우 순으로 비교 진향
      for (int[] moveIndex : moveIndexs) {
        int newM = currentIndex[0] + moveIndex[0];
        int newN = currentIndex[1] + moveIndex[1];

        // 인덱스 범위를 벗어나는 경우 제외
        if (newM >= 0 && newM <= m && newN >= 0 && newN <= n) {
          // 0이 아니고 지나온 길이 아닌 위치인 경우
          if (maps[newM][newN] != 0 && !visits[newM][newN]) {

            // 이동 가능한 위치 정보 생성
            int[] newIndex = new int[]{newM, newN, currentIndex[2] + 1};

            // 이동 가능한 위치인 경우 추가
            queue.add(newIndex);
          }
        }

      }

    }

    // 최종 도착 지점에 도달하지 못한 경우
    if (answer == Integer.MAX_VALUE) {
      answer = -1;
    }

    return answer;
  }

//--------------------------------------------------------------------------------------------------

  /* 실패 코드
   *
   * 1. 알고보니 BFS 문제였고 DFS로 풀다보니 효율성 테스트가 전부 실패(정확도 테스트는 통과)
   * 2. 상하좌우 이동에 따른 인덱스 위치 이동을 반복적인 코드로 작성해 비효율적으로 동작
   */

/*
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
 */

}
