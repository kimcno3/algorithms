import java.util.*;
import java.io.*;

    /**
     * 풀이 1
        * 스택을 사용
        * 햄버거면 스택에 push, 사람이면 pop을 한다.
        * 스택의 길이는 K만큼으로 고정
        * 햄버거 차례일 때, 스택 길이가 K라면 제외
        * 사람 차례일 때, 스택에 햄버거가 없으면 제외
     * 문제점
        * 사람이 먼저 오고 나중에 햄버거가 있는 경우는 파악하지 못한다.
     * 풀이 2
        * 사람만 담는 스택과 햄버거만 담는 스택을 두개 둔다.
        * 각 스택의 길이는 K로 고정
        * 햄버거가 온 경우, 사람 스택에 값이 존재하면 그 값을 pop, 없으면 햄버거 스택에 push, 햄버거 스택 길이가 k 라면 continue
        * 사람이 온 경우, 햄버거 스택에 값이 존재하면 그 값을 pop, 없으면 사람 스택에 push, 사람 스택 길이가 k라면 continue;
     * 문제점
        * 이미 거리가 k이상이라 제외되어야 할 햄버거나 사람이 스택이 남아있는다.
     * 풀이 3
        * 큐를 하나만 사용한다.
        * 어떤 값이라도 스택에 push 시도는 한다.
        * 만약 push 전에 stack의 길이가 k라면 하나를 우선 지운다.  k-1
        * push하기 전에 가장 최근 값이 반대라면 pop만 한다. k-2
        * stack이 비어있거나, 최근 값이 같다면 push를 한다. k
     * 문제점
        * 가장 마지막 값을 지우면 거리가 되는 경우에도 안되는 걸로 넘어간다. (ex. HHPP인 경우, 첫 H가 거리에서 제외되면서 누락된다.)
     * 풀이 4
        * 큐를 하나만 사용한다.
        * 큐의 길이는 K만큼만 유지한다.
        * 만약 같은 값이 나왔을 때, K 만큼만 유지한다. -> 거리를 벗어날 때까지 매칭시키지 못했으므로
        * 다른 값이 나왔을 때, 가장 처음 들어온 값과 매칭해 지운다 -> 거리 내에서 매칭가능한 경우 중 가장 거리가 먼 경우로 매칭, 다음을 위해
     * 문제점
        * 이것도 아니다...
     * 답안 참고 : https://coder38611.tistory.com/133
        * P를 기준으로 K범위 내에서 가장 왼쪽부터 우선순위를 두고 H를 체크하고 넘어가면 된다.
        * 가장 왼쪽부터 우선순위를 두는 이유는 가장 마지막에 P가 나올 경우를 대비하기 위해서
        * 너무 Stack, Queue로 해결해보려 했다가 잘못된 접근을 하게 된 케이스..
     **/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = 0;
        int k = 0;
        while(st.hasMoreTokens()) {
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        }

        char[] arr = br.readLine().toCharArray();
        for (int i=0; i<n; i++) {
            char ch = arr[i];
            if (ch == 'P') {
                for (int j=Math.max(i-k, 0); j<= Math.min(i+k, n-1); j++) {
                    if (arr[j] == 'H') {
                        arr[j] = 'X';
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}