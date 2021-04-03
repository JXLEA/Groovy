package calculator.util

class OperationUtils {

    public final static String EMPTY = "";

    static def getOperand(expression, regex, operation) {
        return ((expression =~ regex)[0][0] as String).replace(operation, EMPTY) as Integer
    }
}
