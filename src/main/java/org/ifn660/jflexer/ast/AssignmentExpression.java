package org.ifn660.jflexer.ast;

public class AssignmentExpression extends Expression {
    private Expression lhs;
    private Expression rhs;
    
    public AssignmentExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

}
