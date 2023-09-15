
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br);
    }

    private static void solution(BufferedReader br) throws IOException {

        String str = br.readLine();

        str = str.replaceAll("XXXX", "AAAA");
        str = str.replaceAll("XX", "BB");

        if (str.contains("X")) System.out.println(-1);
        else System.out.println(str);

    }
}