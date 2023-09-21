import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    /**
     * <풀이 1>
     * +를 먼저 계산한다. -> 뒤에 나오는 숫자가 크면 클수록 작아지므로
     * 이후로 -를 계산한다. -> 큰 값의 차이가 날 때 가장 작아지므로
     **/

    private static void solution(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);

        List<String> list = new ArrayList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        // + 계산
        while (list.contains("+")) {
            int i = list.indexOf("+");
            int num1 = Integer.parseInt(list.get(i-1));
            int num2 = Integer.parseInt(list.get(i+1));
            list.remove(i-1);
            list.remove(i-1);
            list.remove(i-1);
            list.add(i - 1, String.valueOf(num1 + num2));
        }
        // - 계산
        while (list.contains("-")) {
            int i = list.indexOf("-");
            int num1 = Integer.parseInt(list.get(i-1));
            int num2 = Integer.parseInt(list.get(i+1));
            list.remove(i-1);
            list.remove(i-1);
            list.remove(i-1);
            list.add(i - 1, String.valueOf(num1 - num2));
        }

        int answer = Integer.parseInt(list.get(0));
        System.out.println(answer);
    }
}