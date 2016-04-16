package org.ifn660.jflexer.ast;

public class ASTDriver {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    	Expression expression = new Expression(42);
    	VariableInitializer varInit = new VariableInitializer("=", expression);
    	VariableDeclaratorId varDecId = new VariableDeclaratorId("x");
    	LocalVariableDeclarationStatement localVarDec = new LocalVariableDeclarationStatement(varDecId, varInit);
    	MethodDeclaration methodDec = new MethodDeclaration("public", "void", "main", localVarDec);
        
        Node root = new ClassDeclaration("Example", "public", methodDec);
        root.printNodeReflection(0);
    }
}
