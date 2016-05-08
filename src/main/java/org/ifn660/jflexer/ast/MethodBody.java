package org.ifn660.jflexer.ast;

import java.util.List;

public class MethodBody extends Node {
	private List <Statement> statements;
	
	private LexicalScope scope;
	
	public MethodBody(List <Statement> localVarDec) {
		this.statements = localVarDec;
		this.scope = new LexicalScope();
	}
	
	@Override
	public void resolveNames(LexicalScope scope) {
	    // the scope from whom invoked this method is the parent scope
	    this.scope.parentScope = scope;
	    
	    // add all declaration statement to the symbol table of method scope
	    for(Statement statement : statements) {
	        // check if this is the statement belongs to declaration type
	        // currently there are only two candidiates : 
	        // LocalVariableDeclarationStatement and FieldDeclaration
	        if (statement instanceof Declaration) {//zyx: The instanceof keyword can be used to test if an object is of a specified type.
	            Declaration declaration = (Declaration) statement;
	            // if this is true, then record that declaration in the symbol table
	            this.scope.symbolTable.put(declaration.getName(), declaration);
	        }
	    }
	    
	    for(Statement statement : statements) {
	        statement.resolveNames(this.scope);
	    }
	}
}
