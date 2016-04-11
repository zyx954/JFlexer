package org.ifn660.jflexer.ast;

public class IntegerLiteralExpression extends Expression {
    private int value;
    
    public IntegerLiteralExpression(int value) {
        this.value = value;
    }

    @Override
    public void printNode() {
        System.out.println(value);
        
    }
}
