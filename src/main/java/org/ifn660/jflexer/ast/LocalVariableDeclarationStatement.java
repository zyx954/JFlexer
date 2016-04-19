package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Node {
    private VariableDeclaratorId varDecId;
    private VariableInitializer varInit;
    private Type type;
    
    public LocalVariableDeclarationStatement(Type type, VariableDeclaratorId varDecId, VariableInitializer varInit) {
        this.varDecId = varDecId;
        this.varInit = varInit;
        this.type = type;
    }
}
