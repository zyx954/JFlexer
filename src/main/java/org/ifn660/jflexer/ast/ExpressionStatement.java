package org.ifn660.jflexer.ast;

public class ExpressionStatement extends Statement {
    private Expression expr;
    
    public ExpressionStatement(Expression expr) {
        this.expr = expr;
    }
    
}
