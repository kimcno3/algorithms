import java.io.*;
import java.util.*;

public class Main {

    static int m;
    static int[][] arr;
    static boolean[] visits;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        visits = new boolean[m];
        arr = new int[m][m];
        for (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        checksum(0, 0);

        System.out.println(answer);
    }

    static void checksum(int depth, int sp) {
        if (depth == m/2) {
            int teamA = 0; // true 이면 +
            int teamB = 0; // false 이면 +

            for (int i=0; i<m; i++) {
                for (int j=0; j<m; j++) {
                    if(visits[i] && visits[j]) teamA += arr[i][j];
                    else if (!visits[i] && !visits[j]) teamB += arr[i][j];
                }
            }
            answer = Math.min(answer, Math.abs(teamA - teamB));
            return;
        }


        for (int i=sp; i<m; i++) {
            if (!visits[i]) {
                visits[i] = true;
                checksum(depth+1, i+1);
                visits[i] = false;
            }
        }
    }
}