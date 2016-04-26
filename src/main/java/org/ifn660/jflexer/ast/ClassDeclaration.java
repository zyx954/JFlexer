package org.ifn660.jflexer.ast;

import java.util.List;

public class ClassDeclaration extends Node {
	private IdentifierNode classname;
	private List<String> modifiers;
	private ClassBody classBody;
	
	public ClassDeclaration (IdentifierNode name, List<String> modifiers, ClassBody classBody) {
		this.classname = name;
		this.modifiers = modifiers;
		this.classBody = classBody;
	}
	
}
