import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n, result;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    result = 0;
    arr = new int[n];

    method(0);

    System.out.println(result);
      
  }
    
  public static void method(int depth) {

    if (depth == n) {
      result++;
      return;
    }

    for (int i=0; i<n; i++) {
      arr[depth] = i;

      // 놓일 수 있는 위치일 경우에만!! 재귀함수 호출 -> 다음 열로 넘어간다는 의미
      if (check(depth)) {
        method(depth+1);
      }
      // 그 외 경우는 반복문이 끝나기 때문에 아무런 동작도 하지 않는다.
    }

  }

  public static boolean check(int depth) {
    for (int preDepth=0; preDepth<depth; preDepth++) {
      // 두 행의 차이와 열의 차이가 같은경우 or 값이 같은 경우 -> 놓일 수 없는 위치
      if (Math.abs(preDepth-depth) == Math.abs(arr[preDepth]-arr[depth]) || arr[preDepth] == arr[depth]) {
        return false;
      }
    }
    // 이를 통과 했다면 놓일 수 있는 위치
    return true;

  }
}
