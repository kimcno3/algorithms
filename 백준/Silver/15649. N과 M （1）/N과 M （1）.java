import java.io.*;

public class Main {

  static int n, m;
  static int[] arr;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] str = br.readLine().split(" ");

    n = Integer.parseInt(str[0]);
    m = Integer.parseInt(str[1]);

    arr = new int[m];
    visit = new boolean[n];

    method(1, 0);
  }


  public static void method(int at, int depth) {

    if (depth == m) {
      for (int val : arr) {
        System.out.print(val + " ");
      }
      System.out.println();
      return;
    }

    for (int i=at; i<=n; i++) {
      if (!visit[i-1]) {
        visit[i-1] = true;
        arr[depth] = i;
        method(at, depth+1);
        visit[i-1] = false;
      }
    }
  }
}