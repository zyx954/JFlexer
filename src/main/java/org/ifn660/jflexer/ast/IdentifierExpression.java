package org.ifn660.jflexer.ast;

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
}
