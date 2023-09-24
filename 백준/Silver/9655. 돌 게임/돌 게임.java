import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * <풀이>
     * 3으로 나눈 몫과 나머지를 더한다.
     * 그 값이 홀수면 CY, 짝수면 SK
     **/

    private static void solution(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (((n / 3) + (n % 3)) % 2 == 1) System.out.println("SK");
        else System.out.println("CY");
    }
}