package projectcoding.expression.classes.unaryoperation;

import projectcoding.expression.classes.Expression;

public abstract class UnaryOperation extends Expression {
    protected Expression operand;

    protected UnaryOperation(Expression operand) {
        this.operand = operand;
    }

    public final Expression getOperand() {
        return operand;
    }
}
