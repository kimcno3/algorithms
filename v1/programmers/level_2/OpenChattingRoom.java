package v1.programmers.level_2;

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
    for (String str : solution3(record)) {
      System.out.println(str);
    }
  }

  // 1차 작성 코드 -> 테스트 코드 일부 실패
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
      // Change
      else if(command.equals("Change")) {
        String name = splitMessage[2];
        map.put(uid, name);
      }
      // Leave
      else if(command.equals("Leave")) {
        list.add(uid + "님이 나갔습니다.");
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

  // 2차 수정 코드 -> 답안 코드와 크게 다른 점을 모르겠는데 테스트코드 실패...
  public static String[] solution2(String[] record) {
    Map<String, String> map = new HashMap<>();
    int logCount = 0;

    for (String message : record) {
      String[] splitMessage = message.split(" ");

      switch (splitMessage[0]) {
        case "Leave" :
          logCount++;
          break;
        case "Enter" :
          logCount++;
          map.put(splitMessage[1], splitMessage[2]);
          break;
        case "Change" :
          map.put(splitMessage[1], splitMessage[2]);
          break;
        default:
          break;
      }
    }

    String[] answer = new String[logCount];

    for (int i=0; i<answer.length; i++) {
      String[] splitMessage = record[i].split(" ");

      switch(splitMessage[0]) {
        case "Enter" :
          answer[i] = map.get(splitMessage[1]) + "님이 들어왔습니다.";
          break;
        case "Leave" :
          answer[i] = map.get(splitMessage[1]) + "님이 나갔습니다.";
          break;
        default:
          break;
      }
    }
    return answer;
  }

  // 답안 코드
  public static String[] solution3(String[] record) {
    String[] answer = {};
    HashMap<String,String> users = new HashMap<String,String>();//HashMap생성
    int cnt = 0;
    for(String r : record) {

      String[] details = r.split(" ");
      switch(details[0]) {
        case "Leave":
          ++cnt;
          break;
        case "Enter":
          ++cnt;
          users.put(details[1], details[2]);
          break;
        default:
          users.put(details[1], details[2]);
          break;
      }

    }
    answer = new String[cnt];
    cnt = 0;
    for(String r : record) {
      String[] details = r.split(" ");
      switch(details[0]) {
        case "Change":
          break;
        case "Enter":
          // Prodo님이 들어왔습니다.
          answer[cnt++]=users.get(details[1])+"님이 들어왔습니다.";
          break;
        case "Leave":
          // Prodo님이 나갔습니다.
          answer[cnt++]=users.get(details[1])+"님이 나갔습니다.";
      }
    }
    return answer;
  }
}
