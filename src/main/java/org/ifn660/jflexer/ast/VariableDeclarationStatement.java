package org.ifn660.jflexer.ast;

public class VariableDeclarationStatement extends Statement {
    private String type; // TODO need to switch to Enum Type later??
    
    private String name;
    
    private Expression rhs;
    
    

    public VariableDeclarationStatement(String type, String name, Expression rhs) {
        super();
        this.type = type;
        this.name = name;
        this.rhs = rhs;
    }



    @Override
    public void printNode() {
        System.out.println(type);
        System.out.println(name);
        rhs.printNode();
    }

}
