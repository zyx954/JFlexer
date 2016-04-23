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
    	
    	Type itype = new NamedType("int");
    	IntegerLiteralExpression expression = new IntegerLiteralExpression(42);
    	VariableDeclaratorId varDecId = new VariableDeclaratorId("x");
    	VariableInitializer varInit = new VariableInitializer(varDecId,expression);
    	
    	LocalVariableDeclarationStatement localVarDec = new LocalVariableDeclarationStatement(itype,varInit);
    	MethodBody methodBod = new MethodBody(localVarDec);
    	
    	Type type = new NamedType("void");
    	Result result = new Result(type);
    	MethodDeclaration methodDec = new MethodDeclaration(modifiers, result, "main", parameters, methodBod);
    	ClassBody classBody = new ClassBody(methodDec);
    	
    	List<String> modifiersForClass = new ArrayList<String>();
    	modifiersForClass.add("public");
    	
        Node root = new ClassDeclaration("Example", modifiersForClass, classBody);
        root.printNodeReflection(0);
    }
}
