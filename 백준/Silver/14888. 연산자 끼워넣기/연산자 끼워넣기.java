import java.io.*;
import java.util.*;

/**
 * 느낀 점
 * 풀이는 완료했지만 DP로 접근해보려 했던 점이 아쉽다. 잘못된 판단
 * 다른 풀이들을 보면 굳이 visits를 쓰지 않고도 충분히 구현이 가능했다.(참고자료 : https://easybrother0103.tistory.com/60)
 */

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visits;
    static int[] op;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // 최소 최대값
        answer = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};

        // 피연산자 계수
        N = sc.nextInt();
        // 피연산자 배열
        arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        // 연산자 사용 여부
        visits = new boolean[N - 1];
        // 연산자 배열("+" : 0 / "-" : 1/ "*" : 2 / "%" : 3)
        op = new int[N-1];
        int idx = 0;
        for (int i=0; i<4; i++) {
            // 연산자 개수
            int n = sc.nextInt();
            // 연산자 개수만큼 순서대로 추가
            for (int j=0; j<n; j++) {
                op[idx++] = i;
            }
        }
        // 재귀 함수 구현
        recursion(1, 0, arr[0]);
        // 결과 리턴
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
    static void recursion(int depth, int sp, int result) {

        // 계산이 끝난 경우, 최대 최소값 비교해서 결과 업데이트
        if (depth == N) {
            if (result > answer[0]) answer[0] = result;
            if(result < answer[1]) answer[1] = result;
            return;
        }
        // 사용 여부를 확인해서 사용하지 않은 연산자 우선으로 조회
        for (int i=sp; i<op.length; i++) {
            if (!visits[i]) {
                visits[i] = true;
                recursion(depth+1, sp, calcResult(result, depth, i));
                visits[i] = false;
            }
        }
    }

    static int calcResult(int result, int depth, int i) {
        int newResult = 0;
        if(op[i] == 0) newResult = result + arr[depth];
        else if(op[i] == 1) newResult =  result - arr[depth];
        else if(op[i] == 2) newResult = result * arr[depth];
        else if(op[i] == 3) {
            if (result < 0) {
                newResult = -1 * (Math.abs(result) / arr[depth]);
            } else {
                newResult = result / arr[depth];
            }
        }
        return newResult;
    }
}