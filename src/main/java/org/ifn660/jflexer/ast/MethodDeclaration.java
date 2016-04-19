package org.ifn660.jflexer.ast;

import java.util.List;

public class MethodDeclaration extends Node {
	private List<String> modifiers;
	private Result result;
	private String name;
	private List<Parameter> parameters;
	private MethodBody methodBod;
	
	public MethodDeclaration (List<String> modifiers, Result result, String name, List<Parameter> parameters, MethodBody methodBod) {
		this.modifiers = modifiers;
		this.result = result;
		this.name = name;
		this.parameters = parameters;
		this.methodBod = methodBod;
	}
}
