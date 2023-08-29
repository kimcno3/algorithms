package programmers.level_1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12917
 */

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        // StringBuilder 객체 생성
        StringBuilder sb = new StringBuilder();
        // 정렬 로직
        Arrays.stream(s.split("")) // String[]로 변환
                .sorted(Comparator.reverseOrder()) // 역순 정렬
                .collect(Collectors.toList()) // 리스트로 변환
                .forEach(sb::append); // 각 요소를 sb에 추가
        // 리턴
        return sb.toString();
    }
}
