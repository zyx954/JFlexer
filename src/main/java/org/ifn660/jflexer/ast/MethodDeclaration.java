package org.ifn660.jflexer.ast;

public class MethodDeclaration extends Node {
	private String modifier;
	private String result;
	private String name;
	private String parameter;
	private MethodBody methodBod;
	
	public MethodDeclaration (String modifier, String result, String name, MethodBody methodBod) {
		this.modifier = modifier;
		this.result = result;
		this.name = name;
		this.methodBod = methodBod;
	}
}
