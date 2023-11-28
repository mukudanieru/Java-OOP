package projectcoding.expression.classes.unaryoperation.negation;

import projectcoding.expression.classes.Expression;
import projectcoding.expression.classes.unaryoperation.UnaryOperation;

public class Negation extends UnaryOperation {

    public Negation(Expression operand) {
        super(operand);
    }

    @Override
    public Integer getValue() {
        return (this.operand.getValue() == null) ? null : -1 * this.operand.getValue();
    }

    @Override
    public String toString() {
        if (this.operand.getValue() == null) {
            return String.format("-%s", this.operand.toString());
        }

        return String.format("%d", this.getValue());
    }
}
