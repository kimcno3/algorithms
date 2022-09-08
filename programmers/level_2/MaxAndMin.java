package programmers.level_2;

import java.util.*;

public class MaxAndMin {

    public static void main(String[] args) {
        MaxAndMin maxAndMin = new MaxAndMin();
        System.out.println(maxAndMin.solution("1 2 3 4"));
        System.out.println(maxAndMin.solution("-1 -2 -3 -4"));
        System.out.println(maxAndMin.solution("-1 -1"));
    }

    public String solution(String s) {
        String[] split = s.split(" ");

        int[] arr = new int[split.length];

        for (int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        return arr[0] + " " + arr[arr.length - 1];
    }

}