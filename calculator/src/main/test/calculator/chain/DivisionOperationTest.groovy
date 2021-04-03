package calculator.chain

import calculator.chain.operation.DivisionOperation
import spock.lang.Specification

class DivisionOperationTest extends Specification {

    def "parametrize test for division operation"() {
        given: "Division operation chunk in operations chain"
            def operation = new DivisionOperation();
        expect:
            result == operation.doOperation(expression)
        where:
            expression | result
                "5+4/2" | "5+2"
                  "3/2" | "1.5"
              "5+3/2-3" | "5+1.5-3"
    }
}
