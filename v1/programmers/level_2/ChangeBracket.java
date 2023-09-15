package v1.programmers.level_2;


// 괄호 변환 : https://school.programmers.co.kr/learn/courses/30/lessons/60058
public class ChangeBracket {


  public static void main(String[] args) {
    ChangeBracket changeBracket = new ChangeBracket();
    System.out.println(changeBracket.solution("(()())()"));
    System.out.println(changeBracket.solution(")("));
    System.out.println(changeBracket.solution("()))((()"));
    System.out.println(changeBracket.solution("())()("));
  }

  public static StringBuilder sb;

  public String solution(String p) {
    sb = new StringBuilder();
    method(p);
    return sb.toString();
  }

  public void method(String p) {

    // p가 빈 문자열일 경우 -> 더 이상 재귀를 돌 필요가 없다.
    if (p.equals("")) {
      return;
    }

    int open = 0;
    int close = 0;

    String u = "";
    String v = "";

    // u, v로 구분
    for(int i=0; i<p.length(); i++) {

      if (p.charAt(i) == '(') {
        open++;
      } else {
        close++;
      }

      if (open == close) {
        u = p.substring(0, i+1);
        v = p.substring(i+1);
        break;
      }

    }

    // u가 올바른 문자열일 경우
    if(u.charAt(0) == '(' && u.charAt(u.length()-1) == ')') {
      sb.append(u);
      method(v);
    }

    // u가 올바른 문자열이 아닌경우
    else {
      // 괄호 시작
      sb.append("(");

      // v를 가지고 재귀 실행
      method(v);

      // 괄호 닫기
      sb.append(")");

      // u에 대한 앞,뒤 괄호 제거
      u = u.subSequence(1, u.length()-1).toString();

      // 괄호 방향 변경
      String tempU = "";
      for (int i=0; i<u.length(); i++) {
        if (u.charAt(i) == '(') tempU += ")";
        else tempU += "(";
      }

      u = tempU;

      sb.append(u);
    }

  }

}
