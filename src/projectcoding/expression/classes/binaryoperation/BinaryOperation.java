package projectcoding.expression.classes.binaryoperation;

import projectcoding.expression.classes.Expression;

public abstract class BinaryOperation extends Expression {
    protected Expression leftOperand;
    protected Expression rightOperand;

    protected BinaryOperation(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public final Expression getLeftOperand() {
        return leftOperand;
    }

    public final Expression getRightOperand() {
        return rightOperand;
    }
}
