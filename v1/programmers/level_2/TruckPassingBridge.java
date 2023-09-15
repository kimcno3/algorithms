package v1.programmers.level_2;

import java.util.LinkedList;

// 다리를 지나는 트럭 : https://school.programmers.co.kr/learn/courses/30/lessons/42583
public class TruckPassingBridge {

  /* 답안 참고 코드
   *
   * 하나의 while문에서 index를 사용하는 것이 아니라 for문 안에 while문에 개별 동작하도록 구현
   *
   * 나올 수 있는 경우의 수
   * 1. 다리가 비어있는 경우
   * 2. 다리의 길이에 꽉차기 트럭이 올라가 있어 추가 트럭을 올리지 못하는 경우
   * 3. 다리에 자리가 남아있는 경우
   *   3-1. 트럭 무게 총합이 제한 무게를 초과해 추가할 수 없는 경우
   *   3-2. 트럭 무게 총합이 제한 무게 이내에 들어와 추가할 수 있는 경우
   */

  public int solution(int bridge_length, int weight, int[] truck_weights) {

    LinkedList<Integer> queue = new LinkedList<>();

    int sum=0;
    int answer = 0;

    for (int truck : truck_weights) {

      while(true) {
        // 1.
        if (queue.isEmpty()) {
          queue.add(truck); // 다리에 트럭 올리고
          sum += truck; // 무게합 더하고
          answer++; // 시간 추가
          break;
        }
        // 2.
        else if(queue.size() == bridge_length) {
          sum -= queue.removeFirst();
        }
        // 3.
        else {
          // 3-1.
          if(sum + truck > weight) {
            queue.add(0); // 0kg을 넣어서 다음 루프에서 2-1이 발생하도록 유도
            answer++;
          }
          // 3-2.
          else if(sum + truck <= weight) {
            queue.add(truck); // 다리에 트럭 올리고
            sum += truck; // 무게합 더하고
            answer++;
            break;
          }
        }

      }

    }


    return answer + bridge_length;
  }


  /* 실패 코드
   *
   * 실패 이유
   * 1. 경우의 수에 따라 조건식의 범위를 제대로 잡지 못한 점
   * 2. 이로 인해 반복적인 코드가 발생하고, 복잡한 로직으로 인해 이후 작업이 매우 어려워진 점
   * 3. Truck 클래스를 생성해 활용하려 했던 점은 객체지향스럽게 접근해본 방법이지 않나 싶지만 결국엔 복잡한 로직 구현에 한 몫
   */

  public int solutionFail(int bridge_length, int weight, int[] truck_weights) {

    LinkedList<Track> queue = new LinkedList<>();

    int answer = 1;
    int idx = 0;
    int currentWeight = 0;
    int clearCount = 0;

    while(clearCount < truck_weights.length) {

      if (queue.size() == 0) {
        currentWeight = weight - truck_weights[idx];
        queue.add(new Track(truck_weights[idx++], answer + bridge_length));
        continue;
      }
      // 시간 비교
      if (queue.getFirst().time == answer) {
        Track track = queue.removeFirst();
        currentWeight += track.getTruckWeight();
        clearCount++;
      }

      if(idx == truck_weights.length) {
        answer++;
        continue;
      }

      if (queue.size() == 0) {
        currentWeight = weight - truck_weights[idx];
        queue.add(new Track(truck_weights[idx++], answer  + bridge_length));
        continue;
      }

      // 무게 비교
      if (currentWeight > truck_weights[idx]) {
        currentWeight = weight - truck_weights[idx];
        queue.add(new Track(truck_weights[idx++], answer + bridge_length));
      }

      answer++;

    }

    return answer;

  }

  static class Track {

    int truckWeight;
    int time;

    public Track(int truckWeight, int time) {
      this.truckWeight = truckWeight;
      this.time = time;
    }

    public int getTruckWeight() {
      return truckWeight;
    }

    public void setTruckWeight(int truckWeight) {
      this.truckWeight = truckWeight;
    }

    public int getTime() {
      return time;
    }

    public void setTime(int time) {
      this.time = time;
    }

    @Override
    public String toString() {
      return "Track{" +
          "truckWeight=" + truckWeight +
          ", time=" + time +
          '}';
    }
  }

}
