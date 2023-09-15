package v1.programmers.level_1;

// 카카오 인턴 - 키패드 누르기 : https://programmers.co.kr/learn/courses/30/lessons/67256

public class keyPad {

  // L, R 위치를 저장할 변수 -> 시작점은 *, #에 위치
  private int[] L = {3, 0};
  private int[] R = {3, 2};

  public String solutionV2(int[] numbers, String hand) {

    StringBuilder sb = new StringBuilder();
    // 숫자 하나씩 루프
    for (int number : numbers) {
      int x;
      int y;
      // 숫자를 가지고 배열의 x,y 값 추출
      if (number == 0) {
        x = 1;
        y = 3;
      } else if (number % 3 == 0) {
        x = 2;
        y = (number / 3) - 1;
      } else {
        x = (number % 3) - 1;
        y = number / 3;
      }
      // x값을 기준으로 조건을 나눈다.
      // x==0 : 무조건 왼손
      if (x == 0) moveLeftHand(sb, x, y);
        // x==2 : 무조건 오른손
      else if (x == 2) moveRightHand(sb, x, y);
        // x==1 : 가까운 쪽 손이 이동
      else {
        // 왼손, 오른손의 위치 기준으로 거리 계산
        int left = Math.abs(L[0] - y) + Math.abs(L[1] - x);
        int right = Math.abs(R[0] - y) + Math.abs(R[1] - x);
        // 왼손이 가까우면 왼손이
        if (left < right) moveLeftHand(sb, x, y);
          // 오른손이 가까우면 오른손이
        else if (right < left) moveRightHand(sb, x, y);
          // 거리가 같으면
        else {
          // 왼손잡이라면 왼손
          if (hand.equals("left")) moveLeftHand(sb, x, y);
            // 오른손잡이면 오른손
          else moveRightHand(sb, x, y);
        }
      }
    }
    return sb.toString();
  }

  private void moveLeftHand(StringBuilder sb, int x, int y) {
    sb.append("L");
    L[0] = y;
    L[1] = x;
  }

  private void moveRightHand(StringBuilder sb, int x, int y) {
    sb.append("R");
    R[0] = y;
    R[1] = x;
  }

  public String solution(int[] numbers, String hand) {
    StringBuilder answer = new StringBuilder();
    String[][] keypad = {
        {"1","2","3"},
        {"4","5","6"},
        {"7","8","9"},
        {"*","0","#"}
    };

    int[] leftIdx = {3,0};
    int[] rightIdx = {3,2};

    // 입력 받는 숫자 loop
    for (int num : numbers) {
      // 키패드 이중 loop
      for (int i=0; i<keypad.length; i++) {
        for (int j=0; j<keypad[i].length; j++) {
          // 같은 숫자일 경우
          if (String.valueOf(num).equals(keypad[i][j])){
            // 1,4,7,*
            if(j==0) {
              leftIdx[0] = i;
              leftIdx[1] = j;
              answer.append("L");
              break;
            }
            // 3,6,9,#
            if(j==2) {
              rightIdx[0] = i;
              rightIdx[1] = j;
              answer.append("R");
              break;
            }
            // 2,5,8,0
            if(j==1) {
              // 손 위치 별 거리 계산
              int leftLength = Math.abs(i-leftIdx[0]) + Math.abs(j-leftIdx[1]);
              int rightLength = Math.abs(i-rightIdx[0]) + Math.abs(j-rightIdx[1]);
              // 왼손이 가까울 경우
              if(leftLength<rightLength) {
                leftIdx[0] = i;
                leftIdx[1] = j;
                answer.append("L");
                break;
              }
              // 오른손이 가까울 경우
              else if(leftLength>rightLength) {
                rightIdx[0] = i;
                rightIdx[1] = j;
                answer.append("R");
                break;
              }
              // 두손 거리가 같을 경우
              else {
                // 왼손잡이일 경우
                if (hand.equals("right")) {
                  rightIdx[0] = i;
                  rightIdx[1] = j;
                  answer.append("R");
                  break;
                }
                // 오른손잡이일 경우
                else {
                  leftIdx[0] = i;
                  leftIdx[1] = j;
                  answer.append("L");
                  break;
                }
              }
            }
          }
        }
      }
    }
    return answer.toString();
  }

}
