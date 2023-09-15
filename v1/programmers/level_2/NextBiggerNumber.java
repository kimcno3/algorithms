package v1.programmers.level_2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12911
public class NextBiggerNumber {

    public static void main(String[] args) {
        NextBiggerNumber n = new NextBiggerNumber();
        System.out.println(n.solution(78));
        System.out.println(n.solution(15));

    }
    public int solution(int n) {
        int answer;
        int currentNumber = n+1;
        String s = Integer.toBinaryString(n);

        int sn = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') sn++;
        }

        while (true) {
            int numberOfOne = 0;
            String binaryString = Integer.toBinaryString(currentNumber);

            for(char c : binaryString.toCharArray()) {
                if (c == '1') {
                    numberOfOne += 1;
                }
            }

            if (numberOfOne == sn) {
                answer = currentNumber;
                break;
            }

            currentNumber++;
        }

        return answer;
    }
}
