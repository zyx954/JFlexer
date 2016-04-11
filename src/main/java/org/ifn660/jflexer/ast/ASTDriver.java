package org.ifn660.jflexer.ast;

public class ASTDriver {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Expression assignmentExpression = new AssignmentExpression(new IdentifierExpression("x"), new IntegerLiteralExpression(42));
        
        Statement expressionStatement = new ExpressionStatement(assignmentExpression);
        
        VariableDeclarationStatement root = new VariableDeclarationStatement("int", "x", assignmentExpression);
        
        root.printNode();
    }
}
