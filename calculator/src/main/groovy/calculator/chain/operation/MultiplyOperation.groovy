package calculator.chain.operation

import static calculator.util.OperationUtils.getOperand

class MultiplyOperation extends Operation {

    final static MULTIPLY = "*"
    final static REG_FIRST_OP = "(\\d+\\*)";
    final static REG_SECOND_OP = "(\\*\\d+)";

    @Override
    String doOperation(String expression) {
        while (expression.contains(MULTIPLY)) {
            int firstOp = getOperand(expression, REG_FIRST_OP, MULTIPLY)
            int secondOp = getOperand(expression, REG_SECOND_OP, MULTIPLY)
            String replacement = "${firstOp}".concat(MULTIPLY).concat("${secondOp}")
            String result = (firstOp * secondOp) as String
            expression = expression.replace(replacement, result)
        }
        return checkNext(expression);
    }
}
