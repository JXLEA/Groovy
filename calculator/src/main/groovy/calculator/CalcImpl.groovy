package calculator

import calculator.chain.OperationsChainBuilder
import calculator.util.OperationUtils

class CalcImpl implements Calculator {

    final static LEFT_PARENTHESIS = "(";
    final static RIGHT_PARENTHESIS = ")";
    final static PARENTHESES = "[\\(\\)]";
    final static EXPRESSION_IN_PARENTHESES = "(\\([^(^)]*\\))";

    OperationsChainBuilder operations;

    CalcImpl() {
        operations = new OperationsChainBuilder()
    }

    @Override
    String calculate(expression) {
        expression = new String(LEFT_PARENTHESIS).concat(expression as String).concat(RIGHT_PARENTHESIS)
        return goDeep(expression)
    }

    String goDeep(expression) {
        while ((expression =~ EXPRESSION_IN_PARENTHESES).find()) {
            String toBeCalc = ((expression =~ EXPRESSION_IN_PARENTHESES)[0][0] as String)
            String result = operations.calculate(toBeCalc.replaceAll(PARENTHESES, OperationUtils.EMPTY));
            expression = expression.replace(toBeCalc, result)
        }
        return expression
    }
}
