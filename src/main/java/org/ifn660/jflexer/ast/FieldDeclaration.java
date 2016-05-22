package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class FieldDeclaration extends Node implements Declaration {
    private List<String>  fieldmodifier;
    private Type type;
    private IdentifierNode identifiernode;
    private VariableInitializer varInit;
    
    private int cilLocalVarIndex;
    
    public FieldDeclaration( List<String> fieldmodifier, Type type,IdentifierNode identifiernode, VariableInitializer varInit) 
    {
        this.fieldmodifier = fieldmodifier;
        this.type = type;
        this.identifiernode = identifiernode;
        this.varInit = varInit;
        
        //this.cilLocalVarIndex = INDEX_COUNT++;
    }

	@Override
	public String getName() {
		return identifiernode.value;
	}
	
	@Override
    public void resolveNames(LexicalScope scope) {
        type.resolveNames(scope);
    }

    @Override
    public int getCilLocalVarIndex() {
        return cilLocalVarIndex;
    }
    
    @Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        StringBuilder msg = new StringBuilder(CIL.ONE_IDENT);
        msg.append(".field");
        iterateModifiers(msg, this.fieldmodifier);
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
        type.codeGeneration(path, cilOption);
        identifiernode.codeGeneration(path, cilOption);
        //msg.append("\r\n");
        
       
    }
    //.field private static int32 z
}
