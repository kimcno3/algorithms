package programmers.level_1;

// 로또 최고 순위와 최저 순위 : https://programmers.co.kr/learn/courses/30/lessons/77484
public class Lottos {

  public static void main(String[] args) {
    int[] lottos = {44, 1, 0, 0, 31, 25};
    int[] win_nums = {31, 10, 45, 1, 6, 19};

    int[] answer = solution(lottos, win_nums);
    System.out.println(answer[0] + ", " + answer[1]);
  }

  public static int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = {0, 0};

    int zeroCount = 0;
    int correctCount = 0;

    // 로또 번호 조회
    for (int lottoNum : lottos) {

      // 0일 경우 -> 지워진 숫자일 경우
      if (lottoNum == 0) {
        // 0 개수 카운트
        zeroCount++;
      }

      // 0이 아닌 경우
      else {
        // 당첨 번호 조회
        for (int winNum : win_nums) {
          // 로또 번호와 당첨 번호가 같은 경우
          if (lottoNum == winNum) {
            // 정답 개수 카운트
            correctCount++;
            break;
          }
        }
      }

    }
    // 모르는 숫자가 전부 정답일 경우
    answer[0] = checkLank(zeroCount+correctCount);
    // 모르는 숫자가 전부 정답이 아닐 경우
    answer[1] = checkLank(correctCount);

    return answer;

    }

    // 정답 개수에 따른 순위 계산 메소드
    public static int checkLank(int count) {

      int lank = 6;

      switch (count) {
        case 1 :
          lank = 6;
          break;
        case 2 :
          lank = 5;
          break;
        case 3 :
          lank = 4;
          break;
        case 4 :
          lank = 3;
          break;
        case 5 :
          lank = 2;
          break;
        case 6 :
          lank = 1;
          break;
        default:
          break;
      }

      return lank;

    }
}
