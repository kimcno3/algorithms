package v1.baekjoon.implementationAndSimulation.No3190;

import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/3190
 * 느낀 점
 * 큐 사용해 뱀의 위치를 저장 및 삭제
 * 과한 이중 해쉬맵을 사용했지만 좀 더 나은 이해를 위해 선택한 방법
 * 구현까지 시간이 너무 오래걸림
 * 너무 많은 자료구조를 사용하고자 해 불필요한 과정이 추가된 경우가 많다. 조금 더 간결하게 작성해볼 필요가 있다.
 *
 */

public class Main {

    static Map<String, Map<String, int[]>> directions = new HashMap<>();
    static int[][] map;
    static Map<Integer, String> changeDirections = new HashMap<>();
    static LinkedList<int[]> snake = new LinkedList<>();
    static int N, K, L, X;
    static String C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 뱀이 바라보고 있는 방향에 따른 앞, 좌, 우 이동 방향 세팅
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

        // 배열 길이에 따른 맵 세팅
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 사과 위치 세팅
        K = Integer.parseInt(br.readLine());
        for (int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            map[x][y] = 1;
        }

        // 방향 전환 시간과 전환 방향 세팅
        L = Integer.parseInt(br.readLine());
        for (int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            C = st.nextToken();
            changeDirections.put(X, C);
        }

        int second = 0;
        String currentDirection = "RIGHT";
        int[] currentPoint = new int[]{0, 0};
        snake.add(currentPoint);
        while (true) {
            // 1. 시간 추가
            second++;
            // 2. 뱀 머리 위치 이동
            currentPoint = new int[]{
                    currentPoint[0] + directions.get(currentDirection).get("F")[0],
                    currentPoint[1] + directions.get(currentDirection).get("F")[1]
            };
            // 2. 벽에 닿았는지 확인
            if (0 > currentPoint[0] || currentPoint[0] >= N || 0 > currentPoint[1] || currentPoint[1] >= N) {
                System.out.println(second);
                return;
            }
            // 3. 뱀 몸에 닿았는지 확인
            for (int[] point : snake) {
                if (point[0] == currentPoint[0] && point[1] == currentPoint[1]) {
                    System.out.println(second);
                    return;
                }
            }
            // 4. 사과 먹었는지 확인
            boolean isEatApple = false;
            if (map[currentPoint[0]][currentPoint[1]] == 1) {
                isEatApple = true;
                map[currentPoint[0]][currentPoint[1]] = 0;
            }
            // 5. 뱀 위치 이동
            snake.add(currentPoint);
            if (!isEatApple) {
                snake.poll();
            }

            // 6. 방향 전환 타이밍에 방향 전환 시도
            if (changeDirections.containsKey(second)) {
                switch (currentDirection) {
                    case "UP":
                        if (changeDirections.get(second).equals("L")) currentDirection = "LEFT";
                        if (changeDirections.get(second).equals("D")) currentDirection = "RIGHT";
                        break;
                    case "DOWN":
                        if (changeDirections.get(second).equals("L")) currentDirection = "RIGHT";
                        if (changeDirections.get(second).equals("D")) currentDirection = "LEFT";
                        break;
                    case "LEFT":
                        if (changeDirections.get(second).equals("L")) currentDirection = "DOWN";
                        if (changeDirections.get(second).equals("D")) currentDirection = "UP";
                        break;
                    case "RIGHT":
                        if (changeDirections.get(second).equals("L")) currentDirection = "UP";
                        if (changeDirections.get(second).equals("D")) currentDirection = "DOWN";
                        break;
                }
            }
        }
    }
}