import java.io.*;

public class Main {

  public static int[] arr;
  public static int n, m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str  = br.readLine();
    String[] split = str.split(" ");

    n = Integer.parseInt(split[0]);
    m = Integer.parseInt(split[1]);
    
    // 순차적인 출력을 위한 배열 [0, 0]
    arr = new int[m];

    method(1, 0);

  }

  public static void method(int at, int depth) {

    if (depth == m) {
      for (int i : arr) {
        System.out.print(i + " ");
      }
      System.out.println();
      return;
    }

    for (int i=at; i<=n; i++) {
      arr[depth] = i;
      method(i+1, depth+1);
    }
  }
}