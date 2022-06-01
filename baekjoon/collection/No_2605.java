package baekjoon.collection;

import java.util.*;

public class No_2605 {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    // 자료구조 -> ArrayList로 선택
    ArrayList<Integer> list = new ArrayList<>();

    // 학생 수
    int studentCount = sc.nextInt();

    if (studentCount > 100) {
      throw new Exception("학생 수를 초과했습니다.");
    }

    // 첫번째 학생은 무조건 첫번째 순번으로 시작
    int firstStudentNumber = sc.nextInt();

    if (firstStudentNumber != 0) {
      throw new Exception("첫번째 번호가 0이 아닙니다.");
    }

    list.add(firstStudentNumber, 1);

    // 두번째 ~ N번째 학생까지 순번 결정
    int nextStudentNumber;

    for (int student = 2; student <= studentCount; student++) {

      try {
        nextStudentNumber = sc.nextInt();
      } catch (InputMismatchException e) {
        throw new InputMismatchException("자연수가 아닙니다.");
      }

      list.add(list.size() - nextStudentNumber, student);
    }

    // 결과 순번 출력
    list.forEach(
        (student) -> System.out.print(student + " ")
    );
  }
}