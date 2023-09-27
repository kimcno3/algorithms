import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * <풀이>
     * 문제를 이해하는데 오래 걸림...
     * 3 * 3 만큼의 부분 수열을 좌측 상단부터 차례대로 변경
     * 좌측 상단의 값이 일치한다면 다음 단계로 이동
     * 부분 수열을 모두 탐색한 다음, 전체 데이터를 비교해 다른 값이 있다면 -1 리턴
     * 그 외 경우는 변경 횟수를 리턴
     * <문제점>
     * 3*3 이하의 배열을 사전에 -1로 리턴할 필요가 없었다.
     * String이 아니라 char Array를 더 잘 사용하자.
     * 데이터의 범위를 잘 생각하고 작다면 전체 완전 탐색을 아끼지 말자.
     **/

    private static void solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] startArr = new char[n][m];
        for (int i=0; i<n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j=0; j<m; j++) {
                startArr[i][j] = line[j];
            }
        }

        char[][] finishArr = new char[n][m];
        for (int i=0; i<n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j=0; j<m; j++) {
                finishArr[i][j] = line[j];
            }
        }

        int answer = 0;
        
        // 3*3 배열을 순차적으로 이동하면서 뒤집은 다음 가장 좌측 상단값만 비교
        // i, j 는 부분 배열 시작 점
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                // 좌측 상단 값이 다를 경우에만 뒤집기 진행
                if (startArr[i][j] != finishArr[i][j] && i+2 < n && j+2 < m) {
                    // x, y는 부분 수열의 각각의 위치
                    for (int y=i; y<=i+2; y++) {
                        for (int x=j; x<=j+2; x++) {
                            // 부분 수열의 값을 뒤집기
                            startArr[y][x] = startArr[y][x] == '0' ? '1' : '0';
                        }
                    }
                    answer++;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (startArr[i][j] != finishArr[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }
}