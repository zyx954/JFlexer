package org.ifn660.jflexer.ast;

public class ClassDeclaration extends Node {
	private String name;
	private String modifier;
	private MethodDeclaration methodDec;
	
	public ClassDeclaration (String name, String modifier, MethodDeclaration methodDec) {
		this.name = name;
		this.modifier = modifier;
		this.methodDec = methodDec;
	}
}
