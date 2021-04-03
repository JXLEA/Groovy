package calculator.chain.operation

abstract class Operation {

    private Operation next;

    Operation linkWith(Operation next) {
        this.next = next;
        return next;
    }

    abstract String doOperation(String expression);

    protected String checkNext(expression) {
        if (next == null) {
            return expression;
        }
        return next.doOperation(expression);
    }
}
