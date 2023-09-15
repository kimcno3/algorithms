import java.util.*;

class Solution {

  private static final class State {

    public final int[] index;
    public  final int distance;

    private State(int[] index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public String toString() {
      return "State{" +
              "index=" + Arrays.toString(index) +
              ", distance=" + distance +
              '}';
    }
  }

  private static final int[] dx = {0, -1, 0, 1};
  private static final int[] dy = {-1, 0, 1, 0};

  public int solution(int[][] maps) {
    // 필요 변수 생성
    // n : y축 최대값, m : x축 최대값
    int n = maps.length - 1;
    int m = maps[0].length - 1;
    boolean[][] visits = new boolean[n + 1][m + 1];
    LinkedList<State> queue = new LinkedList<>();
    // 초기값 세팅
    queue.add(new State(new int[]{0, 0}, 1));
    visits[0][0] = true;
    // 최단거리 -> BFS 풀이
    while (!queue.isEmpty()) {
      State state = queue.pop();
      int x = state.index[1];
      int y = state.index[0];

      // x,y가 n, m에 위치하면 루프 종료 & 이동거리 리턴
      if (y == n && x == m) return state.distance;

      // 이동할 때마다 상하좌우로 이동 -> 좌표, 이동거리
      for (int i=0; i<4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];
        // 인덱스를 벗어나면 이동 불가
        if (0 > nx || nx > m || 0 > ny || ny > n) continue;
        // 1이면 이동 가능, 0이면 이동 불가 & 이미 지나간 곳이라면 이동 불가
        if (maps[ny][nx] == 0 || visits[ny][nx]) continue;
        // 방문 처리
        visits[y+dy[i]][x+dx[i]] = true;
        // 큐에 추가
        queue.add(new State(new int[]{ny, nx}, state.distance + 1));
      }
    }

    return -1;
  }
}