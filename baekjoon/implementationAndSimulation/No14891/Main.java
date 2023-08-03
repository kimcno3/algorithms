package baekjoon.implementationAndSimulation.No14891;

import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/14891
 * 풀이 방법
   * 원형 리스트 -> 링크드 리스트를 활용
   * 왼쪽 톱니바퀴의 2번 값과 오른쪽 톱니바퀴의 6번 값이 맞닿는 지점
   * 이를 가지고 기준 톱니바퀴의 회전 방향에 따른 톱니바퀴별 회전 방향을 arr에 저장
   * 저장된 arr 내 정보를 가지고 회전
 */

public class Main {

    static int N;
    static ArrayList<LinkedList<Integer>> list = new ArrayList<>();
    static int[] arr = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 정보 세팅
        for (int i=0; i<4; i++) {
            list.add(new LinkedList<>());
            String[] str = br.readLine().split("");
            for (String s : str) {
                list.get(i).add(Integer.valueOf(s));
            }
        }
        // 회전수 세팅
        N = Integer.parseInt(br.readLine());
        // 톱니바퀴 회전 로직
        while(br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 기준 톱니바퀴 인덱스와 회전 방향
            int idx = Integer.parseInt(st.nextToken())-1;
            int turnDirection = Integer.parseInt(st.nextToken());

            // 기준 톱니바퀴의 회전방향 저장
            arr[idx] = turnDirection;

            // 기준 톱니바퀴 왼쪽방향으로 회전방향 체크(1번 톱니바퀴인 경우 제외)
            if (idx != 0) {
                for (int i=idx-1; i>=0; i--) {
                    if (arr[i+1] == 0) arr[i] = 0; // 이전 톱니바퀴가 회전을 안하는 경우
                    else if (list.get(i+1).get(6) != list.get(i).get(2)) arr[i] = arr[i+1] * -1; // 극이 달라 회전이 가능한 경우
                    else arr[i] = 0; // 극이 같은 경우
                }
            }

            // 기준 톱니바퀴보다 오른쪽으로 회전방향 체크(4번 톱니바퀴인 경우 제외)
            if (idx != 3) {
                for (int i=idx+1; i<=3; i++) {
                    if (arr[i-1] == 0) arr[i] = 0; // 이전 톱니바퀴가 회전을 안하는 경우
                    else if (list.get(i).get(6) != list.get(i-1).get(2)) arr[i] = arr[i-1] * -1; // 극이 달라 회전이 가능한 경우
                    else arr[i] = 0; // 극이 같은 경우
                }
            }

            // 조회한 회전 방향대로 톱니바퀴 회전 진행
            for (int i=0; i<arr.length; i++) {
                int turn = arr[i];
                if (turn == -1) turnLeft(i);
                else if (turn == 1) turnRight(i);
            }
        }
        // 최종 톱니바퀴 상태를 기준으로 12시 방향에 있는 값으로 최종값 계산
        int answer = 0;
        for (int i=0; i<list.size(); i++) {
            int n = list.get(i).peek(); // 큐 기준으로 가장 맨앞의 값을 가져온다.
            if (n == 0) answer += 0; // 0일 경우 0을 더한다.
            else answer += Math.pow(2, i-1+n); // 1인 경우 톱니바퀴 숫자에 따라 2의 제곱을 해준다.
        }
        // 결과 리턴
        System.out.println(answer);
    }

    static void turnRight(int i) {
        list.get(i).addFirst(list.get(i).removeLast());
    }

    static void turnLeft(int i) {
        list.get(i).add(list.get(i).removeFirst());
    }
}