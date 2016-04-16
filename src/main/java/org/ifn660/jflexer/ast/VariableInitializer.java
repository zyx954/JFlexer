package org.ifn660.jflexer.ast;

public class VariableInitializer extends Node {
	private String operator;
	private Expression rhs;
	
	public VariableInitializer(String operator, Expression rhs) {
		this.operator = operator;
		this.rhs = rhs;
	}
}
