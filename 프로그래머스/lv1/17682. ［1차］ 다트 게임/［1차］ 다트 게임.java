class Solution {
  public int solution(String dartResult) {
    int[] round = new int[3];
    String[] split = dartResult.split("");
    String numStr = "";
    int n;
    int answer = 0;
    int idx = 0;

    for (String str : split) {
      if (str.matches("[0-9]")) {
        numStr += str;
      }

      else if (str.matches("[SDT]")) {
        n = Integer.parseInt(numStr);
        switch (str) {
          case "S" :
            round[idx++] = n;
            break;
          case "D" :
            round[idx++] = n * n;
            break;
          case "T" :
            round[idx++] = n * n * n;
            break;
        }
        numStr = "";
      }
      else {
        switch (str) {
          case "*" :
            round[idx-1] = round[idx-1] * 2;
            if(idx-2>=0) round[idx-2] *= 2;
            break;
          case "#" :
            round[idx-1] = round[idx-1] * (-1);
            break;
        }
      }
    }

    for (int i : round) {
      System.out.println(i);
      answer += i;
    }

    return answer;
  }

}