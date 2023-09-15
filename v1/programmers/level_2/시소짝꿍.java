package v1.programmers.level_2;

// https://school.programmers.co.kr/learn/courses/30/lessons/152996

import java.util.Arrays;
import java.util.StringTokenizer;

public class 시소짝꿍 {

    public static void main(String[] args) {


        StringTokenizer st = new StringTokenizer("GLGRGRB", "RL", true);

        while(st.hasMoreTokens()) {
            System.out.println(Arrays.toString(st.nextToken().toCharArray()));
        }
    }

}