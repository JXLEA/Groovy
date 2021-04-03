package calculator.chain.operation

import static calculator.util.OperationUtils.getOperand

class DivisionOperation extends Operation {

    final static DIVISION = "/"
    final static REG_FIRST_OP = "(\\d+\\/)";
    final static REG_SECOND_OP = "(\\/\\d+)";

    @Override
    String doOperation(String expression) {
        while (expression.contains(DIVISION)) {
            int firstOp = getOperand(expression, REG_FIRST_OP, DIVISION)
            int secondOp = getOperand(expression, REG_SECOND_OP, DIVISION)
            String replacement = "${firstOp}".concat(DIVISION).concat("${secondOp}")
            String result = (firstOp / secondOp) as String
            expression = expression.replace(replacement, result)
        }
        return checkNext(expression);
    }
}
