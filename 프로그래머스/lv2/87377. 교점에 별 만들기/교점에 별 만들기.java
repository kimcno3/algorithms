import java.util.*;

class Solution {
    public String[] solution(int[][] line) {

        Set<long[]> set = new HashSet<>();
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        // 1. 모든 교점 좌표 구하기
        for (int i=0; i<line.length-1; i++) {
            for (int j=i+1; j<line.length; j++) {
                // 비교할 두 직선
                int[] row1 = line[i];
                int[] row2 = line[j];
                // A ~ F 추출
                double A = row1[0];
                double B = row1[1];
                double C = row2[0];
                double D = row2[1];
                double E = row1[2];
                double F = row2[2];
                // 접점 추출
                double X = (B * F - E * D) / (A * D - B * C);
                double Y = (E * C - A * F) / (A * D - B * C);

                // 정수만 판별
                if (X == (long) X && Y == (long) Y) {
                    // set에 추가 -> 접점에 추가
                    set.add(new long[]{(long) X, (long) Y});
                    // 최대, 최소값 업데이트 -> 배열의 크기를 정한다.
                    if (X > maxX) maxX = (long) X;
                    if (X < minX) minX = (long) X;

                    if (Y > maxY) maxY = (long) Y;
                    if (Y < minY) minY = (long) Y;

                }
            }
        }

        // 2.배열 생성
        long[][] arr = new long[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        // 3. 별 위치 저장
        for (long[] star : set) {
            long starX = (star[0] - minX);
            long starY = (maxY - star[1]);
            arr[(int) starY][(int) starX] = 1;
        }

        // 4. 정답 배열 생성
        String[] answer = new String[arr.length];
        for (long i=0; i<arr.length; i++) {
            String str = "";
            for (long point : arr[(int) i]) {
                if (point == 0) str += ".";
                else str += "*";
            }
            answer[(int) i] = str;
        }

        return answer;
    }
}