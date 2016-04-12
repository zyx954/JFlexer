package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Statement {
    private String type; // TODO need to switch to Enum Type later??
    
    private IdentifierExpression name;
    
    private Expression rhs;
    
    public LocalVariableDeclarationStatement(String type, IdentifierExpression name, Expression rhs) {
        this.type = type;
        this.name = name;
        this.rhs = rhs;
    }
}
