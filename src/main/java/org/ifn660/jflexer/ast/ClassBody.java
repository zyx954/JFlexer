package org.ifn660.jflexer.ast;

public class ClassBody extends Node {
	private Declaration methodDec;
	
	public ClassBody(Declaration methodDec) {
		this.methodDec = methodDec;
	}
}
