package programmers.level_2;

import java.util.ArrayList;

// 카펫 : https://school.programmers.co.kr/learn/courses/30/lessons/42842

/*
 * 힌트1 : 전체 타일의 수를 가지고 약수의 경우의 수를 구한다.
 * 힌트2 : 노란 카펫의 넓이 = (전체 카펫의 가로길이 - 2) * (전체 카펫의 세로길이 - 2)
 */

public class Carpet {

  public int[] solution(int brown, int yellow) {

    int[] answer = new int[2];
    ArrayList<int[]> list = new ArrayList<>();

    int sum = brown + yellow;

    // brown + yellow 수에 대한 약수를 구한다.
    for (int i=1; i <= Math.sqrt(sum); i++) { // 약수를 구할땐 제곱근까지만 루프를 진행한다.!

      if (sum % i == 0) {
        list.add(new int[]{sum / i, i});
      }

    }

    // (x-2) * (y-2) = yellow 인 값을 찾아라!
    for (int[] temp : list) {
      if ((temp[0] - 2) * (temp[1] - 2) == yellow) {
        answer = temp;
      }
    }

    return answer;
  }

}
