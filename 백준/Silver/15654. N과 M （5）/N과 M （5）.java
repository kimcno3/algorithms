import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//  N과 M(5) : https://www.acmicpc.net/problem/15654
public class Main {

  static int n, m;
  static int[] arr, ints;
  static boolean[] visits;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] strs = br.readLine().split(" ");
    n = Integer.parseInt(strs[0]);
    m = Integer.parseInt(strs[1]);

    arr = new int[m];
    ints = new int[n];
    visits = new boolean[n];

    strs = br.readLine().split(" ");
    for (int i=0; i<ints.length; i++) {
      ints[i] = Integer.valueOf(strs[i]);
    }

    Arrays.sort(ints);

    method(0, 0);
    System.out.println(sb);
  }

  public static void method(int sp, int depth) {

    if (depth == m) {
      for (int val : arr) {
        sb.append(val + " ");
      }
      sb.append("\n");
      return;
    }

    for (int i=sp; i<n; i++) {
      if (!visits[i]) {
        visits[i] = true;
        arr[depth] = ints[i];
        method(sp, depth+1);
        visits[i] = false;
      }
    }

  }

}