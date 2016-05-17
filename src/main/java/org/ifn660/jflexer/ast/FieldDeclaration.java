package org.ifn660.jflexer.ast;

import java.util.List;

public class FieldDeclaration extends Node implements Declaration {
    private List<String>  fieldmodifier;
    private Type type;
    private IdentifierNode identifiernode;
    private VariableInitializer varInit;
    
    private int cilLocalVarIndex;
    
    public FieldDeclaration( List<String> fieldmodifier, Type type,IdentifierNode identifiernode, VariableInitializer varInit) 
    {
        this.fieldmodifier = fieldmodifier;
        this.type = type;
        this.identifiernode = identifiernode;
        this.varInit = varInit;
        
        this.cilLocalVarIndex = INDEX_COUNT++;
    }

	@Override
	public String getName() {
		return identifiernode.value;
	}
	
	@Override
    public void resolveNames(LexicalScope scope) {
        type.resolveNames(scope);
    }

    @Override
    public int getCilLocalVarIndex() {
        return cilLocalVarIndex;
    }
}
