package v1.programmers.level_2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12923

// 조건 중 천만 이상의 블록은 없다고 나오는데 채점시 그 이상의 값에 대해서 오류가 있는 것으로 보입니다.
// 완전한 정답은 아니며 작성 흐름에 대해서 이해만 하고 넘어가도록 하겠습니다.

public class 숫자블록 {
    public int[] solution(long begin, long end) {

        int b = (int) begin; int e = (int) end;
        int[] answer = new int[e - b + 1];

        int idx = 0;
        for (int block = b; block <= e; block++) {
            boolean isPrime = false;

            if (block == 1) {
                answer[idx] = 0;
            }
            else {
                // 최소 약수를 찾는다.
                for (int i=2; i<=Math.sqrt(block); i++) {
                    if (block % i ==0 && block / i <= 10000000) {
                        // 최소 약수에 부합한다면 약수로 나눈 몫이 블록의 숫자가 된다.
                        answer[idx] = block / i;
                        isPrime = true;
                        break;
                    }
                }

                if (!isPrime) answer[idx] = 1;
            }
            idx++;
        }


        return answer;
    }
}
