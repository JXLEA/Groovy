package calculator

import spock.lang.Specification

class CalculatorTest extends Specification {

    def "simple parametrized calculation test"() {
        given:"Calculator implementation"
            def calc = new CalcImpl();
        expect:"method calc()"
            calc.calculate(expresion) == result
        where:
            expresion | result
                "3+5" | "8"
              "3+5*2" | "13"
              "3*2+5" | "11"
              "6/2+1" | "4"
              "6+2/2" | "7"
              "6-4/2" | "4"
    }

    def "pa parametrized calculation test with brackets"() {
        given:"Calculator implementation"
            def calc = new CalcImpl();
        expect:"method calc()"
            calc.calculate(expresion) == result
        where:
            expresion | result
            "(2*(2+2))" | "8"
            "(2*(2+2)-2)" | "6"
            "((2*(2+2)-2)-2)" | "4"
            "((2*(2+2)-2)-2)/4" | "1"
    }
}
