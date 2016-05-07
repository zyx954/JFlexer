package org.ifn660.jflexer.ast;

public class ExpressionStatement extends Statement {
    private Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        expression.resolveNames(scope);
    }
}
