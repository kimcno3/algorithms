package v1.programmers.level_2;

/**
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/68645

 * 거리두기 2에 대한 별도의 처리가 필요하지 않다. ny,nx 위치가 어떤 값이냐에 따라 다른 로직을 태우면 된다.
 * P : 실패한다.
 * O : 이 위치에서 1거리에 있는 곳들 중 P가 있는지 확인한다.
 * X : 별도의 처리를 하지 않는다.

 */

public class 거리두기확인하기 {

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // 거리 1 이동
        int[] dx1 = new int[]{0, -1, 0, 1};
        int[] dy1 = new int[]{-1, 0, 1, 0};

        // 거리 2
        int[] dx2 = new int[]{0,-1, -2, -1, 0, 1, 2, 1};
        int[] dy2 = new int[]{-2, -1, 0, 1, 2, 1, 0, -1};

        int placeIdx = 0;
        // place 별로 루프 진행
        for (String[] place : places) {
            // 거리두기 판별 상태 초기화
            boolean isOver = false;

            // 대기실을 5 X 5 배열로 저장
            String[][] waitingRoom = new String[5][5];
            for (int i=0; i<place.length; i++) {
                String[] row = place[i].split("");
                for (int j=0; j<row.length; j++) {
                    waitingRoom[i][j] = row[j];
                }
            }

            // 루프를 돌면서 P을 찾는다.
            for (int y=0; y<waitingRoom.length; y++) {
                for (int x=0; x<waitingRoom[y].length; x++) {
                    // P를 찾은 경우
                    if (waitingRoom[y][x].equals("P")) {

                        // 거리 1 비교
                        for (int i=0; i<4; i++) {
                            int nx = x + dx1[i];
                            int ny = y + dy1[i];
                            // 대기실 밖은 제외
                            if (0 > nx || nx >= 5 || 0 > ny || ny >= 5) continue;
                            // 만약 다른 대기자가 있다면 O으로 제외
                            if (waitingRoom[ny][nx].equals("P")) {
                                isOver = true;
                                break;
                            }
                        }

                        // 거리 2 비교
                        for (int i=0; i<8; i++) {
                            int nx = x + dx2[i];
                            int ny = y + dy2[i];

                            // 대기실 밖은 제외
                            if (0 > nx || nx >= 5 || 0 > ny || ny >= 5) continue;

                            // 만약 다른 대기자가 있다면
                            if (waitingRoom[ny][nx].equals("P")) {

                                // 파티션 유무를 따져서 거리두기 지키는지 확인
                                // 직선인 경우
                                if (x == nx || y == ny) {
                                    // 사이 공간이 파티션이 아니면 거리두기 실패
                                    if (!waitingRoom[(y+ny)/2][(x+nx)/2].equals("X")) {
                                        isOver = true;
                                        break;
                                    }
                                }
                                // 대각선
                                else {
                                    // 사이 두 공간이 파티션이 아니면 거리두기 실패
                                    if (!waitingRoom[y][nx].equals("X") || !waitingRoom[ny][x].equals("X")) {
                                        isOver = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    // 만약 안지킨 사람이 있다면 게임 더 이상 루프를 돌지 말고 끝낸다.
                    if (isOver) {
                        answer[placeIdx] = 0;
                        break;
                    }
                }
                // 루프를 끝까지 돈 다음에 이상이 없다면 거리두기를 잘 지키고 있다고 판단한다.
                if (!isOver) {
                    answer[placeIdx] = 1;
                }
            }
            // 다음 대기실로 이동
            placeIdx++;
        }

        return answer;
    }
}
