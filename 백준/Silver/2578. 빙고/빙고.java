import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[5][5];
        for (int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean[][] bingo = new boolean[5][5];
        int answer = 0;
        // 25번의 빙고 숫자 호출
        for (int r=1; r<=25; r++) {
            int currentN =  sc.nextInt();
            // 빙고 체크
            for (int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    if (arr[i][j] == currentN) {
                        bingo[i][j] = true;
                    }
                }
            }

            // 전체 빙고판에 대한 빙고 여부 확인
            int count = 0;
            // 행
            int c;
            for(int i=0; i<5; i++) {
                c = 0;
                for (int j=0; j<5; j++) {
                    if (bingo[i][j]) c++;
                }
                if (c == 5) count++;
            }
            // 열
            for(int i=0; i<5; i++) {
                c = 0;
                for (int j=0; j<5; j++) {
                    if (bingo[j][i]) c++;
                }
                if (c == 5) count++;
            }
            // 좌방향 대각선
            c = 0;
            for (int i=0; i<5; i++) {
                if (bingo[i][i]) c++;
            }
            if (c == 5) count++;
            // 좌방향 대각선
            c = 0;
            for (int i=0; i<5; i++) {
                if (bingo[i][4-i]) c++;
            }
            if (c == 5) count++;

            if (count >= 3) {
                System.out.println(r);
                break;
            }
        }
    }
}