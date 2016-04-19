package org.ifn660.jflexer.ast;

public class Parameter extends Node{
    private Type type;
    private String name;
	
    public Parameter(Type type, String name) {
		this.type = type;
		this.name = name;
	}
    
    
    
}
