import java.util.*;
import java.io.*;

/** 풀이 과정
     * 바구니의 크기만큼 양 끝점을 지정한다.
     * 왼쪽으로 이동해야 하는 경우, 오른족으로 이동해야 하는 경우, 움직이지 않아도 되는 경우로 나눠 분기 처리한다.
     * 만약 이동 거리가 범위를 초과하면 끝점까지만 이동한다.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 스크린 길이
        int n = Integer.parseInt(st.nextToken());
        // 바구니 길이
        int m = Integer.parseInt(st.nextToken());
        // 떨어지는 사과 수
        int j = Integer.parseInt(br.readLine());
        // 사과의 위치를 담은 배열
        int[] arr = new int[j];
        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 바구니의 왼쪽 끝
        int min = 0;
        // 바구니의 오른쪽 끝
        int max = min + m - 1;
        // 이동 횟수
        int answer = 0;
        // 0. 사과가 하나씩 떨어진다.
        for (int i=0; i<arr.length; i++) {
            // 사과가 떨어지는 포인트
            int applePoint = arr[i] - 1;
            // 1. 바구니가 왼쪽으로 움직여야 할 때
            if (applePoint < min) {
                int move = min - applePoint;
                // 1-1. 이동거리가 범위를 초과할 때
                if (min - move < 0) {
                    answer += min;
                    min = 0;
                    max = min + m - 1;
                }
                // 1-2. 범위 내에 이동거리가 포함되는 경우
                else {
                    answer += move;
                    min = applePoint;
                    max = min + m - 1;
                }
            }
            // 2. 바구니가 오른쪽으로 움직여야 할 때
            else if (applePoint > max) {
                int move = applePoint - max;
                // 2-1. 이동거리가 범위를 초과하는 경우
                if (max + move >= n) {
                    answer += n - max;
                    max = n-1;
                    min = max - m + 1;
                }
                // 2-2. 범위 내에 이동거리가 포함되는 경우
                else {
                    answer += move;
                    max = applePoint;
                    min = max - m + 1;
                }
            }
            // 3. 그 외 경우 -> 바구니 안에 포함되어 움직이지 않아도 되는 경우
        }
        System.out.println(answer);
    }
}