package org.ifn660.jflexer.ast;

import java.util.List;

public class MethodBody extends Node {
	private List <Statement> statements;
	
	public MethodBody(List <Statement> localVarDec) {
		this.statements = localVarDec;
	}
}
