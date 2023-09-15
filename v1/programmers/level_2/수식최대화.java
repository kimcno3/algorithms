package v1.programmers.level_2;

import java.util.*;
import java.util.stream.Collectors;

public class 수식최대화 {

    private static final String[][] STRINGS = new String[][]{
            "*+-".split(""),
            "*-+".split(""),
            "+*-".split(""),
            "+-*".split(""),
            "-*+".split(""),
            "-+*".split("")
    };

    // StringTokenizer를 사용하면 연산자와 피연산자를 하나의 리스트에 추가해 사용이 가능하다.
    public long solutionWithTokenizer(String expression) {
        long answer = 0;
        for (String[] ops : STRINGS) {
            List<String> list = new ArrayList<>();
            // list에 연산자와 피연산자를 구분한 형태로 저장
            StringTokenizer st = new StringTokenizer(expression, "*+-", true);
            while(st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            // 루프 진행
            for (String op : ops) {
                while(list.contains(op)) {
                    int idx = list.indexOf(op);
                    long result = calc(op, Long.parseLong(list.get(idx-1)), Long.parseLong(list.get(idx+1)));
                    list.remove(idx - 1);
                    list.remove(idx - 1);
                    list.remove(idx - 1);
                    list.add(idx - 1, String.valueOf(result));
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(list.get(0))));
        }
        return answer;
    }

    // split()을 사용하게 되면 분리를 위해 사용되는 값은 제외가 되기 때문에 연산자, 피연산자 리스트를 구분해서 설정해야 한다.
    public long solution(String expression) {
        long answer = 0;

        List<String> NUMBERS = Arrays.asList(expression.split("[*+-]"));
        List<String> OPS = Arrays.stream(expression.split("[0-9]"))
                .filter((op) -> !op.equals(""))
                .collect(Collectors.toList());

        for (String[] string : STRINGS) {
            List<String> tempNUMBERS = new ArrayList<>(NUMBERS);
            List<String> tempOPS = new ArrayList<>(OPS);

            for (String currentOp : string) {
                // 동일한 연산자가 있는 경우에만
                while(tempOPS.contains(currentOp)) {
                    // 현재 연산자와 동일한 연산자 위치를 찾는다.
                    int idx = tempOPS.indexOf(currentOp);
                    // 연산자 앞뒤 값을 계산 (idx 랑 idx+1 이지만 앞에 값을 제거하면 인덱스가 하나씩 땡겨지므로 idx 값으로 두번 조회)
                    long result = calc(currentOp, Long.parseLong(tempNUMBERS.remove(idx)), Long.parseLong(tempNUMBERS.remove(idx)));
                    // 계산한 값을 새로 저장
                    tempNUMBERS.add(idx, String.valueOf(result));
                    // 연산자랑 기존 값은 삭제
                    tempOPS.remove(idx);
                }
            }

            answer = Math.max(answer, Math.abs(Long.parseLong(tempNUMBERS.get(0))));
        }

        return answer;
    }

    private long calc(String op, long num1, long num2) {
        long result = 0;
        switch (op) {
            case "*" :
                result = num1 * num2;
                break;
            case "+" :
                result = num1 + num2;
                break;
            case "-" :
                result = num1 - num2;
                break;
        }
        return result;
    }
}
