package baekjoon.collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9093 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // 결과값을 담을 변수 선언
    // append()를 활용하기 위해 StringBuilder 타입으로 선언
    StringBuilder result = new StringBuilder();
    // 입력된 문장 개수
    int length = Integer.parseInt(br.readLine());
    // 문장 반복
    for (int i=0; i<length; i++) {
      // 띄어쓰기를 기준으로 단어를 구분한 배열 생성
      String[] arr = br.readLine().split(" ");
      // 단어 반복
      for (int j=0; j<arr.length; j++) {
        // StringBuilder 로 형변환
        StringBuilder word = new StringBuilder(arr[j]);
        // 단어를 뒤집은 다음 result에 추가
        result.append(word.reverse() + " ");
      }
      // result 출력 -> 뒤집은 단어를 합친 문장
      System.out.println(result);
      // result 초기화
      result.delete(0, result.length());
    }
  }
}
