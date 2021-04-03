package calculator.chain.operation

import static calculator.util.OperationUtils.getOperand

class SubtractOperation extends Operation {

    final static MINUS = "-"
    final static REG_FIRST_OP = "(\\d+\\-)";
    final static REG_SECOND_OP = "(\\-\\d+)";

    @Override
    String doOperation(String expression) {
        while (expression.contains(MINUS)) {
            int firstOp = getOperand(expression, REG_FIRST_OP, MINUS)
            int secondOp = getOperand(expression, REG_SECOND_OP, MINUS)
            String replacement = "${firstOp}".concat(MINUS).concat("${secondOp}")
            String result = (firstOp - secondOp) as String
            expression = expression.replace(replacement, result)
        }
        return checkNext(expression);
    }
}
