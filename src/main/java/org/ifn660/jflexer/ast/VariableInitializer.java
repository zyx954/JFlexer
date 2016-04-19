package org.ifn660.jflexer.ast;

public class VariableInitializer extends Node {
	private Expression rhs;
	
	public VariableInitializer(Expression rhs) {
		this.rhs = rhs;
	}
}
