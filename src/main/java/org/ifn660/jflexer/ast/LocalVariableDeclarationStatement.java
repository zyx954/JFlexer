package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Node {
    private Type type;
    private VariableDeclaratorId varDecId;
    private VariableInitializer varInit;
    //zyx : here the order will effect the print order 
    
    public LocalVariableDeclarationStatement(Type type, VariableDeclaratorId varDecId, VariableInitializer varInit) {
        this.varDecId = varDecId;
        this.varInit = varInit;
        this.type = type;
    }
//    public LocalVariableDeclarationStatement(Type type,  VariableInitializer varInit) {
//        this.type = type;
//        this.varInit = varInit;
//    }
    }
