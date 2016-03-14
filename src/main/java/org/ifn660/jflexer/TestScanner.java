package org.ifn660.jflexer;

import static org.ifn660.jflexer.type.TokenType.*;
import org.ifn660.jflexer.type.TokenType;
import java.io.FileReader;
import java.io.IOException;

public class TestScanner {
    public static void main(String[] args) {
        System.out.println("Scanning [" + args[0] + "]");
        try {
            Yylex scanner = new Yylex(new FileReader("resources" + "/" + args[0]));

            TokenType token;
            do {
                token = scanner.yylex();
                System.out.println("Read: " + scanner.yytext() + " it is a " + token);
                
                
            } while (token != EOF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
