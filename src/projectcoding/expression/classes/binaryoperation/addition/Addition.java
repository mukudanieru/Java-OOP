package projectcoding.expression.classes.binaryoperation.addition;

import projectcoding.expression.classes.Expression;
import projectcoding.expression.classes.binaryoperation.BinaryOperation;

public class Addition extends BinaryOperation {
    public Addition(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Integer getValue() {
        if ((this.leftOperand.getValue() == null || this.rightOperand.getValue() == null)) {
            return null;
        }

        return this.leftOperand.getValue() + this.rightOperand.getValue();
    }

    @Override
    public String toString() {
        return String.format("(%s+%s)", this.leftOperand.toString(), this.rightOperand.toString());
    }
}
