package v1.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 튜플 : https://school.programmers.co.kr/learn/courses/30/lessons/64065
public class Tuple {

  public static void main(String[] args) {
    String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
    Tuple tuple =  new Tuple();
    int[] answer = tuple.solution(s);

    for (int num : answer) {
      System.out.print(num + " ");
    }
  }

  public int[] solution(String s) {

    s = s.replace("{{", "").replace("}}", "");
    s = s.replace("},{", "/");
    String[] arr = s.split("/");

    // Comparator 의 compare() 메소드를 구현해서 배열 내 값의 길이를 가지고 오름차순으로 정렬한다.
    // Integer.compare() 은 o1이 o2보다 작다면 -1, 같다면 0, 크다면 1을 리턴한다.
    // 1일 경우에는 두 매개변수의 위치를 바꾼다.(오름차순)
    // 내림차순으로 정렬하고 싶은 경우 매개변수의 위치를 바꿔주면 된다.

    Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

    List<String> list = new ArrayList<>();

    for (String str : arr) {

      if (str.length() == 1) {
        list.add(str);
      }

      for (String num : str.split(",")) {

        if (!list.contains(num)) {
          list.add(num);
        }

      }

    }

    int[] answer = new int[list.size()];

    for (int i=0; i<answer.length; i++) {
      answer[i] = Integer.parseInt(list.get(i));
    }

    return answer;
  }
}
