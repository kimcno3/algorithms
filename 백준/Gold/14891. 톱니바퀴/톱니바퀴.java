import java.io.*;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/14891
 * 풀이 방법 : 원형 리스트 -> 링크드 리스트
 */

public class Main {

    static int N;
    static ArrayList<LinkedList<Integer>> list = new ArrayList<>();
    static int[] arr = new int[4];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<4; i++) {
            list.add(new LinkedList<>());
            String[] str = sc.next().split("");
            for (String s : str) {
                list.get(i).add(Integer.valueOf(s));
            }
        }

        N = sc.nextInt();

        while(sc.hasNext()) {
            int idx = sc.nextInt()-1;
            int turnDirection = sc.nextInt();

            // 기준 톱니바퀴
            arr[idx] = turnDirection;

            // 기준 톱니바퀴보다 왼쪽
            if (idx != 0) {
                for (int i=idx-1; i>=0; i--) {
                    if (arr[i+1] == 0) arr[i] = 0;
                    else if (list.get(i+1).get(6) != list.get(i).get(2)) arr[i] = arr[i+1] * -1;
                    else arr[i] = 0;
                }
            }

            // 기준 톱니바퀴보다 오른쪽
            if (idx != 3) {
                for (int i=idx+1; i<=3; i++) {
                    if (arr[i-1] == 0) arr[i] = 0;
                    else if (list.get(i).get(6) != list.get(i-1).get(2)) arr[i] = arr[i-1] * -1;
                    else arr[i] = 0;
                }
            }

            // 조회한 회전 방향대로 톱니바퀴 회전 진행
            for (int i=0; i<arr.length; i++) {
                int turn = arr[i];
                if (turn == -1) turnLeft(i);
                else if (turn == 1) turnRight(i);
            }
        }

        int answer = 0;
        for (int i=0; i<list.size(); i++) {
            int n = list.get(i).peek();
            if (n == 0) answer += 0;
            else answer += Math.pow(2, i-1+n);
        }
        System.out.println(answer);
    }

    static void turnRight(int i) {
        list.get(i).addFirst(list.get(i).removeLast());
    }

    static void turnLeft(int i) {
        list.get(i).add(list.get(i).removeFirst());
    }
}
