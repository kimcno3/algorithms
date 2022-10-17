package programmers.level_2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// 주차 요금 계산하기 : https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class ParkingFee {

  /*
   * TreeMap, HashMap을 활용한 문제 풀이
   *
   * key를 기준으로 오름차순 정렬을 한다. -> 차량 번호를 키로 오름차순 정렬
   *
   * 차량 번호를 키로 입차시간을 저장해두고 출차가 될 때 주차시간을 누적 계산
   * 전체 루프가 진행된 이후 누적 계산된 주차 시간을 가지고 주차 요금을 계산
   * 계산된 주차 요금은 TreeMap으로 저장해 차량번호 순으로 정렬되도록 구성
   */

  Map<String, Integer> feeMap = new TreeMap<>(); // 번호 별 주차요금 합계 -> 차량번호 기준으로 오름차순 정렬
  Map<String, String> inTimeMap = new HashMap<>(); // 입차시간 체크
  Map<String, Integer> parkingTimeMap = new HashMap<>(); // 주차시간 체크

  public int[] solution(int[] fees, String[] records) {

    int basicTime = fees[0];
    int basicFee = fees[1];
    int unitTime = fees[2];
    int unitFee = fees[3];

    // 시각 차량번호 내역 루프
    for (String record : records) {

      String[] split = record.split(" ");

      String time = split[0];
      String carNum = split[1];
      String inOut = split[2];

      // 입차인 경우
      if (inOut.equals("IN")) {
        // 주차 진행 중으로 판단
        inTimeMap.put(carNum, time);
      }

      // 출차인 경우
      else {

        // 주차 시간 체크
        checkParkingTime(carNum, time);

        // 입차 시간 삭제
        inTimeMap.remove(carNum);
      }

    }

    // 출차 시간이 안찍힌 차량이 아직 존재하는 경우
    if (!inTimeMap.isEmpty()) {

      for (String carNum : inTimeMap.keySet()) {

        // 주차 시간 체크(출차시간은 23:59 로 고정)
        checkParkingTime(carNum, "23:59");

      }

    }

    for (String carNum : parkingTimeMap.keySet()) {

      // 기본 주차 시간 이하로만 주차한 경우
      if (parkingTimeMap.get(carNum) <= basicTime) {

        feeMap.put(carNum, basicFee); // 기본 요금만 추가

      }

      // 기본 주차 시간 이상만 주차한 경우
      else {

        int finalParkingTime = parkingTimeMap.get(carNum) - basicTime; // 기본주차시간 외 시간

        int finalFee = 0;

        // 요금 계산시 올림이 필요한 경우
        if (finalParkingTime % unitTime > 0) {
          finalFee = ((finalParkingTime / unitTime) + 1) * unitFee; // 단위 시간을 1번 더 추가
        }

        // 정확히 맞아 떨어지는 경우
        else {
          finalFee = ((finalParkingTime / unitTime)) * unitFee;
        }

        // 계산된 요금 추가
        feeMap.put(carNum, basicFee + finalFee);

      }

    }

    // int 배열로 바꿔주는 과정
    int[] answer = new int[feeMap.size()];

    int i=0;
    for (int fee : feeMap.values()) { // feeMap은 TreeMap이기 때문에 정렬이 되어 있다.
      answer[i++] = fee;
    }

    return answer;

  }

  // 주차 시간 계산 로직
  void checkParkingTime(String carNum, String OutTime) {

    String inTime = inTimeMap.get(carNum); // 해당 차량의 입차 시간 체크

    // 주차요금 계산
    int inTimeHour = Integer.parseInt(inTime.substring(0, 2));
    int inTimeMinute = Integer.parseInt(inTime.substring(3));

    int outTimeHour = Integer.parseInt(OutTime.substring(0, 2));
    int outTimeMinute = Integer.parseInt(OutTime.substring(3));

    // 주차 시간 계산 (출차시간 - 입차시간)
    int parkingTime = (outTimeHour * 60 + outTimeMinute) - (inTimeHour * 60 + inTimeMinute);

    // 기존 주차 시간에 계산된 주차시간 추가
    parkingTimeMap.put(carNum, parkingTimeMap.getOrDefault(carNum, 0) + parkingTime);
  }

}
