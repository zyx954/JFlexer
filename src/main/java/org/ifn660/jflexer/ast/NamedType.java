package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class NamedType extends Type {
	private String nametype;

	public NamedType(String nametype) {
		this.nametype = nametype;
	}
	
	public String getNameType() {
		
		return nametype;
	}
	
	@Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        StringBuilder msg = new StringBuilder(CIL.ONE_IDENT);
        msg.append(nametype+"32");
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
    }
}