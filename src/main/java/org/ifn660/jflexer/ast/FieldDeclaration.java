package org.ifn660.jflexer.ast;

import java.util.List;

public class FieldDeclaration extends Declaration {
   // private List<String>  FieldModifier;
   // private String  FieldModifier;
    private Type type;
    private IdentifierNode identifiernode;
    private VariableInitializer varInit;
    
    public FieldDeclaration( Type type,IdentifierNode identifiernode, VariableInitializer varInit) 
    {
        
        //this.FieldModifier = fieldModifier;
        this.type = type;
        this.identifiernode = identifiernode;
        this.varInit = varInit;
    }
 
}
