package org.ifn660.jflexer.ast;

import java.util.List;

public class ClassBody extends Node {
	private List<Declaration> declarations;
	
	public ClassBody(List<Declaration> methodDec) {
		this.declarations = methodDec;
	}
	
	public void resolveNames(LexicalScope scope) {
	    // TODO field declaration needs to be resolve here in the future
		for (Declaration declaration : declarations) {
			Node node = (Node) declaration;
			node.resolveNames(scope);
		}
	}
}
