package v1.programmers.level_2;

// 행렬 테두리 회전하기 : https://school.programmers.co.kr/learn/courses/30/lessons/77485
// 1시간 조금 오버한 시간 내에 문제 풀이 성공
// 하지만 반복적인 코드가 대량으로 작성된 풀이이기에 리팩토링이 필요해 보인다.
  // 1. 구간별 두 시작 지점의 크기 비교를 통해 ++ 반복을 할지 -- 반복을 할지 조건식으로 구분
    // ex) 시작점 x축이 도착점 x축 보다 작다면 -> ++ 반복 / 반대의 경우는 -- 반복
  // 2. 최소값을 구하는 로직도 하나의 메소드로 구현하고 반복 사용
public class SpinRowColumn {

  public static void main(String[] args) {
    SpinRowColumn spinRowColumn = new SpinRowColumn();
    int[] answer = spinRowColumn.solution(
        6,
        6,
        new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}
    );

    for(int i : answer) {
      System.out.print(i + " ");
    }

  }


  // 1차 문제 풀이
  public int[] solution(int rows, int columns, int[][] queries) {

    int[] answer = new int[queries.length];

    // 초기 배열 형태를 담는 2차 배열 생성
    int[][] arr = new int[rows][columns];
    for (int i=0; i<rows; i++) {
      for (int j=0; j<columns; j++) {
        arr[i][j] = (i) * columns + j + 1;
      }
    }

    // 쿼리별 순환
    for (int idx=0; idx< queries.length; idx++) {
      int x1 = queries[idx][0]-1;
      int y1 = queries[idx][1]-1;
      int x2 = queries[idx][2]-1;
      int y2 = queries[idx][3]-1;

      // 최소값 지정 -> x1, y1 값이 최초에는 최소값
      int min = Integer.MAX_VALUE;

      // 이전 숫자
      int beforeNum = arr[x1][y1];
      // 현재 존재하는 숫자
      int currentNum;

      // 단계별로 순환을 진행

      // 1)
      // arr[x1][y1] -> arr[x1][y2]
      for (int i=y1+1; i<=y2; i++) {
        // 최소값 판정
        if (beforeNum < min) {
          min = beforeNum;
        }

        // 자리 이동
        currentNum = arr[x1][i];
        arr[x1][i] = beforeNum;
        beforeNum = currentNum;
      }

      // 2)
      // arr[x1][y2] -> arr[x2][y2]
      for (int i=x1+1; i<=x2; i++) {
        // 최소값 판정
        if (beforeNum < min) {
          min = beforeNum;
        }

        currentNum = arr[i][y2];
        arr[i][y2] = beforeNum;
        beforeNum = currentNum;
      }

      // 3)
      // arr[x2][y2] -> arr[x2][y1]
      for (int i=y2-1; i>=y1; i--) {
        // 최소값 판정
        if (beforeNum < min) {
          min = beforeNum;
        }

        currentNum = arr[x2][i];
        arr[x2][i] = beforeNum;
        beforeNum = currentNum;
      }

      // 4)
      // arr[x2][y1] -> arr[x1][y1]
      for (int i=x2-1; i>=x1; i--) {
        // 최소값 판정
        if (beforeNum < min) {
          min = beforeNum;
        }

        currentNum = arr[i][y1];
        arr[i][y1] = beforeNum;
        beforeNum = currentNum;
      }

      answer[idx] = min;

      /* 출력 결과 테스트용 코드
      for (int i=0; i<rows; i++) {
        for (int j = 0; j < columns; j++) {
          System.out.print(arr[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
      */
    }

    return answer;
  }
}
