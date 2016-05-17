package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class MethodDeclaration extends Node implements Declaration {
    private List<String> modifiers;
    private Result result;
    private IdentifierNode methodname;
    private List<Parameter> parameters;
    private MethodBody methodBody;

    public MethodDeclaration(List<String> modifiers, Result result, IdentifierNode name, List<Parameter> parameters,
            MethodBody methodBody) {
        this.modifiers = modifiers;
        this.result = result;
        this.methodname = name;
        this.parameters = parameters;
        this.methodBody = methodBody;
    }

    @Override
    public void resolveNames(LexicalScope scope) {
        methodBody.resolveNames(scope);
    }

    @Override
    public String getName() {
        return methodname.value;
    }

    @Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        StringBuilder msg = new StringBuilder(CIL.ONE_IDENT);
        msg.append(".method");
        iterateModifiers(msg, this.modifiers);
        msg.append(" " + result.getNameType() + " " + methodname.value + "(string[] args) \r\n");
        msg.append(CIL.ONE_IDENT);
        msg.append("{\r\n");
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
        
        methodBody.codeGeneration(path, cilOption);
        
        msg = new StringBuilder(CIL.ONE_IDENT);
        msg.append("}\r\n");
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
    }

    @Override
    public int getCilLocalVarIndex() {
        return 0;
    }
}
