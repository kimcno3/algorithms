package programmers.level_2;

import java.util.Arrays;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * 참고 자료 : https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-H-Index-Java
 */

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        // 오름차순 정렬
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            // 인용된 논문의 수
            int h = citations.length - i;
            // 인용된 논문의 수보다 해당 인덱스의 논문의 인용수가 크거나 같아야 한다.
            if(citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
