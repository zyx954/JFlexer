package org.ifn660.jflexer.ast;

import java.util.ArrayList;
import java.util.List;

public class ASTDriver {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    	ArrayList<String> modifiers = new ArrayList<String>();
    	modifiers.add("public");
    	modifiers.add("static");
    	
    	ArrayList<String> parameters = new ArrayList<String>();
    	parameters.add("args");
    	
    	IntegerLiteralExpression expression = new IntegerLiteralExpression(42);
    	VariableInitializer varInit = new VariableInitializer("=", expression);
    	VariableDeclaratorId varDecId = new VariableDeclaratorId("x");
    	LocalVariableDeclarationStatement localVarDec = new LocalVariableDeclarationStatement(varDecId, varInit);
    	MethodBody methodBod = new MethodBody(localVarDec);
    	MethodDeclaration methodDec = new MethodDeclaration(modifiers, "void", "main", parameters, methodBod);
    	ClassBody classBod = new ClassBody(methodDec);
    	
    	List<String> modifiersForClass = new ArrayList<String>();
    	modifiersForClass.add("public");
    	
        Node root = new ClassDeclaration("Example", modifiersForClass, classBod);
        root.printNodeReflection(0);
    }
}
