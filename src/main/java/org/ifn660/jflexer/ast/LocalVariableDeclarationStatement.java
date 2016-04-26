package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Statement {
	private Type type;
	private IdentifierNode identifiernode;
    private VariableInitializer varInit;
    
    public LocalVariableDeclarationStatement(Type type, IdentifierNode identifiernode, VariableInitializer varInit) {
        this.identifiernode = identifiernode;
        this.varInit = varInit;
        this.type = type;
    }
}
