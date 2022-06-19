package programmers.level_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 오픈 채팅방 : https://programmers.co.kr/learn/courses/30/lessons/42888
public class OpenChattingRoom {

  public static void main(String[] args) {
    String[] record = {
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    };

    for (String str : solution(record)) {
      System.out.println(str);
    }

  }

  public static String[] solution(String[] record) {
    Map<String, String> map = new HashMap<>();
    List<String> list = new ArrayList<>();

    for (String message : record) {
      String[] splitMessage = message.split(" ");
      String command = splitMessage[0];
      String uid = splitMessage[1];

      // Enter
      if (command.equals("Enter")) {
        String name = splitMessage[2];
        map.put(uid, name);
        list.add(uid + "님이 들어왔습니다.");
      }
      // Leave
      else if(command.equals("Leave")) {
        list.add(uid + "님이 나갔습니다.");
      }
      // Change
      else if(command.equals("Change")) {
        String name = splitMessage[2];
        map.put(uid, name);
      }
    }

    for (String key : map.keySet()) {
      list.replaceAll((message) -> message.replaceAll(key, map.get(key)));
    }

    String[] answer = new String[list.size()];

    for(int i=0; i<answer.length; i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }

}
