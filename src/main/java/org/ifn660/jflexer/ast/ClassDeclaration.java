package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.ifn660.jflexer.cil.CILOption;

public class ClassDeclaration extends Node {
    private IdentifierNode classname;
    private List<String> modifiers;
    private ClassBody classBody;

    public ClassDeclaration(IdentifierNode name, List<String> modifiers, ClassBody classBody) {
        this.classname = name;
        this.modifiers = modifiers;
        this.classBody = classBody;
    }

    @Override
    public void resolveNames(LexicalScope scope) {
        classBody.resolveNames(scope);
    }

    @Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        StringBuilder msg = new StringBuilder();
        msg.append(".assembly extern mscorlib{}\r\n");
        msg.append(".assembly " + classname.value + "{}\r\n");
        msg.append(".class ");
        iterateModifiers(msg, this.modifiers);
        msg.append(" " + classname.value + "." + classname.value + " extends [mscorlib]System.object\r\n");
        msg.append("{\r\n");
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.CREATE);

        classBody.codeGeneration(path, cilOption);

        msg = new StringBuilder();
        msg.append("}\r\n");
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
    }

}
