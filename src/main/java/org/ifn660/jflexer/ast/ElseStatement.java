package org.ifn660.jflexer.ast;

public class ElseStatement extends Statement{
    private Statement elseStatement;
    
    private LexicalScope scope;
    
    public ElseStatement(Statement elseStatement) {
        this.elseStatement = elseStatement;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        elseStatement.resolveNames(scope);
    }
    @Override
    public void passVariables(String variable)  {
        
        
            elseStatement.passVariables(variable);
            //System.out.println(variable);
           // System.out.println("&&&&&&");
        //methodBody.passVariables(variable);
        
     }

}
