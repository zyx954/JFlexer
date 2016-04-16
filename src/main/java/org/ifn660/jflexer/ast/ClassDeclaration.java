package org.ifn660.jflexer.ast;

public class ClassDeclaration extends Node {
	private String name;
	private String modifier;
	private ClassBody classBod;
	
	public ClassDeclaration (String name, String modifier, ClassBody classBod) {
		this.name = name;
		this.modifier = modifier;
		this.classBod = classBod;
	}
}
