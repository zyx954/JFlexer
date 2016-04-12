package org.ifn660.jflexer.ast;

public class ASTDriver {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Expression assignmentExpression = new AssignmentExpression(new IdentifierExpression("x"), new IntegerLiteralExpression(42));
        
        //Statement expressionStatement = new ExpressionStatement(assignmentExpression);
        
        Node root = new LocalVariableDeclarationStatement("int", new IdentifierExpression("x"), assignmentExpression);
        
        //root.printNode();
        root.printNodeReflection(0);
    }
}
