package baekjoon;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = "";
        String[][] keypad = {
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"},
            {"*","0","#"}
        };

        int[] lIdx = {3,0};
        int[] rIdx = {3,2};

        // 입력 받는 숫자 loop
        for (int num : numbers) {
            // 키패드 이중 loop
            for (int i=0; i<keypad.length; i++) {
                for (int j=0; j<keypad[i].length; j++) {
                    // 같은 숫자일 경우
                    if (String.valueOf(num).equals(keypad[i][j])){
                        // 1,4,7,*
                        if(j==0) {
                            lIdx[0] = i;
                            lIdx[1] = j;
                            answer += "L";
                            break;
                        }
                        // 3,6,9,#
                        if(j==2) {
                            rIdx[0] = i;
                            rIdx[1] = j;
                            answer += "R";
                            break;
                        }
                        // 2,5,8,0
                        if(j==1) {
                            // 손 위치 별 거리 계산
                            int leftLength = Math.abs(i-lIdx[0]) + Math.abs(j-lIdx[1]);
                            int rightLength = Math.abs(i-rIdx[0]) + Math.abs(j-rIdx[1]);
                            // 왼손이 가까울 경우
                            if(leftLength < rightLength) {
                                lIdx[0] = i;
                                lIdx[1] = j;
                                answer += "L";
                            }
                            // 오른손이 가까울 경우
                            else if(leftLength > rightLength) {
                                rIdx[0] = i;
                                rIdx[1] = j;
                                answer += "R";
                            }
                            // 두손 거리가 같을 경우
                            else {
                                // 왼손잡이일 경우
                                if (hand.equals("right")) {
                                    rIdx[0] = i;
                                    rIdx[1] = j;
                                    answer += "R";
                                }
                                // 오른손잡이일 경우
                                else {
                                    lIdx[0] = i;
                                    lIdx[1] = j;
                                    answer += "L";
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}