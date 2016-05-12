package org.ifn660.jflexer.ast;

public class IfThenStatement extends Statement {
    private Expression ifExpression;
    private Statement ifStatement;
    
    private LexicalScope scope;
    
    public IfThenStatement(Expression ifExpression, Statement ifStatement) {
        this.ifExpression = ifExpression;
        this.ifStatement = ifStatement;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        ifExpression.resolveNames(scope);
        ifStatement.resolveNames(scope);
    }
}
