package org.ifn660.jflexer.ast;

import java.util.List;

public class StatementWithoutTrailingSubstatement extends Statement {
    private List<Statement> statements;

    public StatementWithoutTrailingSubstatement(List<Statement> statements) {
        this.statements = statements;
    }
    
}
