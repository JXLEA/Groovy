package calculator.chain.operation

import static calculator.util.OperationUtils.getOperand

class AddOperation extends Operation {

    final static PLUS = "+"
    final static REG_FIRST_OP = "(\\d+\\+)";
    final static REG_SECOND_OP = "(\\+\\d+)";

    @Override
    String doOperation(String expression) {
        while (expression.contains(PLUS)) {
            int firstOp = getOperand(expression, REG_FIRST_OP, PLUS)
            int secondOp = getOperand(expression, REG_SECOND_OP, PLUS)
            String replacement = "${firstOp}".concat(PLUS).concat("${secondOp}")
            String result = (firstOp + secondOp) as String
            expression = expression.replace(replacement, result)
        }
        return checkNext(expression);
    }
}
