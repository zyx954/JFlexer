package org.ifn660.jflexer.ast;

public class BinaryExpression extends Expression {
    private Expression leftHandSide;
    private BinaryOperator operator;
    private Expression rightHandSide;
    
    public BinaryExpression(Expression leftHandSide, Expression rightHandSide, BinaryOperator operator) {
        this.leftHandSide = leftHandSide;
        this.operator = operator;
        this.rightHandSide = rightHandSide;
    }
    
    
}
