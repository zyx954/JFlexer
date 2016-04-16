package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Node {
    private VariableDeclaratorId varDecId;
    private Expression expression;
    
    public LocalVariableDeclarationStatement(VariableDeclaratorId varDecId, Expression expression) {
        this.varDecId = varDecId;
        this.expression = expression;
    }
}
