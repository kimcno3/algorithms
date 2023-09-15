import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/3190
 * 풀이방법
    * 큐 사용
 */

public class Main {

    static Map<String, Map<String, int[]>> directions = new HashMap<>();
    static int[][] map;
    static List<int[]> apples = new ArrayList<>();
    static LinkedList<int[]> snake = new LinkedList<>();
    static int N, K, L, X;
    static String C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        directions.put("UP", new HashMap<>());
        directions.get("UP").put("F", new int[]{-1, 0});
        directions.get("UP").put("L", new int[]{0, -1});
        directions.get("UP").put("D", new int[]{0, 1});

        directions.put("DOWN", new HashMap<>());
        directions.get("DOWN").put("F", new int[]{1, 0});
        directions.get("DOWN").put("L", new int[]{0, 1});
        directions.get("DOWN").put("D", new int[]{0, -1});

        directions.put("LEFT", new HashMap<>());
        directions.get("LEFT").put("F", new int[]{0, -1});
        directions.get("LEFT").put("L", new int[]{1, 0});
        directions.get("LEFT").put("D", new int[]{-1, 0});

        directions.put("RIGHT", new HashMap<>());
        directions.get("RIGHT").put("F", new int[]{0, 1});
        directions.get("RIGHT").put("L", new int[]{-1, 0});
        directions.get("RIGHT").put("D", new int[]{1, 0});

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        for (int i=0; i<L; i++) {
            arr.add(i, br.readLine());
        }

        Map<Integer, String> changeDirection = new HashMap<>();
        for (int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(arr.get(i));
            X = Integer.parseInt(st.nextToken());
            C = st.nextToken();
            changeDirection.put(X, C);
        }

        int second = 0;
        String currentDirection = "RIGHT";
        int[] currentPoint = new int[]{0, 0};
        snake.add(currentPoint);
        while (true) {
            // 시간 추가
            second++;
            // 뱀 머리 위치 이동
            currentPoint = new int[]{
                    currentPoint[0] + directions.get(currentDirection).get("F")[0],
                    currentPoint[1] + directions.get(currentDirection).get("F")[1]
            };
            // 벽에 닿았는지 확인
            if (0 > currentPoint[0] || currentPoint[0] >= N || 0 > currentPoint[1] || currentPoint[1] >= N) {
                System.out.println(second);
                return;
            }
            // 뱀 몸에 닿았는지 확인
            for (int[] point : snake) {
                if (point[0] == currentPoint[0] && point[1] == currentPoint[1]) {
                    System.out.println(second);
                    return;
                }
            }
            // 사과 먹었는지 확인
            boolean isEatApple = false;
            if (map[currentPoint[0]][currentPoint[1]] == 1) {
                isEatApple = true;
                map[currentPoint[0]][currentPoint[1]] = 0;
            }
            // 뱀 위치 이동
            snake.add(currentPoint);
            if (!isEatApple) {
                snake.poll();
            }

            // 방향전환
            if (changeDirection.containsKey(second)) {
                switch (currentDirection) {
                    case "UP":
                        if (changeDirection.get(second).equals("L")) currentDirection = "LEFT";
                        if (changeDirection.get(second).equals("D")) currentDirection = "RIGHT";
                        break;
                    case "DOWN":
                        if (changeDirection.get(second).equals("L")) currentDirection = "RIGHT";
                        if (changeDirection.get(second).equals("D")) currentDirection = "LEFT";
                        break;
                    case "LEFT":
                        if (changeDirection.get(second).equals("L")) currentDirection = "DOWN";
                        if (changeDirection.get(second).equals("D")) currentDirection = "UP";
                        break;
                    case "RIGHT":
                        if (changeDirection.get(second).equals("L")) currentDirection = "UP";
                        if (changeDirection.get(second).equals("D")) currentDirection = "DOWN";
                        break;
                }
            }
        }
    }
}