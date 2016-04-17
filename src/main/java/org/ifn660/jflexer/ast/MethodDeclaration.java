package org.ifn660.jflexer.ast;

import java.util.List;

public class MethodDeclaration extends Node {
	private List modifiers;
	private String result;
	private String name;
	private List parameters;
	private MethodBody methodBod;
	
	public MethodDeclaration (List modifiers, String result, String name, List parameters, MethodBody methodBod) {
		this.modifiers = modifiers;
		this.result = result;
		this.name = name;
		this.parameters = parameters;
		this.methodBod = methodBod;
	}
}
