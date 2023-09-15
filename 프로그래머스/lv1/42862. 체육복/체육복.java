import java.util.*;

class Solution {
  public int solution(int n, int[] lost, int[] reserve) {
    int answer = 0;

    HashSet<Integer> lostSet = new HashSet<>();
    HashSet<Integer> reserveSet = new HashSet<>();

    // 잃어버린 학생들 추가
    for (int i : reserve) {
      reserveSet.add(i);
    }
    // 여벌의 옷을 챙겨온 학생들 추가
    for (int i : lost) {
      // 잃어버린 학생과 여벌을 챙겨온 학생이 같지 않을 경우에만 빌려줄 수 있는 학생으로 포함
      if (reserveSet.contains(i)) {
        reserveSet.remove(i);
      } else {
        lostSet.add(i);
      }
    }
    for (int i : reserveSet) {
      if (lostSet.contains(i-1)) {
        lostSet.remove(i-1);
      } else if (lostSet.contains(i+1)) {
          lostSet.remove(i+1);
      }
    }
    answer =  n - lostSet.size();
    return answer;
  }
}