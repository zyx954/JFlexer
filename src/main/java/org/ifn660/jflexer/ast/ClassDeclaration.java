package org.ifn660.jflexer.ast;

import java.util.List;

public class ClassDeclaration extends Node {
	private String name;
	private List<String> modifiers;
	private ClassBody classBody;
	
	public ClassDeclaration (String name, List<String> modifiers, ClassBody classBody) {
		this.name = name;
		this.modifiers = modifiers;
		this.classBody = classBody;
	}
	
	// TODO this is for testing only
	public ClassDeclaration(String test) {
		this.name = test;
	}
}
