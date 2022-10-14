package programmers.level_2;




// 피보나치 수 : https://school.programmers.co.kr/learn/courses/30/lessons/12945
public class FibonacciNumbers {

  /*
   * 1234567의 나머지로 값을 구하는 이유
     * int 타입의 비트 수를 고려한 방법!
     * (A+B)%C == ((A%C) + (B%C)) % C 라는 성질을 이용
     * 또한 1234567로 나눈 나머지는 1234567보다 클 수 없다.
     * 자세한 설명 : https://mozzioi.tistory.com/147
   */

  // DP를 위한 멤버 변수로 배열 선언
  int[] arr;

  public int solution(int n) {

    // 인덱스가 0 ~ n 까지 있어야 함으로 n+1 만큼 배열 크기 설정
    arr = new int[n+1];

    // 1인 경우, 1을 리턴하게 되어 있기 때문에 별도로 저장 (0은 이미 0으로 저장되어 있으니 생략)
    arr[1] = 1;

    return method(n);

  }

  // 재귀함수 메소드
  int method(int n) {

    // 0일 경우는 0을 리턴
    if (n == 0) {
      return arr[0];
    }

    // 1부터 n 까지의 수 중 이전에 계산된 경우는 계산된 값만 바로 리턴
    else if (arr[n] != 0) {
      return arr[n];
    }

    // 아직 계산되지 않은 녀석이라면 재귀함수 동작
    else {
      // arr 에 저장할 때 int 타입의 비트 수를 고려해 1234567로 나눈 나머지값 저장
      arr[n] = (method(n - 1) + method(n - 2)) % 1234567;
      return arr[n]; // 저장된 값 리턴
    }

  }

}
