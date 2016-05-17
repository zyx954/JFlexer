package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MethodDeclaration extends Node implements Declaration {
	private List<String> modifiers;
	private Result result;
	private IdentifierNode methodname;
	private List<Parameter> parameters;
	private MethodBody methodBod;
	
	public MethodDeclaration (List<String> modifiers, Result result, IdentifierNode name, List<Parameter> parameters, MethodBody methodBod) {
		this.modifiers = modifiers;
		this.result = result;
		this.methodname = name;
		this.parameters = parameters;
		this.methodBod = methodBod;
	}
	
	@Override
	public void resolveNames(LexicalScope scope) {
	    methodBod.resolveNames(scope);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return methodname.value;
	}
	
	@Override
	public void codeGeneration (Path path) throws IOException {
		StringBuilder msg = new StringBuilder();
		msg.append(".method");
		iterateModifiers(msg, this.modifiers);
		msg.append(" " +result.getNameType()+ " " +methodname.value+ "(string[] args) \r\n");
		msg.append("{\r\n");
		
		Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
	}
	
	//.method private static void  Main(string[] args)
}
