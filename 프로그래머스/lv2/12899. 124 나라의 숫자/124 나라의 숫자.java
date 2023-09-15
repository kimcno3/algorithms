class Solution {
    public String solution(int n) {
    String answer = "";
    StringBuilder sb = new StringBuilder();

    while(n>3) {
      if (n%3 == 0) {
        sb.append(4);
        n = (n/3) - 1;
      }else if (n%3 == 1 || n%3 == 2) {
        sb.append(n%3);
        n /= 3;
      }
    }
    
    if (n==1 || n==2) {
      sb.append(n);
    } else if (n==3) {
      sb.append(4);
    }
        
    sb.reverse();
        
    answer = sb.toString();
        
    return answer;
    }
}