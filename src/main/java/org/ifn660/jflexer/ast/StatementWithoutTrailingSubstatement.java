package org.ifn660.jflexer.ast;

import java.util.List;

public class StatementWithoutTrailingSubstatement extends Statement {
    private List<Statement> statements;

    public StatementWithoutTrailingSubstatement(List<Statement> statements) {
        this.statements = statements;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        for(Statement statement : statements) {
            statement.resolveNames(scope);
        }
    }
    
}
