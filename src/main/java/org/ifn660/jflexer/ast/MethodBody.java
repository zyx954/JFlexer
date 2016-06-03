package org.ifn660.jflexer.ast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.ifn660.jflexer.cil.CIL;
import org.ifn660.jflexer.cil.CILOption;

public class MethodBody extends Node {
    private List<Statement> statements;

    private LexicalScope scope;

    public MethodBody(List<Statement> localVarDec) {
        this.statements = localVarDec;
        this.scope = new LexicalScope();
    }

    @Override
    public void resolveNames(LexicalScope scope) {
        // the scope from whom invoked this method is the parent scope
        this.scope.parentScope = scope;//here the parent scope is the creat by the classbody. with one hashmap. so we can call the parentScope to 
        
        //we can call --- this.scope.parentScope.sympaltable  OR  the this.scope.symbolTable

        // add all declaration statement to the symbol table of method scope
        for (Statement statement : statements) {
            // check if this is the statement belongs to declaration type
            // currently there are only two candidiates :
            // LocalVariableDeclarationStatement and FieldDeclaration
            if (statement instanceof Declaration) {
                Declaration declaration = (Declaration) statement;
                // if this is true, then record that declaration in the symbol
                // table
                this.scope.symbolTable.put(declaration.getName(), declaration);
                //zyx here continus to add the has code into this scope 
                
            }
        }

        for (Statement statement : statements) {
            statement.resolveNames(this.scope);
        }
        //System.out.println(this.scope.parentScope.symbolTable.values());
//        for (String key :this.scope.parentScope.symbolTable.keySet())
//                {
//                System.out.println(key);
//            
//            
//                }
//        System.out.println("00000000000000");
    }
    
    @Override
    public String passVariables(String variable)  {
        
        for (Statement statement : statements) {
           statement.passVariables(variable);
        }
        //methodBody.passVariables(variable);
        //System.out.println(variable);
        return variable;

     }

	@Override
	public void codeGeneration(Path path, CILOption cilOption) throws IOException {
		emit(path, CIL.TWO_IDENT + ".entrypoint\r\n" + CIL.TWO_IDENT + ".locals init (");
		
        boolean firstOne = true;		
        for (Statement statement : statements) {
			if (Declaration.class.isInstance(statement)){	           
		           if (firstOne) {
		                firstOne = false;
		            } else {
		            	emit(path, ",\r\n" + CIL.THREE_IDENT);
		            }
		           statement.codeGeneration(path, CILOption.DECLARE);
		       }
	    }
        
        emit(path, ")\r\n");       
        for (Statement statement : statements) {
			if (Declaration.class.isInstance(statement)){	           
		           statement.codeGeneration(path, CILOption.INIT);
		       }
	    }  
         
		for (Statement statement : statements) {
			if (!Declaration.class.isInstance(statement)){	          
		   	        statement.codeGeneration(path, cilOption);
		      }
	    }
		
		emit(path, CIL.TWO_IDENT + "ret\r\n");   
	}
}
