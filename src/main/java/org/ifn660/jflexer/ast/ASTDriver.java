package org.ifn660.jflexer.ast;

public class ASTDriver {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    	VariableDeclaratorId varDecId = new VariableDeclaratorId("x");
    	Expression expression = new Expression(42);
    	LocalVariableDeclarationStatement localVarDec = new LocalVariableDeclarationStatement(varDecId, expression);
    	MethodDeclaration methodDec = new MethodDeclaration("public", "void", "main", localVarDec);
        
        Node root = new ClassDeclaration("Example", "public", methodDec);
        root.printNodeReflection(0);
    }
}
