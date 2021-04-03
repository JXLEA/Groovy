package calculator.chain

import calculator.chain.operation.AddOperation
import spock.lang.Specification

class AddOperationTest extends Specification {

    def "parametrize test for add operation"() {
        given: "Add operation chunk in operation chain"
            def operation = new AddOperation();
        expect:
            result == operation.doOperation(expression)
        where:
            expression | result
              "5+3*2" | "8*2"
                "3+2" | "5"
            "5+3*2-3" | "8*2-3"
    }
}
