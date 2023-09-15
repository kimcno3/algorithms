package v1.programmers.level_3;

// https://school.programmers.co.kr/learn/courses/30/lessons/43238

public class 입국심사 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long low = 0;
        long high = 1_000_000_000L;

        while (low < high) {
            long mid = (low + high) / 2;

            long c = 0;
            for (int time : times) {
                c += mid / time; // 최대 심사 가능 수
            }

            if (c >= n) high = mid; // 최대 심사 가능 수가 실제 심사 수보다 크다면 high를 다운
            else if (c < n) low = mid + 1; // 적다면 업

            System.out.println(mid);
        }

        return low;
    }
}
