package projectcoding.expression.classes.constant;

import projectcoding.expression.classes.Expression;

public class Constant extends Expression {
    
    public Constant(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("%d", this.value);
    }
}
