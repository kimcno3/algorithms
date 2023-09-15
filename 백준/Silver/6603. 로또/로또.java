import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int n;
  static String[] split;
  static String[] arr;
  static boolean[] visits;
  static StringBuilder sb = new StringBuilder();


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nums = "";

    while(!nums.equals("0")) {
      nums = br.readLine();

      split = nums.split(" ");
      n = Integer.parseInt(split[0]);
      arr = new String[6];
      visits = new boolean[n];

      method(1, 0);
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void method(int sp, int depth) {

    if (depth == 6) {
      for (String val : arr) {
        sb.append(val).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i=sp; i<split.length; i++) {
      if (!visits[i-1]) {
        visits[i-1] = true;
        arr[depth] = String.valueOf(split[i]);
        method(i, depth+1);
        visits[i-1] = false;
      }
    }
  }
}
