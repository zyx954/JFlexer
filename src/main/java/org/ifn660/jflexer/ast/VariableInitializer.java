package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Path;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class VariableInitializer extends Node {
	private Expression rhs;
	
	public VariableInitializer(Expression rhs) {
		this.rhs = rhs;
	}
	@Override
	public void codeGeneration(Path path, CILOption cilOption)throws IOException {
		rhs.codeGeneration(path, cilOption);
	}
}
