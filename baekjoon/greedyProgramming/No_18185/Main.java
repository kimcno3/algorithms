package baekjoon.greedyProgramming.No_18185;


import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solutionV2(br);
    }

    /* 답안을 참고한 풀이

     * 2번째 수가 3번째 수보다 크다면 두 수의 차이와 첫번째 수 중 최소값만큼 앞 2개의 공장에서 5만원으로 구매한다.
     * 이후 세 숫자 중 최소값만큼 3개의 공장에서 7만원으로 계산한다.
     * 첫번째 수에 남은 만큼 3만원으로 계산한다.

     * 3번째 수가 2번째 수보다 크다면 세 숫자 중 최소값 만큼 3개의 공장에서 7만원으로 계산한다.
     * 이후 첫번째, 2번째 숫자 중 최소값만큼 두개의 공장에서 5만원으로 계산한다.
     * 첫번째 수가 남은 만큼 3만원으로 계산한다.
     */

    private static void solutionV2(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] list = new int[n + 2];
        for (int i=0; i<n; i++) {
            list[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(list));

        int answer = 0;
        for(int i=0; i<n; i++) {
            // 2번째 > 3번째인 경우
            if (list[i+1] > list[i+2]) {
                int twoCase = Math.min(list[i], list[i+1] - list[i+2]);
                answer += twoCase * 5;
                list[i] -= twoCase;
                list[i+1] -= twoCase;

                int threeCase = Math.min(list[i], Math.min(list[i+1], list[i+2]));
                answer += threeCase * 7;
                list[i] -= threeCase;
                list[i+1] -= threeCase;
                list[i+2] -= threeCase;
            }
            // 2번째 <= 3번째인 경우
            else {
                int threeCase = Math.min(list[i], Math.min(list[i+1], list[i+2]));
                answer += threeCase * 7;
                list[i] -= threeCase;
                list[i+1] -= threeCase;
                list[i+2] -= threeCase;

                int twoCase = Math.min(list[i], list[i+1]);
                answer += twoCase * 5;
                list[i] -= twoCase;
                list[i+1] -= twoCase;
            }
            answer += list[i] * 3;
            list[i] = 0;
        }
        System.out.println(answer);
    }


    /* 내가 푼 문제 풀이

     * 풀이는 실패
     * 그리디 알고리즘 방식은 알았지만 접근을 잘못했다.
     */

    private static void solution(BufferedReader br) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int answer = 0;

        for (int i=0; i<n; i+=3) {

            int n1 = Integer.parseInt(arr[i]);
            int n2 = i + 1 < n ? Integer.parseInt(arr[i + 1]) : 0;
            int n3 = i + 2 < n ? Integer.parseInt(arr[i + 2]) : 0;

            // 첫번째 수
            answer += n1 * 3;
            // 두번째 수
            if (n1 >= n2) answer += 2 * n2;
            else answer += (3 * n2) + (n1 * 2);

            // 세번째 수
            if (n2 >= n3) answer += 2 * n3;
            else answer += (3 * n3) + (n2 * 2);

        }
        System.out.println(answer);
    }
}