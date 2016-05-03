package org.ifn660.jflexer.ast;

public class IdentifierExpression extends Expression {
    private IdentifierNode identifier;
    
    public IdentifierExpression(IdentifierNode identifierNode) {
        this.identifier = identifierNode;
    }
}
