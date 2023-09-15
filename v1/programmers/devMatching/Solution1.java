package v1.programmers.devMatching;

import java.util.*;

class Solution1 {

  public String solution(String[] registered_list, String new_id) {
    String answer = "";

    HashSet<String> set = new HashSet<>(Arrays.asList(registered_list));

    while(true) {
      // 등록된 아이디가 아닌 경우
      if (!set.contains(new_id)) {
        answer = new_id;
        break;
      }
      // 이미 등록된 아이디인 경우
      else {

        String S = "";
        String N = "";

        // N이 있는 경우
        for (int i=0; i<new_id.length(); i++) {
          // N
          if (new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9') {
            S = new_id.substring(0, i);
            N = new_id.substring(i);
            break;
          }
        }

        if (N.equals("")) {
          S = new_id;
          N = "1";
        } else {
          N = String.valueOf(Integer.parseInt(N) + 1);
        }
        new_id = S + N;
      }

    }
    return answer;
  }

}

