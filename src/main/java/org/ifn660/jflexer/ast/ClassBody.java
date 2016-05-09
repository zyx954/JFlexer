package org.ifn660.jflexer.ast;

import java.util.List;

public class ClassBody extends Node {
	private List<Declaration> declaration;
	
	public ClassBody(List<Declaration> methodDec) {
		this.declaration = methodDec;
	}
}
