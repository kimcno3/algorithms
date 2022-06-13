package programmers.level_1;

import java.util.*;

// 체육복 : https://programmers.co.kr/learn/courses/30/lessons/42862#
public class TrainingSuit {

  public static void main(String[] args) {
    int n1 = 5;
    int[] lost1 = {2,4};
    int[] reserve1 = {1,3,5};
    System.out.println(solution(n1, lost1, reserve1));
  }

  public static int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;
    int lostCount = lost.length;
    Set<Integer> set = new HashSet<>();

    for (int lostStudent : lost) {
      for (int reserveStudent : reserve) {
        // 잃어버린 학생과 빌려줄 수 있는 학생과 붙어있지 않은 경우 또는 이미 빌려주기로 한 학생이 있는 경우
        // -> 다음 학생을 비교
        if (reserveStudent > lostStudent+1 || set.contains(reserveStudent)) {
          continue;
        }
        // 빌려줄 수 있는 학생이 잃어버린 학생의 앞,뒤 혹은 본인인 경우
        // -> 빌려줄 수 있는 학생 번호는 set 에 저장(본인인 경우는 본인이 본인에게 빌려주기로 한다고 생각)
        else if (lostStudent-1 <= reserveStudent && reserveStudent <= lostStudent+1) {
          lostCount--;
          set.add(reserveStudent);
          break;
        }
      }
    }
    answer = n-lostCount;
    return answer;
  }

}
