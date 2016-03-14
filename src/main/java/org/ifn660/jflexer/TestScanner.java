package org.ifn660.jflexer;

import static org.ifn660.jflexer.type.TokenType.*;

import org.ifn660.jflexer.symbol.Symbol;
import org.ifn660.jflexer.type.TokenType;

import java.io.FileReader;
import java.io.IOException;

public class TestScanner {
    public static void main(String[] args) {
        System.out.println("Scanning [" + args[0] + "]");
        try {
            Lexer scanner = new Lexer(new FileReader("resources" + "/" + args[0]));

            Symbol symbol;
            do {
                symbol = scanner.yylex();
                System.out.println("Read symbol: " + scanner.yytext() + "\n\t it is a " 
                        + symbol.getType() + " at line " + symbol.getLine() 
                        + " at column " + symbol.getColumn());
                
                
            } while (symbol.getType() != TokenType.EOF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
