package calculator.chain

import calculator.chain.operation.MultiplyOperation
import spock.lang.Specification

class MultiplyOperationTest extends Specification {

    def "parametrize test for multiply operation"() {
        given: "Multiply operation chunk in operation chain"
            def operation = new MultiplyOperation();
        expect:
            result == operation.doOperation(expression)
        where:
            expression | result
               "5+3*2" | "5+6"
                 "3*2" | "6"
             "5+3*2-3" | "5+6-3"
    }
}
