class Solution {
    
    private static String[] strings = new String[] {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for (String str : babbling) {
            int count = 0;
            
            for (String s: strings) {
                if (!str.contains(s)) continue;
                
                count += s.length();
                
                if (count == str.length()) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}