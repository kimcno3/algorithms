import java.util.*;

class Solution {
  public int[] solution(String s) {
    s = s.replace("{{", "").replace("}}", "").replace("},{", "/");
    String[] arr = s.split("/");

    Arrays.sort(arr,new Comparator<String>() {
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });

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