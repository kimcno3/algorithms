package programmers.level_1;

import java.util.*;

// 두개 뽑아서 더하기 : https://programmers.co.kr/learn/courses/30/lessons/68644
public class PlusTwoNumber {

  public static void main(String[] args) {
    int[] numbers = {2,1,3,4,1,5,2,4,5};
    int[] answer = solution(numbers);

    for (int num : answer) {
      System.out.println(num);
    }

    int[] answer2 = solution2(numbers);

    for (int num : answer2) {
      System.out.println(num);
    }

  }

  // HashSet 활용
  public static int[] solution(int[] numbers) {
    Set<Integer> set = new HashSet<>();

    for (int i=0; i<numbers.length-1; i++) {
      for (int j=i+1; j<numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }

    int[] answer = new int[set.size()];
    Iterator<Integer> iterator = set.iterator();
    int i=0;

    while (iterator.hasNext()) {
      answer[i] = iterator.next();
      i++;
    }

    Arrays.sort(answer);

    return answer;

  }

  // TreeSet 활용 -> 배열 정렬이 필요 없다는 장점이 있다.
  public static int[] solution2(int[] numbers) {
    Set<Integer> set = new TreeSet<>();

    for (int i=0; i<numbers.length-1; i++) {
      for (int j=i+1; j<numbers.length; j++) {
        set.add(numbers[i] + numbers[j]);
      }
    }

    int[] answer = new int[set.size()];
    Iterator<Integer> iterator = set.iterator();
    int i=0;

    while (iterator.hasNext()) {
      answer[i] = iterator.next();
      i++;
    }

    return answer;

  }
}
