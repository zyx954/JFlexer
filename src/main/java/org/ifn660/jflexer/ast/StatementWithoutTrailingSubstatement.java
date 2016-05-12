package org.ifn660.jflexer.ast;

import java.util.List;

public class StatementWithoutTrailingSubstatement extends Statement {
    private List<Statement> statements;
    
    private LexicalScope scope;

    public StatementWithoutTrailingSubstatement(List<Statement> statements) {
        this.statements = statements;
        this.scope = new LexicalScope();
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        // the scope from whom invoked this method is the parent scope
        this.scope.parentScope = scope;
        
        // add all declaration statement to the symbol table of method scope
        for(Statement statement : statements) {
            // check if this is the statement belongs to declaration type
            // currently there are only two candidiates : 
            // LocalVariableDeclarationStatement and FieldDeclaration
            if (statement instanceof Declaration) {
                Declaration declaration = (Declaration) statement;
                // if this is true, then record that declaration in the symbol table
                this.scope.symbolTable.put(declaration.getName(), declaration);
            }
        }
        
        for(Statement statement : statements) {
            statement.resolveNames(this.scope);
        }
    }
    
}
