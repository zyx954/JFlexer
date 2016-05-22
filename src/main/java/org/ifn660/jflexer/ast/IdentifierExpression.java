package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class IdentifierExpression extends Expression {
    private IdentifierNode identifier;
    
    private Declaration declaration;
    
    public IdentifierExpression(IdentifierNode identifierNode) {
        this.identifier = identifierNode;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        if (scope != null) {
            declaration = scope.resolve(identifier.value);
        }

        if (declaration == null) {
            System.err.println("Error: Undeclared identifier " + identifier.value);
            throw new RuntimeException("Name Resolution error");
        }
    }
    
    @Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        StringBuilder msg = new StringBuilder(CIL.TWO_IDENT);
        
        if (cilOption == CILOption.LEFT_HAND_SIDE) {
            msg.append(CIL.STLOC + declaration.getCilLocalVarIndex() + "\r\n");
            //msg.append(CIL.TWO_IDENT);
        }
        else 
        {
            //msg.append(CIL.STLOC + declaration.getCilLocalVarIndex() + "\r\n");
          //  msg.append(CIL.TWO_IDENT);
            msg.append(CIL.LDLOC + declaration.getCilLocalVarIndex() + "\r\n");
        }
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
    }
}
