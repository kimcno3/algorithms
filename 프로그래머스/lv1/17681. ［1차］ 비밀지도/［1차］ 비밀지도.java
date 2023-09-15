class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i=0; i<n; i++) {
      String resultLine = "";

      String line1 = Integer.toBinaryString(arr1[i]);
      String line2 = Integer.toBinaryString(arr2[i]);

      while(line1.length() < n) {
        line1 = "0" + line1;
      }

      while(line2.length() < n) {
        line2 = "0" + line2;
      }

      String[] splitLine1 = line1.split("");
      String[] splitLine2 = line2.split("");

      for (int j=0; j<n; j++) {
        if (splitLine1[j].equals("1") || splitLine2[j].equals("1")) {
          resultLine += "#";
        } else if (splitLine1[j].equals("0") && splitLine2[j].equals("0")) {
          resultLine += " ";
        }
      }

      answer[i] = resultLine;

    }
    
    return answer;
  }
}