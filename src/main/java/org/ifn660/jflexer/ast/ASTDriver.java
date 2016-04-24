package org.ifn660.jflexer.ast;

import java.util.ArrayList;
import java.util.List;

public class ASTDriver {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
    	ArrayList<String> modifiers = new ArrayList<String>();
    	modifiers.add("public");
    	modifiers.add("static");
    	
    	ElementType elementtype = new ElementType("String");
    	Type atype = new ArrayType(elementtype);
    	List<Parameter> parameters = new ArrayList<Parameter>();
    	Parameter parameter = new Parameter(atype, "args");
    	parameters.add(parameter);
    	
    	IntegerLiteralExpression expression = new IntegerLiteralExpression(42);
    	VariableInitializer varInit = new VariableInitializer(expression);
    	VariableDeclaratorId varDecId = new VariableDeclaratorId("x");
    	Type itype = new NamedType("int");
    	LocalVariableDeclarationStatement localVarDec = new LocalVariableDeclarationStatement(itype, varDecId, varInit);
    	MethodBody methodBod = new MethodBody(localVarDec);
    	
    	Type type = new NamedType("void");
    	Result result = new Result(type);
    	MethodDeclaration methodDec = new MethodDeclaration(modifiers, result, "main", parameters, methodBod);
    	ClassBody classBody = new ClassBody(methodDec);
    	
    	List<String> modifiersForClass = new ArrayList<String>();
    	modifiersForClass.add("public");
    	
        //Node root = new ClassDeclaration("Example", modifiersForClass, classBody);
        Node root = new ClassDeclaration("Example");
        root.printNodeReflection(0);
    }
}
