package org.ifn660.jflexer.ast;

public class ClassBody extends Node {
	private MethodDeclaration methodDec;
	
	public ClassBody(MethodDeclaration methodDec) {
		this.methodDec = methodDec;
	}
	
	public void resolveNames(LexicalScope scope) {
	    // TODO field declaration needs to be resolve here in the future
	    methodDec.resolveNames(scope);
	}
}
