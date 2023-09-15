import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        HashMap<Integer, Double> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
          double days = Math.ceil((100.0-progresses[i])/speeds[i]);
          map.put(i, days);
        }

        int count = 1;
        double maxDays = map.get(0);

        for (int i=1; i<map.size(); i++) {
          if (map.get(i) <= maxDays) {
            count++;
          } else {
            list.add(count);
            maxDays = map.get(i);
            count = 1;
          }
        }
        list.add(count);

        int[] answer = new int[list.size()];

        for (int i=0; i<answer.length; i++) {
          answer[i] = list.removeFirst();
        }

        return answer;

    }
}