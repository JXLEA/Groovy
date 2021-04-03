package calculator.chain

import calculator.chain.operation.AddOperation
import calculator.chain.operation.DivisionOperation
import calculator.chain.operation.MultiplyOperation
import calculator.chain.operation.Operation
import calculator.chain.operation.SubtractOperation

class OperationsChainBuilder {

    Operation chainOfOperations

    String calculate(expression) {
        chainOfOperations = new MultiplyOperation();
        chainOfOperations.linkWith(new DivisionOperation()).linkWith(new AddOperation()).linkWith(new SubtractOperation())
        return chainOfOperations.doOperation(expression);
    }

}
