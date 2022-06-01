package programmers.level_1;

// 카카오 인턴 - 키패드 누르기 : https://programmers.co.kr/learn/courses/30/lessons/67256

public class keyPad {
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
