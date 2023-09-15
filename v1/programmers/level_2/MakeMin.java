package v1.programmers.level_2;

import java.util.Arrays;


/*
 * 최소값 만들기 : https://school.programmers.co.kr/learn/courses/30/lessons/12941

 * 무작정 DFS를 활용하려고만 하니 어려운 문제(재귀함수를 안써본 지 너무 오래된 건가...)
 * 두 배열의 길이가 같은 경우, 두 배열의 누적 합이 최소값이 되려면 A의 최대값 * B의 최소값이면 된다.
 */

public class MakeMin {

  public int solution(int[] A, int[] B) {

    int answer = 0;

    Arrays.sort(A);
    Arrays.sort(B);

    for (int i=0; i<A.length; i++) {
      answer += A[i] * B[B.length - i - 1];
    }

    return answer;

  }

}
