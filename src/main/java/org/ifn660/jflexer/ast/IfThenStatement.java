package org.ifn660.jflexer.ast;

public class IfThenStatement extends Statement{
    private Expression ifExpression;
    private Statement ifStatement;
    public IfThenStatement(Expression ifExpression, Statement ifStatement) {
        this.ifExpression = ifExpression;
        this.ifStatement = ifStatement;
    }

}
