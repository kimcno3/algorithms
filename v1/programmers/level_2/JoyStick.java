package v1.programmers.level_2;

public class JoyStick {

  public static void main(String[] args) {
    JoyStick joyStick = new JoyStick();

    System.out.println(joyStick.solution("JEROEN"));
    System.out.println();
    System.out.println(joyStick.solution("JAN"));
  }

  // 조이스틱 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
  public int solution(String name) {
    int answer = 0;

    int aCnt = 0;
    for (int i=0; i<name.length(); i++) {

      answer += upDownCheck(name.charAt(i));



      /*
       * 힌트
         * 상,하 횟수와 좌,우 횟수를 따로 구해보기(어찌되었든 상하움직임은 가져간다. 좌, 우 최소 움직임만 구해보면 된다.)
         * Math.min()을 활용해보기
         * 나올 수 있는 좌 우 움직임 경우의 수
           1. 오른쪽으로 쭉 가는 경우(BBBAYYY)
           2. 오른쪽으로 가다가 다시 왼쪽으로 가는 경우(BBAAAAAYYY)
           3. 왼쪽으로 가서 마지막 행부터 처리한 다음, 다시 오른쪽으로 가는 경우(CCCAAAAAAY)
       */


      // 현재 위치에서 다음 단어가 A라면
      if (i < name.length()-1 && name.charAt(i+1) == 'A') {

        // 연속적으로 나오는 A의 개수가 몇개인지를 확인
        int idx = i+1;
        while(idx < name.length()-1 && name.charAt(idx) == 'A') {
          aCnt++;
          idx++;
        }

        // 반대로 가는 횟수보다 현재 방향으로 가는 횟수가 많다면 반복문을 반대로 돌린다.
        if (i < i+aCnt+1) {
          // 반대로 간 커서 횟수 체크
          answer += i+1;


          for (int j=name.length()-1; j>i; j--) {
            answer += upDownCheck(name.charAt(j));
          }

          break;
        }
      }

      // 정방향으로 그대로 갔다면 커서 횟수 하나 추가. 하지만 마지막 문자는 제외
      else {
        if(!(i == name.length()-1)) {
          answer++;
        }
      }

    }
    // 결과 리턴
    return answer;
  }

  public int upDownCheck(char ch) {
    // 커서 아래
    if (ch >= 'N') {
      return 'Z' - ch + 1; // 시작은 A부터 이므로 +1
    }

    // 커서 위
    else {
      return ch - 'A';
    }
  }

}
