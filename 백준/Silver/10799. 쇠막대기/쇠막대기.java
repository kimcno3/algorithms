import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    
    LinkedList<String> list = new LinkedList<>();
    int result = 0;
    // 문자열을 하나씩 분리
    String[] arr = sc.next().split("");
    // 첫번째 문자열
    String firstStr = arr[0];
    // 첫번째 문자열이 '(' 로 시작하지 않을 경우
    if (!firstStr.equals("(")) {
      throw new Exception("첫번째 문자열이 적합하지 않습니다.");
    }
    // 첫번째 문자열 push
    list.push(arr[0]);
    // 두번째 ~ N번째 문자열 Loop
    for (int i=1; i<arr.length; i++) {
      // 이전 문자열
      String preStr = arr[i-1];
      // 현재 문자열
      String currentStr = arr[i];
      // 막대기 추가
      if (list.size() == 0 || currentStr.equals("(")) {
        list.push(currentStr);
      }
      // 막대기가 끝이거나 레이저일 경우
      if (currentStr.equals(")")) {
        list.pop();
        // 레이저일 경우 -> 현제 리스트 길이(막대기 개수)만큼 plus
        if (preStr.equals("(")) result += list.size();
        // 막대기가 마지막일 경우 -> plus 1
        else result += 1;
      }
    }
    System.out.println(result);
  }
}
