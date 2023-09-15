import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 숫자의 합
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int length = Integer.valueOf(bf.readLine());
    int result = 0;

    String[] arr = bf.readLine().split("");

    for (int i=0; i<length; i++) {
      result += Integer.valueOf(arr[i]);
    }
    System.out.println(result);
  }
}
