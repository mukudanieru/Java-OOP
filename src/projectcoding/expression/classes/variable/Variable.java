package projectcoding.expression.classes.variable;

import projectcoding.expression.classes.Expression;

public class Variable extends Expression {
    private final String name;

    public Variable(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Variable(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
