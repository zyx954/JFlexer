package org.ifn660.jflexer.ast;

public class VariableDeclaratorId extends Node {
	private String identifier;
	
	public VariableDeclaratorId(String identifier) {
		this.identifier = identifier;
	}
}
