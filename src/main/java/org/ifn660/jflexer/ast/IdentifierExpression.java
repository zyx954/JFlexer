package org.ifn660.jflexer.ast;

public class IdentifierExpression extends Expression {
    private String name;
    
    public IdentifierExpression(String name) {
        this.name = name;
    }

}
