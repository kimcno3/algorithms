import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuffer result = new StringBuffer();
    int length = Integer.parseInt(br.readLine());

    for (int i=0; i<length; i++) {
      String str = br.readLine();
      StringTokenizer tokenizer = new StringTokenizer(str, " ");
      while (tokenizer.hasMoreTokens()) {
        StringBuffer word = new StringBuffer(tokenizer.nextToken());
        result.append(word.reverse() + " ");
      }
      System.out.println(result);
      result.delete(0, result.length());
    }
  }
}