import java.io.*;

// N과 M(4) : https://www.acmicpc.net/problem/15652
public class Main {

  static int n, m;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split(" ");

    n = Integer.parseInt(split[0]);
    m = Integer.parseInt(split[1]);

    arr = new int[m];

    method(1, 0);
    System.out.println(sb);

  }

  public static void method(int sp, int depth) {

    if(depth == m) {
      for (int val : arr) {
        sb.append(val + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i=sp; i<=n; i++) {
      arr[depth] = i;
      method(i, depth+1);
    }

  }
  
}