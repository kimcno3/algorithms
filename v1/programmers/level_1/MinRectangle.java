package v1.programmers.level_1;

// 최소 직사각형 : https://school.programmers.co.kr/learn/courses/30/lessons/86491

/*
 * 힌트 : 최소 넓이를 구하기 위해선 각 명함의 모양이 "가로가 세로보다 길게" 놓여져야 한다.
 */

public class MinRectangle {

  public int solution(int[][] sizes) {
    int answer = 0;

    // 가로, 세로 최대값 저장 변수 선언
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;

    for (int[] size : sizes) {

      // 가로가 세로보다 짧으면 두 값을 변경(명함 돌리기)
      if (size[0] < size[1]) {
        int temp = size[0];
        size[0] = size[1];
        size[1] = temp;
      }

      // 가로, 세로 최대값 비교
      if (size[0] > maxX) maxX = size[0];
      if (size[1] > maxY) maxY = size[1];

    }

    // 두 최대값의 곱 리턴(넓이)
    return maxX * maxY;
  }
}
