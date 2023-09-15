class Solution {
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