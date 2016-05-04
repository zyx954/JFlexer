package org.ifn660.jflexer.ast;

public class RelationalExpression extends Expression{
    private Expression lhs;
    private RelationalOperator relationalOperator;
    private Expression rhs;
    public RelationalExpression(Expression lhs,
            RelationalOperator relationalOperator, Expression rhs) {
        this.lhs = lhs;
        this.relationalOperator = relationalOperator;
        this.rhs = rhs;
    }
}
