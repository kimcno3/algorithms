import java.util.*;

class Solution {

  int[] arr;

  public int solution(int n) {

    arr = new int[n+1];

    arr[0] = 0;
    arr[1] = 1;

    return method(n);

  }

  int method(int n) {

    if (n == 0) {
      return arr[0];
    }

    // 이미 계산한 값이 존재하면 해당값만 리턴
    else if (arr[n] != 0) {
      return arr[n];
    }

    // 그렇지 않다면 재귀함수 동작
    else {
      arr[n] = (method(n - 1) + method(n - 2)) % 1234567;
      return arr[n];
    }

  }

}