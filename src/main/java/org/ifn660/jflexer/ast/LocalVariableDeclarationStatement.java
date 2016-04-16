package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Node {
    private VariableDeclaratorId varDecId;
    private VariableInitializer varInit;
    
    public LocalVariableDeclarationStatement(VariableDeclaratorId varDecId, VariableInitializer varInit) {
        this.varDecId = varDecId;
        this.varInit = varInit;
    }
}
