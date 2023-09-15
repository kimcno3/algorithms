class Solution {
    public int solution(int n) {
        
        int[] arr = new int[n+1];
        
        int num = 1;
        int idx = 1;
        
        while(idx <= n) {
            if (num%3 != 0 && String.valueOf(num).indexOf("3") == -1) arr[idx++] = num;
            num++;
        }
        
        return arr[n];
    }
}