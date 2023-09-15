class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        
        int answer = n * n;
        boolean[][] visits = new boolean[n][n];
        
        for (int y=0; y<n; y++) {
            for (int x=0; x<n; x++) {
                if (board[y][x] == 0) continue;
                
                for (int ny=y-1; ny<=y+1; ny++) {
                    for (int nx=x-1; nx<=x+1; nx++) {
                        
                        if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                        if (visits[ny][nx]) continue;
                        
                        visits[ny][nx] = true;
                        answer--;
                        
                    }
                }
            }
        }
        
        return answer;
    }
}