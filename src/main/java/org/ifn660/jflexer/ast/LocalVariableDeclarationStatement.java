package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Node {
    private Type type;//zyx : here the sequence will affect the print sequence.when use relect
    private VariableDeclaratorId varDecId;
    private VariableInitializer varInit;
    
    public LocalVariableDeclarationStatement(Type type, VariableDeclaratorId varDecId, VariableInitializer varInit) {
        this.varDecId = varDecId;
        this.varInit = varInit;
        this.type = type;
    }
}
