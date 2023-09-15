import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 알파벳 찾기(https://www.acmicpc.net/problem/10809)
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();

    String[] arr = bf.readLine().split("");
    for (char ascii='a'; ascii<='z'; ascii++) {
      for (int i=0; i<arr.length; i++) {
        // 동알한 문자열일 경우
        if (String.valueOf(ascii).equals(arr[i])) {
          result.append(i).append(" ");
          break;
        }
        // 마지막까지 루프를 돌았지만 같은 문자열이 안나온 경우
        if (i == arr.length - 1) {
          result.append(-1).append(" ");
        }
      }
    }
     System.out.println(result);
  }
}
