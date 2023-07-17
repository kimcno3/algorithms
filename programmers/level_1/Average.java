package programmers.level_1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.OptionalDouble;

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12944
public class Average {
    public static void main(String[] args) {
        Average average = new Average();
        System.out.println(average.solution(new int[]{1,2,3,4})); // 2.5
        System.out.println(average.solution2(new int[]{1,2,3,4})); // 2.5
    }
    public double solution(int[] arr) {
        // 1
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return (double) sum / arr.length;

    }

    public double solution2(int[] arr) {
        return Arrays.stream(arr).average().orElse(0); // average() 사용
    }
}
