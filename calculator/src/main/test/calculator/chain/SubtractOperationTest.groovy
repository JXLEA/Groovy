package calculator.chain

import calculator.chain.operation.SubtractOperation
import spock.lang.Specification

class SubtractOperationTest extends Specification {

    def "parametrize test for subtract operation"() {
        given: "Subtract operation chunk in operation chain"
            def operation = new SubtractOperation();
        expect:
            result == operation.doOperation(expression)
        where:
            expression | result
                "11-3*2"| "8*2"
                  "3-2" | "1"
              "5+3*3-3" | "5+3*0"
    }
}
