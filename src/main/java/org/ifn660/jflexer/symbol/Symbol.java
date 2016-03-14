package org.ifn660.jflexer.symbol;

import org.ifn660.jflexer.type.TokenType;

/**
 * this is a class to temporary simulate the real CUP Symbol class
 *
 */
public class Symbol {
    private TokenType type;
    private int line;
    private int column;
    private Object value;
    
    public Symbol(TokenType type, int line, int column) {
        this.type = type;
        this.line = line;
        this.column = column;
    }
    
    
    public Symbol(TokenType type, int line, int column, Object value) {
        this.type = type;
        this.line = line;
        this.column = column;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }


    public Object getValue() {
        return value;
    }
    
    
}
