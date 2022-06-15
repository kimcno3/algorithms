package programmers.level_1;

import java.util.HashSet;

// 폰켓몬 : https://programmers.co.kr/learn/courses/30/lessons/1845
public class PhoneCatMon {

  public static void main(String[] args) {
    int[] nums = {3,1,2,3};
    System.out.println(solution(nums));
  }

  public static int solution(int[] nums) {
    int answer = 0;

    // 폰켓몬의 종류수를 알아보기 위해 중복을 제거할 수 있는 set 자료구조를 선택(핵심)
    HashSet<Integer> set = new HashSet<>();

    // 중복없이 폰켓몬 종류 저장
    for (int num : nums) {
      set.add(num);
    }

    // 골라야 하는 폰켓몬 수보다 폰켓몬 종류가 많을 경우 -> 최대로 고를 수 있는 종류 수는 폰켓몬 수로 본다.
    if (nums.length/2 < set.size()) {
      answer = nums.length/2;
    }
    // 그 외 경우는 폰켓몬 종류수 만큼 골라갈 수 있는 경우로 본다.
    else {
      answer = set.size();
    }

    return answer;
  }
}
