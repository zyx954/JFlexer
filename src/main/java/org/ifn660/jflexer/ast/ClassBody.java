package org.ifn660.jflexer.ast;

import java.util.List;

public class ClassBody extends Node {
	private List<Declaration> declarations;
	
	private LexicalScope scope;
	
	public ClassBody(List<Declaration> methodDec) {
		this.declarations = methodDec;
		this.scope = new LexicalScope();
	}
	
	@Override
    public void resolveNames(LexicalScope scope) {
        // the scope from whom invoked this method is the parent scope
        this.scope.parentScope = scope;
        
        // add all declaration statement to the symbol table of method scope
        for(Declaration declaration : declarations) {
            this.scope.symbolTable.put(declaration.getName(), declaration);
        }
        
        for (Declaration declaration : declarations) {
            Node node = (Node) declaration;
            node.resolveNames(this.scope);
        }
    }
}
