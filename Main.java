import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
		    Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        int studentCount = sc.nextInt();

//        if (studentCount > 100) {
//            throw new Exception("학생 수를 초과했습니다.");
//        }

        int firstStudentNumber = sc.nextInt();

//        if (firstStudentNumber != 0) {
//            throw new Exception("첫번째 번호가 0이 아닙니다.");
//        }

        list.add(firstStudentNumber, 1);

        int nextStudentNumber;

        for (int student = 2; student <= studentCount; student++) {
            nextStudentNumber = sc.nextInt();
//            try {
//                nextStudentNumber = sc.nextInt();
//            } catch (InputMismatchException e) {
//                throw new InputMismatchException("자연수가 아닙니다.");
//            }
            list.add(list.size() - nextStudentNumber, student);
        }

        list.forEach(
            (student) -> System.out.print(student + " ")
        );
    }
}