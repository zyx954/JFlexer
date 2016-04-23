package org.ifn660.jflexer.ast;

public class VariableInitializer extends Node {
	private Expression rhs;
//	  private VariableDeclaratorId varDecId;
	
	public VariableInitializer(Expression rhs) {
		this.rhs = rhs;
	}
//	public VariableInitializer(VariableDeclaratorId varDecId,Expression rhs) {
//	    this.varDecId = varDecId;
//        this.rhs = rhs;
//    }
}
