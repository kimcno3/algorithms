class Solution {
  public int solution(int[] nums) {
    int length = nums.length;
    int answer = 0;
    int sum = 0;

    // 세 숫자의 합에 대한 모든 경우의 수 계산 loop
    for (int x=0; x<length-2; x++) {
      for(int y=x+1; y<length-1; y++) {
        for(int z=y+1; z<length; z++) {

          // 합계 계산
          sum = nums[x] + nums[y] + nums[z];

          // 소수 검증 결과에 따른 처리
          if (checkPrime(sum)) answer++;

        }
      }
    }
    return answer;
  }
  
  // 소수 검증
  public boolean checkPrime(int sum) {
    for (int i=2; i<sum; i++) {
      if (sum%i == 0) return false;
    }
    return true;
  }
}