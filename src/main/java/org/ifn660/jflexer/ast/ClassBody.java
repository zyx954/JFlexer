package org.ifn660.jflexer.ast;

public class ClassBody extends Node {
	private MethodDeclaration methodDec;
	
	public ClassBody(MethodDeclaration methodDec) {
		this.methodDec = methodDec;
	}
}
