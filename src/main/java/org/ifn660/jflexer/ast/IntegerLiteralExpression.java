package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class IntegerLiteralExpression extends Expression {
	private int value;
	
	public IntegerLiteralExpression(int value) {
		this.value = value;
	}
	
	@Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
	    StringBuilder msg = new StringBuilder(CIL.TWO_IDENT);
        msg.append(CIL.LDC_I4_S + "   " + value + "\r\n");
        
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
	}
}
