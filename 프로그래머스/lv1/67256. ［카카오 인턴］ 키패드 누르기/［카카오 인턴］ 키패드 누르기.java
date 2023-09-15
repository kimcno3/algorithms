
class Solution {
    // L, R 위치를 저장할 변수 -> 시작점은 *, #에 위치
    private int[] L = {3, 0};
    private int[] R = {3, 2};

    public String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();
        // 숫자 하나씩 루프
        for (int number : numbers) {
            int x;
            int y;
            // 숫자를 가지고 배열의 x,y 값 추출
            if (number == 0) {
                x = 1;
                y = 3;
            } else if (number % 3 == 0) {
                x = 2;
                y = (number / 3) - 1;
            } else {
                x = (number % 3) - 1;
                y = number / 3;
            }
            // x값을 기준으로 조건을 나눈다.
            // x==0 : 무조건 왼손
            if (x == 0) moveLeftHand(sb, x, y);
            // x==2 : 무조건 오른손
            else if (x == 2) moveRightHand(sb, x, y);
            // x==1 : 가까운 쪽 손이 이동
            else {
                // 왼손, 오른손의 위치 기준으로 거리 계산
                int left = Math.abs(L[0] - y) + Math.abs(L[1] - x);
                int right = Math.abs(R[0] - y) + Math.abs(R[1] - x);
                // 왼손이 가까우면 왼손이
                if (left < right) moveLeftHand(sb, x, y);
                // 오른손이 가까우면 오른손이
                else if (right < left) moveRightHand(sb, x, y);
                // 거리가 같으면
                else {
                    // 왼손잡이라면 왼손
                    if (hand.equals("left")) moveLeftHand(sb, x, y);
                    // 오른손잡이면 오른손
                    else moveRightHand(sb, x, y);
                }
            }
        }
        return sb.toString();
    }

    private void moveLeftHand(StringBuilder sb, int x, int y) {
        sb.append("L");
        L[0] = y;
        L[1] = x;
    }

    private void moveRightHand(StringBuilder sb, int x, int y) {
        sb.append("R");
        R[0] = y;
        R[1] = x;
    }
}