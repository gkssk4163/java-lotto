package step1.domain;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class StringCalculator {

    public static int calc(String strOperation) {
        validateStringOperation(strOperation);

        Queue<String> operatorSequence = new ArrayDeque<>();
        operatorSequence.addAll(List.of(split(strOperation)));

        Number firstValue = new Number(operatorSequence.poll());
        int cumulativeValue = firstValue.value();
        while (!operatorSequence.isEmpty()) {
            Operator op = new Operator(operatorSequence.poll());
            Number number = new Number(operatorSequence.poll());
            cumulativeValue = doOperation(cumulativeValue, op, number.value());
        }

        return cumulativeValue;
    }

    private static String[] split(String strOperation) {
        return strOperation.split(" ");
    }

    private static int doOperation(int left, Operator op, int right) {
        Calculator calculator = new Calculator();
        if (op.isAdd()) return calculator.add(left, right);
        if (op.isSubtract()) return calculator.subtract(left, right);
        if (op.isMultiply()) return calculator.multiply(left, right);
        if (op.isDivide()) return calculator.divide(left, right);

        throw new IllegalArgumentException();
    }

    private static void validateStringOperation(String strOperation) {
        if (isNullOrEmptyString(strOperation))
            throw new IllegalArgumentException("사칙연산을 입력해주세요.");
    }

    private static boolean isNullOrEmptyString(String strOperation) {
        return strOperation == null || strOperation.isEmpty();
    }
}
