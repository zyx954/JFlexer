package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class BinaryExpression extends Expression {
    private Expression leftHandSide;
    private BinaryOperator operator;
    private Expression rightHandSide;
    
    public BinaryExpression(Expression leftHandSide, Expression rightHandSide, BinaryOperator operator) {
        this.leftHandSide = leftHandSide;
        this.operator = operator;
        this.rightHandSide = rightHandSide;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        leftHandSide.resolveNames(scope);
        rightHandSide.resolveNames(scope);
    }
    @Override
    public String passVariables(String variable)  {
        rightHandSide.passVariables(variable);
        return variable;

     }
    
    @Override
    public void codeGeneration(Path path, CILOption cilOption) throws IOException {
        rightHandSide.codeGeneration(path, cilOption);
        leftHandSide.codeGeneration(path, cilOption);
        
        StringBuilder msg = new StringBuilder(CIL.TWO_IDENT);
        String cilOperator = CIL.getBinaryOperator(operator);
        msg.append(cilOperator + "\r\n");
        
        Files.write(path, msg.toString().getBytes(), StandardOpenOption.APPEND);
    }
}
