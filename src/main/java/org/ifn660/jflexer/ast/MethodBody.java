package org.ifn660.jflexer.ast;

public class MethodBody extends Node {
	private LocalVariableDeclarationStatement localVarDec;
	
	public MethodBody(LocalVariableDeclarationStatement localVarDec) {
		this.localVarDec = localVarDec;
	}
}
