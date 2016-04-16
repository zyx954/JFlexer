package org.ifn660.jflexer.ast;

public class MethodDeclaration extends Node {
	private String modifier;
	private String result;
	private String name;
	private LocalVariableDeclarationStatement localVarDec;
	
	public MethodDeclaration (String modifier, String result, String name, LocalVariableDeclarationStatement localVarDec) {
		this.modifier = modifier;
		this.result = result;
		this.name = name;
		this.localVarDec = localVarDec;
	}
}
