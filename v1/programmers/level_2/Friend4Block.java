package v1.programmers.level_2;

import java.util.*;

// [1차] 프렌즈4블록 : https://school.programmers.co.kr/learn/courses/30/lessons/17679
public class Friend4Block {

  public static void main(String[] args) {
    String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    System.out.println(solution(4,5, board));

  }


  // 두번째 예시에서 OutOfBounceException 발생한다.
  public static int solution(int m, int n, String[] board) {
    int answer = 0;
    List<LinkedList<String>> queues = new ArrayList<>();

    for (int i=0; i<n; i++) {
      queues.add(new LinkedList<>());
    }

    for (int i=0; i<n; i++) {
      for (int j=m-1; j>=0; j--) {
        String text = board[j].split("")[i];
        queues.get(i).add(text);
      }
    }
    boolean flag = true;

    while(flag) {
      List<int[]> list = new LinkedList<>();

      for (int i=0; i<n-1; i++) {
        for (int j=0; j<queues.get(i).size()-1; j++) {
          String pointStr = queues.get(i).get(j);
          String str1 = queues.get(i).get(j + 1);
          String str2 = queues.get(i + 1).get(j);
          String str3 = queues.get(i + 1).get(j + 1);

          if (pointStr.equals(str1) && pointStr.equals(str2) && pointStr.equals(str3)) {
            list.add(new int[]{i,j});
          }
        }
      }

      if (list.size() == 0) {
        flag = false;
        break;
      }

      for (int x=0; x<list.size(); x++) {
        int i = list.get(x)[0];
        int j = list.get(x)[1];

        if (j == queues.get(i).size()-1) {
          queues.get(i+1).remove(j);
          queues.get(i+1).remove(j);
          answer += 2;
        } else {
          queues.get(i).remove(j);
          queues.get(i).remove(j);
          queues.get(i+1).remove(j);
          queues.get(i+1).remove(j);
          answer += 4;
        }
      }
    }

    for (int x=0;x<n; x++) {
      for (int y=0; y<queues.get(x).size(); y++) {
        System.out.print(queues.get(x).get(y) + " ");
      }
      System.out.println();
    }
    return answer;
  }
}

