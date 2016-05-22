package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class LocalVariableDeclarationStatement extends Statement implements Declaration {
	private Type type;
	private IdentifierNode identifiernode;
    private VariableInitializer varInit;
    
    int cilLocalVarIndex;
    
    public LocalVariableDeclarationStatement(Type type, IdentifierNode identifiernode, VariableInitializer varInit) {
        this.identifiernode = identifiernode;
        this.varInit = varInit;
        this.type = type;
        
        this.cilLocalVarIndex = INDEX_COUNT++; 
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        type.resolveNames(scope);
    }

    @Override
    public String getName() {
        return identifiernode.value;
    }
    
    @Override
    public int getCilLocalVarIndex() {
        return this.cilLocalVarIndex;
    }
    
    @Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        StringBuilder msg = new StringBuilder(CIL.ONE_IDENT);
        msg.append("[");
        msg.append(this.getCilLocalVarIndex());
        msg.append("]");
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
        type.codeGeneration(path, cilOption);
        //msg.append("\r\n");
        //Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);

    }
}
