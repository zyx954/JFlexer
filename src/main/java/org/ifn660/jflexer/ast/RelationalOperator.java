package org.ifn660.jflexer.ast;

public class RelationalOperator extends Node{
    private String operator;

    public RelationalOperator(String operator) {
        this.operator = operator;
    }
}
