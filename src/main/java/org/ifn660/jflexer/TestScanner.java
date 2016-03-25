package org.ifn660.jflexer;

import java_cup.runtime.*;

import java.io.FileReader;
import java.io.IOException;

public class TestScanner {
    public static void main(String[] args) {
        System.out.println("Scanning [" + args[0] + "]");
        try {
            Lexer scanner = new Lexer(new FileReader("resources/" + args[0]));

            Symbol symbol;
            do {
                symbol = scanner.next_token(); // as CUP parser expects a next_token method instead of yylex
                System.out.println("Read symbol: " + scanner.yytext() + "\n\t it is a " 
                        + symbol.sym + " aka (" + sym.terminalNames[symbol.sym]  + ")" + "\n\t at line " + symbol.left
                        + " at column " + symbol.right + "\n\t value: " + symbol.value + "\n"); // Puts the value of a terminal in the value instance variable
                
                
            } while (symbol.sym != sym.EOF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
