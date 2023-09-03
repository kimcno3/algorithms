package programmers.level_2;

import java.util.Arrays;

/**
 * 문제 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/49993
 */

public class 스킬트리 {

    /** 답안지 참고 풀이
     * replaceAll() 과 startWith()를 사용해 더 간단한 Stream 함수 코드 생성 가능
     */

    public int solutionV2(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }

    /** 풀이
     * 스킬 수가 적기 때문에 완전 탐색으로 시작한다.
     * 트리를 하나씩 루프 돌면서 선행 스킬에 포함되는 지 확인한다.
     * 선행 스킬은 인덱스로 유지한다. 만약 1번 스킬을 지나쳤다면 인덱스 + 1
     * 만약 아직 순서가 아닌 스킬이 나온다면 실패로 간주한다.
     */

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // 스킬 트리 하나씩 루프
        for (String skillTree : skill_trees) {
            // 나와야 할 선행 스킬 인덱스
            int idx = 0;
            // 정상적으로 선행 스킬을 배웠는지 여부 판단을 위한 boolean 변수
            boolean isCorrect = true;
            // 스킬 트리 순서대로 루프
            for (char currentSkill : skillTree.toCharArray()) {
                // 선행 스킬에 현재 스킬이 포함되어 있는지 확인
                if (skill.indexOf(currentSkill) != -1) {
                    // 포함된 선행 스킬 순서가 올바른지 확인
                    if (skill.indexOf(currentSkill) == idx) {
                        // 맞다면 인덱스를 + 1 : 다음 선행 스킬 순서로 넘겨주는 것!
                        idx++;
                    }
                    // 만약 순서가 틀린 경우
                    else {
                        // 루프를 종료 시키면서 비정상적인 스킬트리로 간주
                        isCorrect = false;
                        break;
                    }
                }
            }
            // 루프 종료 후 정상 여부를 기준으로 answer 값 추가
            if (isCorrect) answer++;
        }
        // 결과 리턴
        return answer;
    }
}
