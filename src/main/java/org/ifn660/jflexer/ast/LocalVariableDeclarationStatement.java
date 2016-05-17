package org.ifn660.jflexer.ast;

public class LocalVariableDeclarationStatement extends Statement implements Declaration {
	private Type type;
	private IdentifierNode identifiernode;
    private VariableInitializer varInit;
    
    int cilLocalVarIndex;
    
    public LocalVariableDeclarationStatement(Type type, IdentifierNode identifiernode, VariableInitializer varInit) {
        this.identifiernode = identifiernode;
        this.varInit = varInit;
        this.type = type;
        
        this.cilLocalVarIndex = INDEX_COUNT++; 
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        type.resolveNames(scope);
    }

    @Override
    public String getName() {
        return identifiernode.value;
    }
    
    @Override
    public int getCilLocalVarIndex() {
        return this.cilLocalVarIndex;
    }
}
