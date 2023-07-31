package baekjoon.implementationAndSimulation.No2578;

import java.io.*;
import java.util.*;

/**
 * 문제 출처 : https://www.acmicpc.net/problem/2578
 */

public class Main {

    static int[][] numberBingo = new int[5][5];
    static boolean[][] booleanBingo = new boolean[5][5];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 숫자 빙고판 생성
        makeNumberBingo(sc);
        // 25번의 빙고 숫자 호출
        for (int r=1; r<=25; r++) {
            int currentNumber =  sc.nextInt();
            // 불린빙고판에 나온 숫자 체크
            checkCurrentNumber(currentNumber);
            // 전체 빙고판에 대한 빙고 여부 확인
            count = 0;
            // 행
            checkRow();
            // 열
            checkColumn();
            // 좌방향 대각선
            checkRight();
            // 좌방향 대각선
            checkLeft();
            // 빙고 합계 계산
            if (count >= 3) {
                System.out.println(r);
                break;
            }
        }
    }

    private static void checkCurrentNumber(int curretNumber) {
        // 불린빙고판에 나온 숫자 체크
        for (int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if (numberBingo[i][j] == curretNumber) {
                    booleanBingo[i][j] = true;
                }
            }
        }
    }

    private static void makeNumberBingo(Scanner sc) {
        for (int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                numberBingo[i][j] = sc.nextInt();
            }
        }
    }
    private static void checkRow() {
        int c;
        for(int i=0; i<5; i++) {
            c = 0;
            for (int j=0; j<5; j++) {
                if (booleanBingo[i][j]) c++;
            }
            if (c == 5) count++;
        }
    }

    private static void checkColumn() {
        int c;
        for(int i=0; i<5; i++) {
            c = 0;
            for (int j=0; j<5; j++) {
                if (booleanBingo[j][i]) c++;
            }
            if (c == 5) count++;
        }
    }

    private static void checkRight() {
        int c = 0;
        for (int i=0; i<5; i++) {
            if (booleanBingo[i][i]) c++;
        }
        if (c == 5) count++;
    }

    private static void checkLeft() {
        int c = 0;
        for (int i=0; i<5; i++) {
            if (booleanBingo[i][4-i]) c++;
        }
        if (c == 5) count++;
    }
}
