package org.ifn660.jflexer.ast;

public class AssignmentExpression extends Expression {
    private IdentifierExpression leftHandSide;
    private AssignmentOperator assignmentOperator;
    private Expression expression;
    
    public AssignmentExpression(IdentifierExpression leftHandSide, AssignmentOperator assignmentOperator,
            Expression expression) {
        this.leftHandSide = leftHandSide;
        this.assignmentOperator = assignmentOperator;
        this.expression = expression;
    }
    
    @Override
    public void resolveNames(LexicalScope scope) {
        leftHandSide.resolveNames(scope);
        expression.resolveNames(scope);
    }
}
